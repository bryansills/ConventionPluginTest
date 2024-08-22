plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kmp.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidLibrary {
        @Suppress("UnstableApiUsage")
        namespace = "ninja.bryansills.conventionplugintest.kmp"
        @Suppress("UnstableApiUsage")
        compileSdk = 34
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
        }
    }
}