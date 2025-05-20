

fun commonConfigurationFor8x(): Exec.() -> Unit = {
    commandLine = listOf("echo", "It works with Gradle 8.x!")
}
// This resolves differently in 8.x (Kotlin 2.0.21 with Kotlin Language 1.8)
// than in 9.0 (Kotlin 2.1.21 with Kotlin language 2.1)
// and fails at execution time.
// https://scans.gradle.com/s/c7hz6qt5mrqio/console-log?page=1#L8
// This is a breaking change from Gradle 8.x to 9.0
tasks.register("hello8", Exec::class, commonConfigurationFor8x())


// This is one way to fix the new compilation error
fun commonConfigurationFor9x() = Action<Exec> {
    commandLine = listOf("echo", "It works with Gradle 9.x!")
}
tasks.register("hello9", Exec::class, commonConfigurationFor9x())

// It seems the Kotlin compiler changed the function resolution order
// or how willing it is to consider Action<T> an alias for T.() -> Unit
// with its implicit-receiver plugin.
