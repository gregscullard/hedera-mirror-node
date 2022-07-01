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

description = "Hedera Mirror Node GRPC API"

dependencies {
    implementation(platform(libs.springCloud))
    implementation(project(":hedera-mirror-common"))
    implementation(project(":hedera-mirror-protobuf"))
    implementation(libs.grpcSpringBoot)
    implementation(libs.javaxInject)
    implementation(libs.micrometerExtra)
    implementation(libs.msgpack)
    implementation(libs.scram)
    implementation(libs.vertx)
    implementation("com.fasterxml.jackson.core:jackson-core")
    implementation("com.github.ben-manes.caffeine:caffeine")
    implementation("io.grpc:grpc-core")
    implementation("io.grpc:grpc-netty-shaded")
    implementation("io.grpc:grpc-services")
    implementation("io.micrometer:micrometer-registry-elastic")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("io.projectreactor.addons:reactor-extra")
    implementation("org.hibernate.validator:hibernate-validator")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-actuator-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-fabric8-config")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation(libs.testcontainersPostgresql)
    testImplementation(libs.testcontainersRedis)
    testImplementation(project(path = ":hedera-mirror-common", configuration = "testClasses"))
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.flywaydb:flyway-core")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
