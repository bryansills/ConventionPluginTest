import ninja.bryansills.configureAndroid
import ninja.bryansills.configureCompose
import ninja.bryansills.configureKotlin
import ninja.bryansills.libs
import ninja.bryansills.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            apply("conventionplugintest.spotless")
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }

        configureAndroid()
        configureKotlin()
        configureCompose()

        dependencies {
            "implementation"(libs.findLibrary("androidx-compose-activity").get())
        }
    }
}
