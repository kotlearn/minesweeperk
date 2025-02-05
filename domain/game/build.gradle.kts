plugins {
    alias(libs.plugins.kotlearn.kotlinMultiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.data.game)
            implementation(projects.data.settings)
            implementation(libs.koin.core)
        }
    }
}