import ninja.bryansills.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeMultiplatformLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins {
            apply("kotlin-multiplatform")
            apply("android-kotlin-multiplatform-library")
        }

//        kotlin {
//            androidLibrary {
//                @Suppress("UnstableApiUsage")
//                namespace = "com.google.samples.apps.diceroller.shared"
//                @Suppress("UnstableApiUsage")
//                compileSdk = 34
//            }
//        }
    }
}