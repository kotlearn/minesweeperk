import com.android.build.api.dsl.ApplicationExtension
import com.f776.convention.configureAndroidApplication
import com.f776.convention.configureKotlinAndroid
import com.f776.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.findPlugin("androidApplication").get().get().pluginId)
        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
            configureAndroidApplication(this)
        }
        extensions.configure<KotlinMultiplatformExtension> {
            androidTarget()
        }
    }
}