package com.bkosm.kpipe

/**
 * A pipe function that takes a starting value and a variable number of functions.
 * Parameters of subsequent functions are:
 * 1. result of last invocation as `this`
 * 2. initial piped expression as `it`
 * Returns the result of the last function invocation.
 * Supports up to 11 intermediate transformations.
 */
class KPipe {
    companion object {
        inline operator fun <START, S1> invoke(
            initial: START,
            step1: START.(START) -> S1,
        ) = initial.step1(initial)

        inline operator fun <START, S1, S2> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
        ) = invoke(initial, step1).step2(initial)

        inline operator fun <START, S1, S2, S3> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
        ) = invoke(initial, step1, step2).step3(initial)

        inline operator fun <START, S1, S2, S3, S4> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
        ) = invoke(initial, step1, step2, step3).step4(initial)

        inline operator fun <START, S1, S2, S3, S4, S5> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
        ) = invoke(initial, step1, step2, step3, step4).step5(initial)

        inline operator fun <START, S1, S2, S3, S4, S5, S6> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
            step6: S5.(START) -> S6,
        ) = invoke(initial, step1, step2, step3, step4, step5).step6(initial)

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
            step6: S5.(START) -> S6,
            step7: S6.(START) -> S7,
        ) = invoke(initial, step1, step2, step3, step4, step5, step6).step7(initial)

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
            step6: S5.(START) -> S6,
            step7: S6.(START) -> S7,
            step8: S7.(START) -> S8,
        ) = invoke(initial, step1, step2, step3, step4, step5, step6, step7).step8(initial)

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8, S9> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
            step6: S5.(START) -> S6,
            step7: S6.(START) -> S7,
            step8: S7.(START) -> S8,
            step9: S8.(START) -> S9,
        ) = invoke(initial, step1, step2, step3, step4, step5, step6, step7, step8).step9(initial)

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
            step6: S5.(START) -> S6,
            step7: S6.(START) -> S7,
            step8: S7.(START) -> S8,
            step9: S8.(START) -> S9,
            step10: S9.(START) -> S10,
        ) = invoke(initial, step1, step2, step3, step4, step5, step6, step7, step8, step9).step10(initial)

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11> invoke(
            initial: START,
            step1: START.(START) -> S1,
            step2: S1.(START) -> S2,
            step3: S2.(START) -> S3,
            step4: S3.(START) -> S4,
            step5: S4.(START) -> S5,
            step6: S5.(START) -> S6,
            step7: S6.(START) -> S7,
            step8: S7.(START) -> S8,
            step9: S8.(START) -> S9,
            step10: S9.(START) -> S10,
            step11: S10.(START) -> S11,
        ) = invoke(initial, step1, step2, step3, step4, step5, step6, step7, step8, step9, step10).step11(initial)
    }
}
