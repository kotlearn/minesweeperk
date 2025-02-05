package com.f776.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project

internal fun Project.configureAndroidApplication(
    extension: ApplicationExtension
) = extension.apply {
    defaultConfig {
        applicationId = "com.f776"
        targetSdk = libs.findVersion("android-targetSdk").get().requiredVersion.toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}