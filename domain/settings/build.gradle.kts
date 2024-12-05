plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DomainSettings"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {

        commonMain.dependencies {
            implementation(projects.data.settings)

            implementation(libs.koin.core)
        }

    }
}
