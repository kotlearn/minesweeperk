import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.kotlearn.buildlogic"

// Configure the build-logic plugins to target JDK 17
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("composeMultiplatform"){
            id = libs.plugins.kotlearn.composeMultiplatform.get().pluginId
            implementationClass = "ComposeConventionPlugin"
        }

        register("kotlinMultiplatform"){
            id = libs.plugins.kotlearn.kotlinMultiplatform.get().pluginId
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }

        register("androidLibrary"){
            id = libs.plugins.kotlearn.androidLibrary.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidApplication"){
            id = libs.plugins.kotlearn.androidApplication.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("desktopApplication"){
            id = libs.plugins.kotlearn.desktopApplication.get().pluginId
            implementationClass = "DesktopApplicationConventionPlugin"
        }

        register("roomMultiplatform"){
            id = libs.plugins.kotlearn.roomMultiplatform.get().pluginId
            implementationClass = "RoomDatabaseConventionPlugin"
        }
    }
}