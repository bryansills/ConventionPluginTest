plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    androidLibrary {
        @Suppress("UnstableApiUsage")
        namespace = "ninja.bryansills.conventionplugintest.kmp"
        @Suppress("UnstableApiUsage")
        compileSdk = 34
    }
}