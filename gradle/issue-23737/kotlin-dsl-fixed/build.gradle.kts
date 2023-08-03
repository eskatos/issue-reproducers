import java.sql.Driver
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

task("list") {
    doLast {
        val knownDrivers = listOf(
            "org.h2.Driver",
            "org.postgresql.Driver",
            "org.sqlite.JDBC",
            "com.mysql.cj.jdbc.Driver",
        )
        knownDrivers.forEach { driverName ->
            try {
                val driver = javaClass.classLoader.loadClass(driverName).getDeclaredConstructor().newInstance()
                DriverManager.registerDriver(driver as Driver)
            } catch (e: Exception) {
                logger.debug("Driver '$driverName' not present")
            }
        }
        logger.quiet(
            "Drivers:\n${
                DriverManager.getDrivers().asSequence().map { "  ${it::class.java.name}" }.joinToString("\n")
            }"
        )
    }
}
