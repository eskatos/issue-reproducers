import org.jetbrains.kotlin.gradle.plugin.KotlinBaseApiPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0-RC1" apply false
}

apply<KotlinBaseApiPlugin>()
plugins.withType(KotlinBaseApiPlugin::class) {
    registerKotlinJvmCompileTask("compileGradleApiKotlinExtensions", "gradle-kotlin-dsl-extensions")
}

val compileGradleApiKotlinExtensions = tasks.named("compileGradleApiKotlinExtensions", KotlinCompile::class) {
    source(layout.projectDirectory.dir("src"))
    destinationDirectory = layout.buildDirectory.dir("classes/some")
    multiPlatformEnabled = false
}
