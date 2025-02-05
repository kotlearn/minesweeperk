plugins {
    alias(libs.plugins.kotlearn.kotlinMultiplatform)
    alias(libs.plugins.kotlearn.androidApplication)
    alias(libs.plugins.kotlearn.composeMultiplatform)
    alias(libs.plugins.kotlearn.desktopApplication)
}

kotlin {
    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {

        }
        commonMain.dependencies {
            implementation(projects.ui.core)
            implementation(projects.feature.menu)
            implementation(projects.feature.settings)
            implementation(projects.feature.highscores)
            implementation(projects.feature.play)

            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.koin.core)
            implementation(libs.bundles.koin.compose)
        }

        desktopMain.dependencies {

        }
    }
}