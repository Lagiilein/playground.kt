package play.buildsrc

import org.gradle.api.Project.DEFAULT_VERSION
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object Version {

    /**
     * Get the current project version from git (tags). This operation requires git to be on PATH.
     *
     * @return the version string (without prefix 'v') OR [DEFAULT_VERSION].
     */
    fun getVersionFromGit(): String {
        try {
            val process = Runtime.getRuntime().exec("git describe --tags --dirty --always")

            extractVersionFromInputStream(process.inputStream)?.let {
                return it
            }
        } catch (ex: Throwable) {
            println("Could NOT receive version information from git. gradle's default version will be used. ")
            ex.printStackTrace()
        }

        return DEFAULT_VERSION
    }

    @Throws(IOException::class)
    internal fun extractVersionFromInputStream(inputStream: InputStream): String? {
        val reader = BufferedReader(InputStreamReader(inputStream))

        do {
            val line = reader.readLine()
            if (line?.startsWith('v') == true) {
                return line.substring(1 until line.length)
            }
        } while (line !== null)

        return null
    }
}
