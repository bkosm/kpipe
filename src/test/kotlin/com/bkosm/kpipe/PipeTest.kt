@file:Suppress("MoveLambdaOutsideParentheses")

package com.bkosm.kpipe

import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.test.expect

internal class PipeTest {
    @Test
    fun `of 1`() {
        val res = Pipe(
            2,
            { it * 3 },
        )

        expect(6) { res }
    }

    @Test
    fun `of 2`() {
        val res = Pipe(
            2,
            { it * 3 },
            Int::toString,
        )

        expect("6") { res }
    }

    @Test
    fun `of 3`() {
        val res = Pipe(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
        )

        expect(6.0) { res }
    }

    @Test
    fun `of 4`() {
        val res = Pipe(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
        )

        expect(36.0) { res }
    }

    @Test
    fun `of 5`() {
        val res = Pipe(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
        )

        expect("36.0") { res }
    }

    @Test
    fun `of 6`() {
        val res = Pipe(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
            { it.split("") },
        )

        expect(listOf("", "3", "6", ".", "0", "")) { res }
    }

    @Test
    fun `of 7`() {
        val res = Pipe(2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
            { it.split("") },
            { it.filter { c -> c.isNotBlank() } })

        expect(listOf("3", "6", ".", "0")) { res }
    }

    @Test
    fun `of 8`() {
        val res = Pipe(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
            { it.split("") },
            { it.filter { c -> c.isNotBlank() } },
            { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
        )

        expect(listOf("33", "66", ".", "00")) { res }
    }

    @Test
    fun `of 9`() {
        val res = pipe(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
            { it.split("") },
            { it.filter { c -> c.isNotBlank() } },
            { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
            { it.joinToString("") },
        )

        expect("3366.00") { res }
    }

    @Test
    fun `of 10`() {
        val res = p(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
            { it.split("") },
            { it.filter { c -> c.isNotBlank() } },
            { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
            { it.joinToString("") },
            String::toDouble,
        )

        expect(3366.0) { res }
    }

    @Test
    fun `of 11`() {
        val res = p(
            2,
            { it * 3 },
            Int::toString,
            String::toDouble,
            { it.pow(2) },
            Double::toString,
            { it.split("") },
            { it.filter { c -> c.isNotBlank() } },
            { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
            { it.joinToString("") },
            String::toDouble,
            { it / 2 },
        )

        expect(1683.0) { res }
    }

    @Test
    fun `full formal test`() {
        val full = p(
            1,
            { expect(1) { it }; 2 },
            { expect(2) { it }; 3 },
            { expect(3) { it }; 4 },
            { expect(4) { it }; 5 },
            { expect(5) { it }; 6 },
            { expect(6) { it }; 7 },
            { expect(7) { it }; 8 },
            { expect(8) { it }; 9 },
            { expect(9) { it }; 10 },
            { expect(10) { it }; 11 },
            { expect(11) { it }; 12 },
        )
        expect(12) { full }
    }
}
