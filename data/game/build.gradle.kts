plugins {
    alias(libs.plugins.kotlearn.kotlinMultiplatform)
    alias(libs.plugins.kotlearn.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.core)
            implementation(libs.koin.core)
        }
    }
}