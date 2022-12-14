@file:Suppress("MoveLambdaOutsideParentheses")

package com.bkosm.kpipe

import org.junit.jupiter.api.Test
import kotlin.test.expect

class KPipeTest {
    @Test
    fun `of 1`() {
        val res = KPipe(
            2,
            { times(3) },
        )

        expect(6) { res }
    }

    @Test
    fun `of 2`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
        )

        expect(8) { res }
    }

    @Test
    fun `of 3`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
        )

        expect("88") { res }
    }

    @Test
    fun `of 4`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") }
        )

        expect(listOf("", "8", "8", "")) { res }
    }

    @Test
    fun `of 5`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
        )

        expect(listOf("8", "8")) { res }
    }

    @Test
    fun `of 6`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
            { this + it.toString() },
        )

        expect(listOf("8", "8", "2")) { res }
    }

    @Test
    fun `of 7`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
            { this + it.toString() },
            { start -> map { it.toInt() + start } }
        )

        expect(listOf(10, 10, 4)) { res }
    }

    @Test
    fun `of 8`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
            { this + it.toString() },
            { start -> map { it.toInt() + start } },
            { sum() }
        )

        expect(24) { res }
    }

    @Test
    fun `of 9`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
            { this + it.toString() },
            { start -> map { it.toInt() + start } },
            { sum() },
            { it to this }
        )

        expect(2 to 24) { res }
    }

    @Test
    fun `of 10`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
            { this + it.toString() },
            { start -> map { it.toInt() + start } },
            { sum() },
            { it to this },
            { (first + it) to (second - it) }
        )

        expect(4 to 22) { res }
    }

    @Test
    fun `of 11`() {
        val res = KPipe(
            2,
            { times(3) },
            { it + this },
            { toString() + this },
            { split("") },
            { filter { it.isNotEmpty() } },
            { this + it.toString() },
            { start -> map { it.toInt() + start } },
            { sum() },
            { it to this },
            { (first + it) to (second - it) },
            { toList().joinToString(it.toString()) }
        )

        expect("4222") { res }
    }

    @Test
    fun `full formal test`() {
        val full = kp(
            1,
            { expect(1) { this }; expect(1) { it }; 2 },
            { expect(2) { this }; expect(1) { it }; 3 },
            { expect(3) { this }; expect(1) { it }; 4 },
            { expect(4) { this }; expect(1) { it }; 5 },
            { expect(5) { this }; expect(1) { it }; 6 },
            { expect(6) { this }; expect(1) { it }; 7 },
            { expect(7) { this }; expect(1) { it }; 8 },
            { expect(8) { this }; expect(1) { it }; 9 },
            { expect(9) { this }; expect(1) { it }; 10 },
            { expect(10) { this }; expect(1) { it }; 11 },
            { expect(11) { this }; expect(1) { it }; 12 },
        )
        expect(12) { full }
    }
}
