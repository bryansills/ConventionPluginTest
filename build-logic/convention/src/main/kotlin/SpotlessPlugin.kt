import com.diffplug.gradle.spotless.SpotlessExtension
import ninja.bryansills.conventionplugintest.buildlogic.libs
import ninja.bryansills.conventionplugintest.buildlogic.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            apply("com.diffplug.spotless")
        }

        spotless {
            format("misc") {
                target("*.md", ".gitignore")
                trimTrailingWhitespace()
                endWithNewline()
            }
            kotlin {
                ktlint(libs.findVersion("ktlint").get().requiredVersion)
                target("**/*.kt")
                trimTrailingWhitespace()
                endWithNewline()
            }
            kotlinGradle {
                ktlint(libs.findVersion("ktlint").get().requiredVersion)
                target("**/*.gradle.kts")
                trimTrailingWhitespace()
                endWithNewline()
            }
        }
    }
}

private fun Project.spotless(action: SpotlessExtension.() -> Unit) = extensions.configure<SpotlessExtension>(action)