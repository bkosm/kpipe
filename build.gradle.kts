import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    jacoco
    `maven-publish`
}

val versionString = "1.0.0"
val groupString = "com.github.bkosm"

group = groupString
version = versionString

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    jacocoTestReport {
        reports {
            csv.required.set(true)
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "kpipe"
            groupId = groupString
            version = versionString

            from(components["java"])
        }
    }
}

