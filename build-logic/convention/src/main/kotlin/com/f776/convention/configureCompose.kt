package com.f776.convention

import org.gradle.api.Project
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@OptIn(ExperimentalComposeLibrary::class)
internal fun Project.configureCompose(
    extension: KotlinMultiplatformExtension,
    composeDeps: ComposePlugin.Dependencies
) = extension.apply {
    sourceSets.apply {
        val desktopMain = getByName("desktopMain")
        commonMain.dependencies {
            implementation(composeDeps.runtime)
            implementation(composeDeps.foundation)
            implementation(composeDeps.material3AdaptiveNavigationSuite)
            implementation(composeDeps.ui)
            implementation(composeDeps.components.resources)
            implementation(composeDeps.components.uiToolingPreview)
            implementation(composeDeps.material3)
            implementation(composeDeps.materialIconsExtended)
            implementation(composeDeps.uiTest)
        }

        androidMain.dependencies {
            implementation(composeDeps.preview)
            implementation(libs.findLibrary("androidx.activity.compose").get())
        }


        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        desktopMain.dependencies {
            implementation(composeDeps.desktop.currentOs)
            implementation(libs.findLibrary("kotlinx.coroutines.swing").get())
        }
    }
}