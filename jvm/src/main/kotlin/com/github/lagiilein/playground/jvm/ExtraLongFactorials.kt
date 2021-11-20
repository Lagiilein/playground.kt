package com.github.lagiilein.playground.jvm

import java.math.BigInteger

val factorials = sequence {

    var i = 0L
    var privious = BigInteger.ONE

    while (true) {
        i++

        val cur = privious * BigInteger.valueOf(i)
        yield(cur)
        privious = cur
    }
}

/**
 * [https://www.hackerrank.com/challenges/extra-long-factorials/problem]
 */
fun extraLongFactorials(n: Int): BigInteger {
    // Write your code here
    return factorials.elementAt(n - 1)
}
