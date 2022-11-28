package com.bkosm.kpipe

import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.test.expect

internal class PipeTest {
    @Test
    fun `of 1`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
        )

        expect(6) { res }
    }

    @Test
    fun `of 2`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
        )

        expect("6") { res }
    }

    @Test
    fun `of 3`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
        )

        expect(6.0) { res }
    }

    @Test
    fun `of 4`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
        )

        expect(36.0) { res }
    }

    @Test
    fun `of 5`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
            step5 = Double::toString,
        )

        expect("36.0") { res }
    }

    @Test
    fun `of 6`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
            step5 = Double::toString,
            step6 = { it.split("") },
        )

        expect(listOf("", "3", "6", ".", "0", "")) { res }
    }

    @Test
    fun `of 7`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
            step5 = Double::toString,
            step6 = { it.split("") },
            step7 = { it.filter { c -> c.isNotBlank() } }
        )

        expect(listOf("3", "6", ".", "0")) { res }
    }

    @Test
    fun `of 8`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
            step5 = Double::toString,
            step6 = { it.split("") },
            step7 = { it.filter { c -> c.isNotBlank() } },
            step8 = { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
        )

        expect(listOf("33", "66", ".", "00")) { res }
    }

    @Test
    fun `of 9`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
            step5 = Double::toString,
            step6 = { it.split("") },
            step7 = { it.filter { c -> c.isNotBlank() } },
            step8 = { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
            step9 = { it.joinToString("") },
        )

        expect("3366.00") { res }
    }

    @Test
    fun `of 10`() {
        val res = Pipe(
            initial = 2,
            step1 = { it * 3 },
            step2 = Int::toString,
            step3 = String::toDouble,
            step4 = { it.pow(2) },
            step5 = Double::toString,
            step6 = { it.split("") },
            step7 = { it.filter { c -> c.isNotBlank() } },
            step8 = { it.map { c -> if (c.get(0) in '0'..'9') "$c$c" else c } },
            step9 = { it.joinToString("") },
            step10 = String::toDouble,
        )

        expect(3366.0) { res }
    }
}
