plugins {
    java
    `maven-publish`
    `java-library`
    id("org.cadixdev.licenser") version "0.6.1"
    id("de.chojo.publishdata") version "1.0.4"
}

repositories {
    mavenCentral()
}

group = "de.chojo"
version = "1.0"
description = "SaucenaoAPIWrapper"

dependencies {
    api("org.slf4j", "slf4j-api", "1.7.32")
    api("com.squareup.okhttp3", "okhttp", "4.9.0")
    api("com.google.code.gson", "gson", "2.8.5")
}

license {
    header(rootProject.file("HEADER.txt"))
    include("**/*.java")
}

java {
    withSourcesJar()
    withJavadocJar()
    sourceCompatibility = JavaVersion.VERSION_11
}

publishData{
    publishComponent("java")
    useEldoNexusRepos()
}

publishing {
    publications.create<MavenPublication>("maven") {
        publishData.configurePublication(this)
        pom {
            url.set("https://github.com/RainbowDashLabs/SaucenaoAPIWraper")
            developers {
                developer {
                    name.set("Florian Fülling")
                    organizationUrl.set("https://github.com/RainbowDashLabs")
                }
            }
            licenses {
                license {
                    name.set("GNU Affero General Public License v3.0")
                    url.set("https://www.gnu.org/licenses/agpl-3.0.en.html")
                }
            }
        }
    }
    repositories     {
        maven {
            authentication {
                credentials(PasswordCredentials::class) {
                    username = System.getenv("NEXUS_USERNAME")
                    password = System.getenv("NEXUS_PASSWORD")
                }
            }

            setUrl(publishData.getRepository())
            name = "EldoNexus"
        }
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    compileTestJava {
        options.encoding = "UTF-8"
    }
}
