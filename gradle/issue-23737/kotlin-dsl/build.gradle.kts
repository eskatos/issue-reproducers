import java.sql.DriverManager
buildscript {
    repositories { mavenCentral() }
    dependencies {
        classpath("com.h2database:h2:2.1.214")
        classpath("org.postgresql:postgresql:42.5.1")
        classpath("mysql:mysql-connector-java:8.0.33")
        classpath("org.xerial:sqlite-jdbc:3.42.0.0")
    }
}
tasks.register("list") {
    doLast {
        logger.quiet("Drivers:\n${DriverManager.getDrivers().asSequence().map { "  ${it::class.java.name}" }.joinToString("\n")}")
    }
}
