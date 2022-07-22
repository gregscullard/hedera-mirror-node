import org.openapitools.codegen.CodegenConstants
import org.openapitools.codegen.config.GlobalSettings

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
    id("org.openapi.generator") version "6.0.1"
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
    implementation(libs.swaggerAnnotations)
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

openApiGenerate {
    val openApiPackage = "com.hedera.mirror.rest"
    GlobalSettings.clearProperty(CodegenConstants.APIS)

    apiPackage.set("${openApiPackage}.api")
    configOptions.set(
        mapOf(
            "developerEmail" to "",
            "developerName" to "",
            "developerOrganization" to "",
            "developerOrganizationUrl" to "",
            "interfaceOnly" to "true",
            "licenseName" to "Apache License 2.0",
            "licenseUrl" to "https://www.apache.org/licenses/LICENSE-2.0.txt",
            "openApiNullable" to "false",
            "performBeanValidation" to "true",
            "useBeanValidation" to "true",
        )
    )
    generateApiTests.set(false)
    generateModelTests.set(false)
    generatorName.set("java")
    inputSpec.set("$rootDir/hedera-mirror-rest/api/v1/openapi.yml".toString())
    invokerPackage.set("${openApiPackage}.handler")
    library.set("webclient")
    modelPackage.set("${openApiPackage}.model")
    //outputDir.set("$buildDir/generated/openapi")
    typeMappings.set(mapOf("Timestamp" to "String"))
}

tasks.withType<JavaCompile> {
    dependsOn("openApiGenerate")
}

java.sourceSets["main"].java {
    srcDir(openApiGenerate.outputDir)
}
