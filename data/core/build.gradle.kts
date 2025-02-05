plugins {
    alias(libs.plugins.kotlearn.kotlinMultiplatform)
    alias(libs.plugins.kotlearn.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.datastore.preferences.core)
        }
    }
}