package play

import java.math.BigInteger

private class TwoElementStack<T>(
    smallerElement: T,
    largerElement: T
) {

    var smaller: T = smallerElement
    var larger: T = largerElement

    /**
     * pushes a new element onto the stack and pops the last element
     */
    fun push(newElement: T) {
        smaller = larger
        larger = newElement
    }

    fun asList(): List<T> = listOf(smaller, larger)
}

val fibonacciSequence = sequence<BigInteger> {
    val f0 = BigInteger.ZERO
    val f1 = BigInteger.ONE

    yield(f0)
    yield(f1)

    val stack = TwoElementStack(f0, f1)

    while (true) {
        val cur = stack.asList().reduce { acc, l -> acc + l }
        yield(cur)
        stack.push(cur)
    }
}

fun fibonacciNumber(n: Int): BigInteger {
    return fibonacciSequence.elementAt(n)
}
