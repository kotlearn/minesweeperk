import com.f776.convention.getVersionCodeAndNameProperty
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.desktop.DesktopExtension
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

class DesktopApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ComposeExtension> {
                extensions.configure<DesktopExtension> {
                    val (_, versionNameProperty) = getVersionCodeAndNameProperty()
                    application {
                        mainClass = "com.kotlearn.minesweeperk.MainKt"

                        nativeDistributions {
                            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                            packageName = "MinesweeperK"
                            packageVersion = versionNameProperty
                            description = "MinesweeperK by Kotlearn"
                            copyright = "Copyright (c) 2025, Kotlearn"
                            licenseFile.set(project.file("../LICENSE.txt"))

                            macOS {
                                dockName = "MinesweeperK"
                                entitlementsFile.set(project.file("default.entitlements"))
                            }
                        }

                        buildTypes.release {
                            proguard {
                                obfuscate.set(true)
                                configurationFiles.from("proguard-rules.pro")
                            }
                        }
                    }
                }
            }
        }
    }
}