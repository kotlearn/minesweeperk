import androidx.room.gradle.RoomExtension
import com.f776.convention.configureRoom
import com.f776.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class RoomDatabaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.findPlugin("ksp").get().get().pluginId)
        pluginManager.apply(libs.findPlugin("room").get().get().pluginId)

        extensions.configure<RoomExtension> {
            schemaDirectory("$projectDir/schemas")
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureRoom)

        dependencies {
            listOf(
                "kspAndroid",
                "kspIosArm64",
                "kspIosX64",
                "kspIosSimulatorArm64",
                "kspDesktop"
            ).forEach {
                add(it, libs.findLibrary("androidx-room-compiler").get())
            }
        }

    }
}