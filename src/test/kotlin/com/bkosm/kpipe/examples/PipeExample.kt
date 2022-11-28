package com.bkosm.kpipe.examples

import com.bkosm.kpipe.pipe
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.expect

class PipeExample {
    @JvmInline
    value class EID(private val value: String) {
        init {
            require(value.isNotEmpty() && value.isNotBlank())
        }
    }

    sealed interface Event {
        val id: EID

        data class Initialized(override val id: EID, val timestamp: String) : Event
    }

    interface EventStore {
        fun get(id: EID): Result<Event>
        fun store(event: Event): Result<Unit>

        companion object {
            val InMemory = object : EventStore {
                private val storage = mutableMapOf<EID, Event>()
                override fun get(id: EID) = pipe(
                    id,
                    storage::get,
                    { runCatching { it!! } }
                )

                override fun store(event: Event) = pipe(
                    event,
                    { storage[it.id] = it },
                    Result.Companion::success
                )

            }
        }
    }

    @Test
    fun `can store and retrieve events`() {
        // given
        val uut = EventStore.InMemory
        val id = EID("1")
        val event = Event.Initialized(id, "2077-03-03T10:15:30Z")

        // when/then
        pipe(
            id,
            uut::get,
            { assertTrue { it.isFailure } },
        )

        pipe(
            event,
            uut::store,
            { assertTrue { it.isSuccess } },
        )

        pipe(
            id,
            uut::get,
            { assertTrue { it.isSuccess }; it.getOrThrow() },
            { expect(event) { it } }
        )
    }
}
