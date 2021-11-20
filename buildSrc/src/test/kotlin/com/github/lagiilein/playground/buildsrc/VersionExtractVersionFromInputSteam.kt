package com.github.lagiilein.playground.buildsrc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import java.io.ByteArrayInputStream

internal class VersionExtractVersionFromInputSteam {
    @TestFactory
    fun `test Version extractVersionFromInputStream`(): List<DynamicTest> {
        return listOf(
            Pair("1.0.1", StringBuilder().apply {
                appendLine("blabla")
                appendLine("v1.0.1")
                appendLine("hiii")
            }.toString()),
            Pair("dirty", StringBuilder().apply {
                appendLine("vdirty")
            }.toString()),
        ).map { (versionStr, str) ->
            return@map DynamicTest.dynamicTest(versionStr) {
                val inputStream = ByteArrayInputStream(str.toByteArray())
                Assertions.assertEquals(versionStr, Version.extractVersionFromInputStream(inputStream))
            }
        }
    }
}
