package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.lang.management.ManagementFactory

internal class PrintJavaVersionTest {

    @Test
    @Disabled
    fun `print java version`() {
        StringBuilder().apply {
            val runtime = ManagementFactory.getRuntimeMXBean()
            appendLine("Name:                       ${runtime.name}")
            appendLine("Spec Name:                  ${runtime.specName}")
            appendLine("Spec Version:               ${runtime.specVersion}")
            appendLine("Spec Vendor:                ${runtime.specVendor}")
            appendLine("VM Name:                    ${runtime.vmName}")
            appendLine("VM Version:                 ${runtime.vmVersion}")
            appendLine("VM Vendor:                  ${runtime.vmVendor}")
            appendLine("Management Spec Version:    ${runtime.managementSpecVersion}")
            appendLine("Class Path:                 ${runtime.classPath}")
            appendLine("Library Path:               ${runtime.libraryPath}")
            appendLine("Input Arguments:            ${runtime.inputArguments}")
            appendLine("System Properties: ")

            for ((key, value) in runtime.systemProperties) {
                appendLine("                            - $key : $value")
            }

            val os = ManagementFactory.getOperatingSystemMXBean()
            appendLine("OS Name:                    ${os.name}")
            appendLine("OS Version:                 ${os.version}")
            appendLine("OS Arch:                    ${os.arch}")
            appendLine("OS Available Processors:    ${os.availableProcessors}")
            appendLine("OS System Load Average:     ${os.systemLoadAverage}")

            appendLine("Non Heap Memory Usage:      ${ManagementFactory.getMemoryMXBean().nonHeapMemoryUsage}")

            val compilation = ManagementFactory.getCompilationMXBean()
            appendLine("Compilation Name:           ${compilation.name}")
            appendLine("Compilation Time:           ${compilation.totalCompilationTime}")
            appendLine("Compilation Monitoring Sup: ${compilation.isCompilationTimeMonitoringSupported}")

            print(toString())
        }
    }
}
