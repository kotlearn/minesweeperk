plugins {
    alias(libs.plugins.kotlearn.kotlinMultiplatform)
    alias(libs.plugins.kotlearn.androidLibrary)
    alias(libs.plugins.kotlearn.composeMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {

        commonMain.dependencies {
            implementation(projects.ui.core)

            implementation(libs.koin.core)
            implementation(libs.bundles.koin.compose)
            implementation(libs.kotlinx.serialization)
        }

    }
}