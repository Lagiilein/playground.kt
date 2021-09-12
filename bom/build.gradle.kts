dependencies {
    project.rootProject.allprojects.forEach {
        if (it == project || it == rootProject.rootProject) return@forEach

        api(it)
    }
}
