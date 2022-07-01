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
    id("io.freefair.lombok") version "6.4.3.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.7.0" apply false
}

description = "Hedera Mirror Node mirrors data from Hedera nodes and serves it via an API"

allprojects {
    group = "com.hedera"
    version = "0.60.0-SNAPSHOT"

    configurations.all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

subprojects {
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "jacoco")

    dependencyManagement {
        imports {
            mavenBom("io.grpc:grpc-bom:1.47.0")
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    extra["gson.version"] = "2.8.9" // Temporary until Apache jclouds supports gson 2.9
//
//    publishing {
//        publications {
//            create<MavenPublication>("mavenJava") {
//                pom {
//                    description.set(project.description)
//                    inceptionYear.set("2019")
//                    name.set(project.name)
//                    url.set("https://github.com/hashgraph/hedera-mirror-node")
//                    licenses {
//                        license {
//                            name.set("The Apache License, Version 2.0")
//                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                        }
//                    }
//                    scm {
//                        connection.set("https://github.com/hashgraph/hedera-mirror-node.git")
//                        url.set("https://github.com/hashgraph/hedera-mirror-node")
//                    }
//                }
//            }
//        }
//    }

    repositories {
        mavenCentral()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
        maven {
            url = uri("https://hyperledger.jfrog.io/artifactory/besu-maven/")
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    tasks.withType<JavaExec> {
        minHeapSize = "1024m"
        maxHeapSize = "4096m"
    }

    tasks.withType<Test> {
        minHeapSize = "1024m"
        maxHeapSize = "4096m"
        useJUnitPlatform {
            excludeTags("largedbperf", "performance")
        }
    }
}
