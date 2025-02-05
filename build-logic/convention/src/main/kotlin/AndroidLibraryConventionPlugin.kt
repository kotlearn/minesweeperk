import com.android.build.gradle.LibraryExtension
import com.f776.convention.configureKotlinAndroid
import com.f776.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.findPlugin("androidLibrary").get().get().pluginId)
        extensions.configure<LibraryExtension>(::configureKotlinAndroid)
        extensions.configure<KotlinMultiplatformExtension> {
            androidTarget()
        }
    }
}