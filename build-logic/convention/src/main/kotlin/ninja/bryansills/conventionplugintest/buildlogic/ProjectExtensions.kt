package ninja.bryansills.conventionplugintest.buildlogic

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

val VersionCatalog.javaVersion
    get(): JavaVersion = JavaVersion.toVersion(findVersion("java-version").get().requiredVersion)

val VersionCatalog.jvmTarget
    get(): JvmTarget = JvmTarget.fromTarget(findVersion("java-version").get().requiredVersion)

fun VersionCatalog.findVersionNumber(alias: String): Int {
    return findVersion(alias).get().requiredVersion.toInt()
}