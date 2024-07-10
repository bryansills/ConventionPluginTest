import com.android.build.api.dsl.ApplicationExtension
import ninja.bryansills.conventionplugintest.buildlogic.findVersionNumber
import ninja.bryansills.conventionplugintest.buildlogic.javaVersion
import ninja.bryansills.conventionplugintest.buildlogic.jvmTarget
import ninja.bryansills.conventionplugintest.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        with(plugins) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }

        extensions.configure<ApplicationExtension> {
            compileSdk = libs.findVersionNumber("compile-sdk")
            defaultConfig {
                minSdk = libs.findVersionNumber("min-sdk")
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

        with(dependencies) {
            add("coreLibraryDesugaring", libs.findLibrary("android.desugarJdkLibs").get())
        }
    }
}