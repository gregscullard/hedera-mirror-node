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

rootProject.name = "hedera-mirror-node"
include(":hedera-mirror-common")
include(":hedera-mirror-grpc")
include(":hedera-mirror-importer")
include(":hedera-mirror-monitor")
include(":hedera-mirror-protobuf")
include(":hedera-mirror-rest")
include(":hedera-mirror-rosetta")
include(":hedera-mirror-test")
include(":hedera-mirror-web3")

// Shorten project name to remove verbose "hedera-mirror-" prefix
//rootProject.children.forEach { project ->
//    project.name = project.name.removePrefix("hedera-mirror-")
//}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    versionCatalogs {
        create("libs") {
            version("grpcVersion", "1.48.0")
            version("protobufVersion", "3.21.2")
            version("reactorGrpcVersion", "1.2.3")
            version("testcontainersSpringBoot", "2.2.4")

            library("aws", "software.amazon.awssdk", "bom").version("2.17.233")
            library("besu", "org.hyperledger.besu", "evm").version("22.4.4")
            library("commonsBeanutils", "commons-beanutils", "commons-beanutils").version("1.9.4")
            library("commonsCompress", "org.apache.commons", "commons-compress").version("1.21")
            library("commonsIo", "commons-io", "commons-io").version("2.11.0")
            library("commonsMath", "org.apache.commons", "commons-math3").version("3.6.1")
            library("grpcSpringBoot", "net.devh", "grpc-spring-boot-starter").version("2.13.1.RELEASE")
            library("guava", "com.google.guava", "guava").version("31.1-jre")
            library("headlong", "com.esaulpaugh", "headlong").version("6.6.2")
            library("hederaProtobuf", "com.hedera.hashgraph", "hedera-protobuf-java-api").version("0.29.0-full-SNAPSHOT")
            library("hederaSdk", "com.hedera.hashgraph", "sdk").version("2.16.3")
            library("hibernateTypes", "com.vladmihalcea", "hibernate-types-52").version("2.16.3")
            library("javaxInject", "javax.inject", "javax.inject").version("1")
            library("meanbean", "com.github.meanbeanlib", "meanbean").version("3.0.0-M9")
            library("micrometerExtra", "io.github.mweirauch", "micrometer-jvm-extras").version("0.2.2")
            library("msgpack", "org.msgpack", "jackson-dataformat-msgpack").version("0.9.3")
            library("protobuf", "com.google.protobuf", "protobuf-java").versionRef("protobufVersion")
            library("reactorGrpc", "com.salesforce.servicelibs", "reactor-grpc-stub").versionRef("reactorGrpcVersion")
            library("s3proxy", "org.gaul", "s3proxy").version("2.0.0")
            library("scram", "com.ongres.scram", "client").version("2.1")
            library("springCloud", "org.springframework.cloud", "spring-cloud-dependencies").version("2021.0.3")
            library("springCloudGcp", "com.google.cloud", "spring-cloud-gcp-dependencies").version("3.3.0")
            library("springdoc", "org.springdoc", "springdoc-openapi-webflux-ui").version("1.6.9")
            library("sqlFormatter", "com.github.vertical-blank", "sql-formatter").version("2.0.3")
            library("swaggerAnnotations", "io.swagger", "swagger-annotations").version("1.6.6")
            library("testcontainers", "org.testcontainers", "junit-jupiter").version("1.17.2")
            library("testcontainersGooglePubSub", "com.playtika.testcontainers", "embedded-google-pubsub").versionRef("testcontainersSpringBoot")
            library("testcontainersPostgresql", "com.playtika.testcontainers", "embedded-postgresql").versionRef("testcontainersSpringBoot")
            library("testcontainersRedis", "com.playtika.testcontainers", "embedded-redis").versionRef("testcontainersSpringBoot")
            library("tuweni", "org.apache.tuweni", "tuweni-bytes").version("2.2.0")
            library("velocity", "org.apache.velocity", "velocity-engine-core").version("2.3")
            library("vertx", "io.vertx", "vertx-pg-client").version("4.3.2")
            library("web3j", "org.web3j", "core").version("4.9.2")
        }
    }
}
