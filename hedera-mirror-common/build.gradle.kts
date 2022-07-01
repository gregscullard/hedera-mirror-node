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
}

val testClasses by configurations.creating

description = "Hedera Mirror Node Common"

dependencies {
    api(libs.guava)
    api(libs.hederaProtobuf) { isTransitive = false }
    api(libs.hibernateTypes)
    api(libs.protobuf)
    api(libs.tuweni)
    api("commons-codec:commons-codec")
    api("com.fasterxml.jackson.core:jackson-databind")
    api("io.projectreactor:reactor-core")
    api("org.apache.commons:commons-lang3")
    api("org.hibernate:hibernate-jpamodelgen")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-log4j2")
    testImplementation(libs.besu)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testClasses(sourceSets["test"].output)
}
