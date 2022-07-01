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

description = "Hedera Mirror Node Importer"

dependencies {
    implementation(project(":hedera-mirror-common"))
    implementation(platform(libs.aws))
    implementation(platform(libs.springCloud))
    implementation(platform(libs.springCloudGcp))
    implementation(libs.commonsCompress)
    implementation(libs.commonsIo)
    implementation(libs.headlong)
    implementation(libs.javaxInject)
    implementation(libs.micrometerExtra)
    implementation(libs.msgpack)
    implementation(libs.velocity)
    implementation(libs.web3j)
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("com.google.cloud:spring-cloud-gcp-starter-pubsub")
    implementation("io.micrometer:micrometer-registry-elastic")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-kubernetes-fabric8-leader")
    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-fabric8-config")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.integration:spring-integration-core")
    implementation("software.amazon.awssdk:netty-nio-client")
    implementation("software.amazon.awssdk:s3")
    implementation("software.amazon.awssdk:sts")
    testImplementation(libs.commonsBeanutils)
    testImplementation(libs.s3proxy)
    testImplementation(libs.sqlFormatter)
    testImplementation(libs.testcontainers)
    testImplementation(libs.testcontainersGooglePubSub)
    testImplementation(libs.testcontainersPostgresql)
    testImplementation(libs.testcontainersRedis)
    testImplementation(project(path = ":hedera-mirror-common", configuration = "testClasses"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}
