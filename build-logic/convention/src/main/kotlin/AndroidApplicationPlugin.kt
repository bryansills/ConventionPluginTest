import ninja.bryansills.configureAndroid
import ninja.bryansills.configureKotlin
import ninja.bryansills.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            apply("conventionplugintest.spotless")
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }

        configureAndroid()
        configureKotlin()
    }
}
