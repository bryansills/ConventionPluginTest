import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.samReceiver)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "conventionplugintest.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
    }
}

samWithReceiver.annotation(HasImplicitReceiver::class.qualifiedName!!)

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    fun DependencyHandler.plugin(dependency: Provider<PluginDependency>) =
        dependency.get().run { create("$pluginId:$pluginId.gradle.plugin:$version") }

    compileOnly(gradleKotlinDsl())
    compileOnly(plugin(libs.plugins.android.library))
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}
