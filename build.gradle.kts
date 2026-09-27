/*
 * Copyright 2023-2026 Creek Contributors (https://github.com/creek-service)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    java
    jacoco
    `creek-common-convention`
    `creek-module-convention`
    `creek-coverage-convention`
    `creek-publishing-convention`
    `creek-sonatype-publishing-convention`
    id("pl.allegro.tech.build.axion-release") version "1.21.3" // https://plugins.gradle.org/plugin/pl.allegro.tech.build.axion-release
}

project.version = scmVersion.version

allprojects {
    tasks.jar {
        onlyIf { sourceSets.main.get().allSource.files.isNotEmpty() }
    }
}

val creekVersion = project.property("creekVersion") as String
val junitVersion = project.property("junitVersion") as String

dependencies {
    testImplementation("org.creekservice:creek-test-hamcrest:$creekVersion")
    testImplementation("org.creekservice:creek-test-util:$creekVersion")
    testImplementation("org.creekservice:creek-test-conformity:$creekVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("org.junit-pioneer:junit-pioneer:${property("junitPioneerVersion")}")
    testImplementation("org.mockito:mockito-junit-jupiter:${property("mockitoVersion")}")
    testImplementation("com.google.guava:guava-testlib:${property("guavaVersion")}")
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:${property("log4jVersion")}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

defaultTasks("format", "static", "check")
