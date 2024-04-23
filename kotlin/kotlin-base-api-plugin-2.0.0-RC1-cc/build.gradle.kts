import org.jetbrains.kotlin.gradle.plugin.KotlinBaseApiPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0-RC1" apply false
}

apply<KotlinBaseApiPlugin>()
plugins.withType(KotlinBaseApiPlugin::class) {
    registerKotlinJvmCompileTask("reproduce", "reproducer")
}

val compileGradleApiKotlinExtensions = tasks.named("reproduce", KotlinCompile::class) {
    source(layout.projectDirectory.dir("src"))
    destinationDirectory = layout.buildDirectory.dir("classes/reproducer")
    multiPlatformEnabled = false
}
