package com.f776.convention

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureRoom(extension: KotlinMultiplatformExtension) = extension.apply {
    sourceSets.apply {
        commonMain.dependencies {
            implementation(libs.findLibrary("androidx-room-runtime").get())
            implementation(libs.findLibrary("sqlite-bundled").get())
        }
    }
}