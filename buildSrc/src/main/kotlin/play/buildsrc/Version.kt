package play.buildsrc

import org.gradle.api.Project.DEFAULT_VERSION
import java.io.BufferedReader
import java.io.InputStreamReader

object Version {

    /**
     * Get the current project version from git (tags).
     *
     * @return the version string (without prefix 'v') OR [DEFAULT_VERSION].
     */
    fun getVersionFromGit(): String {
        try {
            val process = Runtime.getRuntime().exec("git describe --tags --dirty --always")
            val reader = BufferedReader(InputStreamReader(process.inputStream))

            var line = reader.readLine()
            while (line != null) {

                if (line.startsWith("v")) {
                    return line.substring(1 until line.length)
                }

                line = reader.readLine()
            }
        } catch (ex: Throwable) {
            println("Could NOT receive version information from git. gradle's default version will be used. ")
            ex.printStackTrace()
        }

        return DEFAULT_VERSION
    }
}
