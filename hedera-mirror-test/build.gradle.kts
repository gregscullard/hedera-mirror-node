/*-
 * ‌
 * Hedera Mirror Node
 * ​
 * Copyright (C) 2019 - 2022 Hedera Hashgraph, LLC
 * ​
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ‍
 */

plugins {
    id("java-library")
    id("org.springframework.boot")
}

description = "Hedera Mirror Node Test"

dependencyManagement {
    imports {
        mavenBom("io.cucumber:cucumber-bom:7.4.1")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation(libs.hederaSdk)
    testImplementation(libs.javaxInject)
    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("io.cucumber:cucumber-spring")
    testImplementation("io.grpc:grpc-okhttp")
    testImplementation("org.apache.commons:commons-lang3")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("org.springframework.boot:spring-boot-autoconfigure")
    testImplementation("org.springframework.boot:spring-boot-starter-aop")
    testImplementation("org.springframework.boot:spring-boot-starter-log4j2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-validation")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.retry:spring-retry")
}

tasks.withType<Test> {
    jvmArgs = listOf("-Xmx1024m", "-Xms1024m")
    maxParallelForks = Runtime.getRuntime().availableProcessors()
    useJUnitPlatform {
        excludeTags("acceptance")
    }
}
