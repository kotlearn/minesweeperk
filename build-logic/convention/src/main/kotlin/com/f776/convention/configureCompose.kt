package com.f776.convention

import org.gradle.api.Project
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureCompose(
    extension: KotlinMultiplatformExtension,
    composeDeps: ComposePlugin.Dependencies
) = extension.apply {
    sourceSets.apply {
        val desktopMain = getByName("desktopMain")
        commonMain.dependencies {
            api(composeDeps.runtime)
            api(composeDeps.foundation)
            api(composeDeps.material3AdaptiveNavigationSuite)
            api(composeDeps.ui)
            api(composeDeps.components.resources)
            api(composeDeps.components.uiToolingPreview)
            api(composeDeps.material3)
            api(libs.findLibrary("adaptive.layout").get())
        }

        androidMain.dependencies {
            api(composeDeps.preview)
            api(libs.findLibrary("androidx.activity.compose").get())
        }


        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        desktopMain.dependencies {
            api(composeDeps.desktop.currentOs)
            api(libs.findLibrary("kotlinx.coroutines.swing").get())
        }
    }
}