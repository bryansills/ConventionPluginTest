plugins {
    id("conventionplugintest.android.application")
}

android {
    namespace = "ninja.bryansills.conventionplugintest"

    defaultConfig {
        applicationId = "ninja.bryansills.conventionplugintest"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    implementation(project(":kmp-lib"))
    implementation(project(":kmp-compose-lib"))
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.espresso.core)
}
