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

import com.google.protobuf.gradle.*

plugins {
    id("com.google.protobuf") version "0.8.19"
    id("java-library")
}

description = "Hedera Mirror Node Protobuf"

dependencies {
    api(libs.hederaProtobuf) { isTransitive = false }
    api(libs.reactorGrpc)
    api("io.grpc:grpc-protobuf")
    api("io.grpc:grpc-stub")
    api("io.projectreactor:reactor-core")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:" + libs.versions.protobufVersion.get()
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java"
        }
        id("reactor") {
            artifact = "com.salesforce.servicelibs:reactor-grpc:" + libs.versions.reactorGrpcVersion.get()
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
                id("reactor")
            }
        }
    }
}
