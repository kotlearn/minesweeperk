plugins {
    alias(libs.plugins.kotlearn.kotlinMultiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.settings)
            implementation(libs.koin.core)
            implementation(libs.bundles.kotlin)
        }
    }
}
