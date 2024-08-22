plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    androidLibrary {
        @Suppress("UnstableApiUsage")
        namespace = "ninja.bryansills.conventionplugintest.compose"
        @Suppress("UnstableApiUsage")
        compileSdk = 34
    }
}