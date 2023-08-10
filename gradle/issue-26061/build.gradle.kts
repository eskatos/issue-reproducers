plugins {
    id("java")
    id("org.graalvm.buildtools.native") version "0.9.24"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20)) // <-- there error occurs here
    }
}

graalvmNative {
    binaries {
        named("main") {
            javaLauncher.set(javaToolchains.launcherFor {
                languageVersion.set(JavaLanguageVersion.of(20))
            })
        }
    }
}
