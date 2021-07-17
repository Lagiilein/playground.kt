package play

/**
 * [https://leetcode.com/problems/two-sum/]
 */
fun twoSum(nums: IntArray, target: Int): IntArray {

    for (i in nums.indices) {
        for (j in (i + 1) until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }

    throw Exception("No solution. ")
}

fun twoSumFast(nums: IntArray, target: Int): IntArray {

    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices.reversed()) {
        val j = map[target - nums[i]]

        if (j != null) {
            return intArrayOf(i, j)
        } else {
            map[nums[i]] = i
        }
    }

    throw Exception("No solution. ")
}
