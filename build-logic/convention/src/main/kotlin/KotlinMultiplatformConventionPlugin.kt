import com.f776.convention.configureKotlinMultiplatform
import com.f776.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
    }
}