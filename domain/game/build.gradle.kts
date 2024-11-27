plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DomainGame"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {

        commonMain.dependencies {
            implementation(projects.data.game)
            implementation(projects.data.settings)
        }

    }



}

