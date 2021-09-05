package play

import exception.NoSolutionException

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

    throw NoSolutionException()
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

    throw NoSolutionException()
}
