package ninja.bryansills

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroid() {
    android {
        compileSdkVersion(libs.findVersionNumber("compile-sdk"))
        defaultConfig {
            minSdk = libs.findVersionNumber("min-sdk")
            if (this@android is ApplicationExtension) {
                targetSdk = libs.findVersionNumber("target-sdk")
            }

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        compileOptions {
            isCoreLibraryDesugaringEnabled = true
        }
        buildFeatures.resValues = false
        buildFeatures.shaders = false
    }
    dependencies {
        "coreLibraryDesugaring"(libs.findLibrary("android-desugarJdkLibs").get())
        "androidTestImplementation"(libs.findLibrary("androidx-test-runner").get())
    }
}

internal fun Project.android(action: BaseExtension.() -> Unit) = extensions.configure<BaseExtension>(action)
