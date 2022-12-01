package com.bkosm.kpipe

class Pipe {
    companion object {
        inline operator fun <START, S1> invoke(
            initial: START,
            step1: (START) -> S1,
        ) = step1(initial)

        inline operator fun <START, S1, S2> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
        ) = step2(step1(initial))

        inline operator fun <START, S1, S2, S3> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
        ) = step3(step2(step1(initial)))

        inline operator fun <START, S1, S2, S3, S4> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
        ) = step4(step3(step2(step1(initial))))

        inline operator fun <START, S1, S2, S3, S4, S5> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
        ) = step5(step4(step3(step2(step1(initial)))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6> invoke(
            initial: START,
            step1: (START) -> S1,
            step2: (S1) -> S2,
            step3: (S2) -> S3,
            step4: (S3) -> S4,
            step5: (S4) -> S5,
            step6: (S5) -> S6,
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
        ) = step10(step9(step8(step7(step6(step5(step4(step3(step2(step1(initial))))))))))

        inline operator fun <START, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11> invoke(
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
            step11: (S10) -> S11,
        ) = step11(step10(step9(step8(step7(step6(step5(step4(step3(step2(step1(initial)))))))))))
    }
}
