package com.bkosm.kpipe


class Pipe {
    @Suppress("UNUSED_PARAMETER")
    companion object {
        inline operator fun <START, S1> invoke(
            initial: START,
            step1: (START) -> S1,
            hintStop: Unit = Unit
        ) = step1(initial)

        inline operator fun <START, S1, S2> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            hintStop: Unit = Unit
        ) = step2(step1(initial))

        inline operator fun <START, S1, S2, S3> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            hintStop: Unit = Unit
        ) = step3(step2(step1(initial)))

        inline operator fun <START, S1, S2, S3, S4> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            hintStop: Unit = Unit
        ) = step4(step3(step2(step1(initial))))

        inline operator fun <START, S1, S2, S3, S4, S5> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            hintStop: Unit = Unit
        ) = step5(step4(step3(step2(step1(initial)))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            step6: (S5) -> S6,
            hintStop: Unit = Unit
        ) = step6(step5(step4(step3(step2(step1(initial))))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            step6: (S5) -> S6,
            step7: (S6) -> S7,
            hintStop: Unit = Unit
        ) = step7(step6(step5(step4(step3(step2(step1(initial)))))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            step6: (S5) -> S6,
            step7: (S6) -> S7,
            step8: (S7) -> S8,
            hintStop: Unit = Unit
        ) = step8(step7(step6(step5(step4(step3(step2(step1(initial))))))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8, S9> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            step6: (S5) -> S6,
            step7: (S6) -> S7,
            step8: (S7) -> S8,
            step9: (S8) -> S9,
            hintStop: Unit = Unit
        ) = step9(step8(step7(step6(step5(step4(step3(step2(step1(initial)))))))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            step6: (S5) -> S6,
            step7: (S6) -> S7,
            step8: (S7) -> S8,
            step9: (S8) -> S9,
            step10: (S9) -> S10,
            hintStop: Unit = Unit
        ) = step10(step9(step8(step7(step6(step5(step4(step3(step2(step1(initial))))))))))
    }
}
