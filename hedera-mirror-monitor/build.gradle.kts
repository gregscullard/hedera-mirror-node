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
    id("java")
    id("org.springframework.boot")
}

description = "Hedera Mirror Node Monitor"

dependencies {
    implementation(platform(libs.springCloud))
    implementation(libs.commonsMath)
    implementation(libs.guava)
    implementation(libs.hederaSdk)
    implementation(libs.javaxInject)
    implementation(libs.micrometerExtra)
    implementation(libs.springdoc)
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("io.grpc:grpc-netty")
    implementation("io.grpc:grpc-stub")
    implementation("io.micrometer:micrometer-registry-elastic")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("org.apache.commons:commons-lang3")
    implementation("org.springframework.boot:spring-boot-actuator-autoconfigure")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-fabric8-config")
    runtimeOnly("io.netty:netty-resolver-dns-native-macos")
    testImplementation(libs.meanbean)
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
