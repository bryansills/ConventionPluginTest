import com.android.build.api.dsl.ApplicationExtension
import ninja.bryansills.conventionplugintest.buildlogic.dependencies
import ninja.bryansills.conventionplugintest.buildlogic.findVersionNumber
import ninja.bryansills.conventionplugintest.buildlogic.javaVersion
import ninja.bryansills.conventionplugintest.buildlogic.jvmTarget
import ninja.bryansills.conventionplugintest.buildlogic.libs
import ninja.bryansills.conventionplugintest.buildlogic.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            apply("conventionplugintest.spotless")
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }

        android {
            compileSdk = libs.findVersionNumber("compile-sdk")
            defaultConfig {
                minSdk = libs.findVersionNumber("min-sdk")
                targetSdk = libs.findVersionNumber("target-sdk")

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = libs.javaVersion
                targetCompatibility = libs.javaVersion
                isCoreLibraryDesugaringEnabled = true
            }
            configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget.set(libs.jvmTarget)
                }
            }
        }

        dependencies {
            add("coreLibraryDesugaring", libs.findLibrary("android.desugarJdkLibs").get())
        }
    }
}

private fun Project.android(action: ApplicationExtension.() -> Unit) = extensions.configure<ApplicationExtension> { action() }
