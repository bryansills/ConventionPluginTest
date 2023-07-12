import ninja.bryansills.conventionplugintest.buildlogic.findVersionNumber
import ninja.bryansills.conventionplugintest.buildlogic.javaVersion
import ninja.bryansills.conventionplugintest.buildlogic.libs

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = libs.findVersionNumber("compile-sdk")
    defaultConfig {
        minSdk = libs.findVersionNumber("min-sdk")
    }
    compileOptions {
        sourceCompatibility = libs.javaVersion
        targetCompatibility = libs.javaVersion
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = libs.javaVersion.toString()
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.RequiresOptIn",
            // Enable experimental coroutines APIs, including Flow
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.coroutines.FlowPreview",
        )
    }
}

dependencies {
    add("coreLibraryDesugaring", libs.findLibrary("android.desugarJdkLibs").get())
}