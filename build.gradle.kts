import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    java
    kotlin("jvm") version("1.9.10")
    val dgt = "1.24.0"
    id("dev.deftu.gradle.tools") version(dgt)
    id("dev.deftu.gradle.tools.dokka") version(dgt)
    id("dev.deftu.gradle.tools.blossom") version(dgt)
    id("dev.deftu.gradle.tools.maven-publishing") version(dgt)
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "dev.deftu.gradle.tools")
    apply(plugin = "dev.deftu.gradle.tools.dokka")
    apply(plugin = "dev.deftu.gradle.tools.blossom")
    apply(plugin = "dev.deftu.gradle.tools.maven-publishing")

    val projectDisplayName = rootProject.findProperty("project.displayName") as? String
        ?: throw IllegalStateException("project.displayName is not set")

    kotlin {
        explicitApi()
    }

    dependencies {
        if (project.name != "common") implementation(project(":common"))

        implementation(kotlin("reflect"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

        // Networking (OkHttp)
        implementation("com.squareup.okhttp3:okhttp:${rootProject.libs.versions.okhttp.get()}")

        // Data management (Gson, EnhancedEventBus)
        implementation("com.google.code.gson:gson:${rootProject.libs.versions.gson.get()}")
        implementation("xyz.deftu:enhancedeventbus:${rootProject.libs.versions.enhancedeventbus.get()}")

        // Logging (Slf4j)
        implementation("org.slf4j:slf4j-api:${rootProject.libs.versions.slf4j.get()}")

        //// Testing
        // Logging (Log4j)
        testImplementation("org.apache.logging.log4j:log4j-api:${rootProject.libs.versions.log4j.get()}")
        testImplementation("org.apache.logging.log4j:log4j-core:${rootProject.libs.versions.log4j.get()}")
        testImplementation("org.apache.logging.log4j:log4j-slf4j-impl:${rootProject.libs.versions.log4j.get()}")
    }

    tasks.withType<DokkaTask> {
        dokkaSourceSets {
            named("main") {
                moduleName.set(projectDisplayName)
                moduleVersion.set(projectData.version)
            }
        }

        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            customStyleSheets = listOf(rootProject.file("dokka.css"))
            footerMessage = "(c) 2024 Deftu and the Disko contributors"
            separateInheritedMembers = true
            mergeImplicitExpectActualDeclarations = true
        }
    }
}
