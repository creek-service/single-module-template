plugins {
    java
    jacoco
    `creek-common-convention`
    `creek-module-convention`
    `creek-coverage-convention`
    `creek-publishing-convention`
    `creek-sonatype-publishing-convention`
    id("pl.allegro.tech.build.axion-release") version "1.14.3" // https://plugins.gradle.org/plugin/pl.allegro.tech.build.axion-release
}

project.version = scmVersion.version

val creekVersion = "0.3.1-SNAPSHOT"
val guavaVersion = "31.1-jre"         // https://mvnrepository.com/artifact/com.google.guava/guava
val log4jVersion = "2.19.0"           // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
val junitVersion = "5.9.2"            // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
val junitPioneerVersion = "1.9.1"     // https://mvnrepository.com/artifact/org.junit-pioneer/junit-pioneer
val mockitoVersion = "4.11.0"          // https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
val hamcrestVersion = "2.2"           // https://mvnrepository.com/artifact/org.hamcrest/hamcrest-core

dependencies {
    testImplementation("org.creekservice:creek-test-hamcrest:$creekVersion")
    testImplementation("org.creekservice:creek-test-util:$creekVersion")
    testImplementation("org.creekservice:creek-test-conformity:$creekVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("org.junit-pioneer:junit-pioneer:$junitPioneerVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testImplementation("org.hamcrest:hamcrest-core:$hamcrestVersion")
    testImplementation("com.google.guava:guava-testlib:$guavaVersion")
    testImplementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:$log4jVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

defaultTasks("format", "static", "check")
