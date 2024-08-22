pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Convention-Plugin-Test"
include(":app")
include(":kmp-lib")
include(":kmp-compose-lib")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")