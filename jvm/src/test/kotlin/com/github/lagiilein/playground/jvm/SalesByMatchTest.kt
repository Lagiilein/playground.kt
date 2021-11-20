package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SalesByMatchTest {

    @Test
    fun `test sockMerchant`() {

        assertEquals(2, sockMerchant(7, arrayOf(1, 2, 1, 2, 1, 3, 2)))
        assertEquals(3, sockMerchant(9, arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)))
    }
}
