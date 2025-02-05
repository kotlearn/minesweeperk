import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.desktop.DesktopExtension
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

class DesktopApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            afterEvaluate {
                extensions.configure<ComposeExtension> {
                    extensions.configure<DesktopExtension> {
                        application {
                            mainClass = "com.f776.MainKt"

                            nativeDistributions {
                                targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                                packageName = "com.f776"
                                packageVersion = "1.0.0"
                            }
                        }

                    }
                }
            }
        }
    }
}