@file:Suppress("UnstableApiUsage")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kmp.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidLibrary {
//        namespace = "ninja.bryansills.conventionplugintest.kmp"
        compileSdk = 34
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)

            implementation(libs.coroutines)
            implementation(libs.kotlinx.datetime)
        }
    }
}