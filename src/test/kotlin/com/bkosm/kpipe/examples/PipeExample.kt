@file:Suppress("MoveLambdaOutsideParentheses")

package com.bkosm.kpipe.examples

import com.bkosm.kpipe.kpipe
import com.bkosm.kpipe.pipe
import org.junit.jupiter.api.Test
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.expect

class PipeExample {
    fun interface ValueFactory<PRIMITIVE : Any, TARGET : Any> {
        fun of(value: PRIMITIVE): TARGET
    }

    @JvmInline
    value class EID private constructor(private val value: String) {
        companion object : ValueFactory<String, EID> {
            override fun of(value: String) = pipe(
                value,
                { it.isNotEmpty() && it.isNotBlank() },
                ::require,
                { EID(value) }
            )
        }
    }

    sealed interface Event {
        val id: EID

        data class Initialized(override val id: EID, val timestamp: String) : Event
    }

    interface EventStore {
        fun get(id: EID): Event?
        fun store(event: Event): Result<Unit>
    }

    fun InMemoryEventStore() = object : EventStore {
        private val storage = mutableMapOf<EID, Event>()
        override fun get(id: EID) = pipe(
            id,
            storage::get
        )

        override fun store(event: Event) = pipe(
            event,
            { storage[it.id] = it },
            Result.Companion::success
        )
    }

    @Test
    fun `you can't create a blank EID`() {
        pipe(
            runCatching { EID.of("") }.exceptionOrNull(),
            { assertIs<IllegalArgumentException>(it) } // kotlin does not allow method reference with generics
        )
    }

    @Test
    fun `can store and retrieve events`() {
        // given
        val uut = InMemoryEventStore()
        val id = EID.of("1")
        val event = Event.Initialized(id, "2077-03-03T10:15:30Z")

        // when/then
        pipe(
            id,
            uut::get,
            ::assertNull,
        )

        kpipe(
            event,
            { uut.store(this) },
            { isSuccess },
            { assertTrue("Failed for event $it") { this } },
        )

        pipe(
            id,
            uut::get,
            { expect(event) { it } }
        )
    }
}
