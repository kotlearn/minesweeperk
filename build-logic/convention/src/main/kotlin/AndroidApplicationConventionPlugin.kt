import com.android.build.api.dsl.ApplicationExtension
import com.f776.convention.configureAndroidApplication
import com.f776.convention.configureKotlinAndroid
import com.f776.convention.getVersionCodeAndNameProperty
import com.f776.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import java.io.FileInputStream
import java.util.Properties

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.findPlugin("androidApplication").get().get().pluginId)

        val (versionCodeProperty, versionNameProperty) = getVersionCodeAndNameProperty()

        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
            configureAndroidApplication(this, versionCodeProperty, versionNameProperty)
        }
        extensions.configure<KotlinMultiplatformExtension> {
            androidTarget()
        }
    }
}
