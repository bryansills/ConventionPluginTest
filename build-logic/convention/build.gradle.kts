import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.samReceiver)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.javaVersion.majorVersion))
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "conventionplugintest.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("spotless") {
            id = "conventionplugintest.spotless"
            implementationClass = "SpotlessPlugin"
        }
    }
}

samWithReceiver.annotation(HasImplicitReceiver::class.qualifiedName!!)

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    compileOnly(gradleKotlinDsl())
    compileOnly(plugin(libs.plugins.kotlin.android))
    compileOnly(plugin(libs.plugins.compose.compiler))
    compileOnly(plugin(libs.plugins.android.application))
    compileOnly(plugin(libs.plugins.android.library))
    compileOnly(plugin(libs.plugins.spotless))
    compileOnly(plugin(libs.plugins.ksp))
    compileOnly(plugin(libs.plugins.hilt.plugin))
    compileOnly(plugin(libs.plugins.kotlinx.serialization))
    compileOnly(plugin(libs.plugins.dependency.guard))
}

fun DependencyHandler.plugin(dependency: Provider<PluginDependency>) =
    dependency.get().run { create("$pluginId:$pluginId.gradle.plugin:$version") }

private val LibrariesForLibs.javaVersion
    get(): JavaVersion = JavaVersion.toVersion(versions.java.version.get())
