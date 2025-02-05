package com.f776.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project

internal fun Project.configureAndroidApplication(
    extension: ApplicationExtension,
    versionCodeProperty: Int,
    versionNameProperty: String
) = extension.apply {
    defaultConfig {
        applicationId = "com.kotlearn.minesweeperk"
        targetSdk = libs.findVersion("android-targetSdk").get().requiredVersion.toInt()
        versionCode = versionCodeProperty
        versionName = versionNameProperty
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}