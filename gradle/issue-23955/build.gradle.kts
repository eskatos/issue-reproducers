import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

// Uncomment the afterEvaluate block to apply the workaround
// afterEvaluate {

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        apiVersion.set(KotlinVersion.KOTLIN_1_9)
        languageVersion.set(KotlinVersion.KOTLIN_1_9)
    }
}

// }

