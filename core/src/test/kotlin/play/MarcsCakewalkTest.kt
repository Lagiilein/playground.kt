package play

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.longs.shouldBeExactly

internal class MarcsCakewalkTest : FunSpec({
    test("Test marcs cakewalk function against precalculated output") {
        marcsCakewalk(listOf(5, 10, 7)) shouldBeExactly 44
        marcsCakewalk(arrayOf(1, 3, 2).toList()) shouldBeExactly 11
        marcsCakewalk(intArrayOf(7, 4, 9, 6).toList()) shouldBeExactly 79
    }
})
