package ninja.bryansills

import com.android.build.gradle.internal.lint.AndroidLintAnalysisTask
import com.android.build.gradle.internal.lint.LintModelWriterTask
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

internal fun Project.configureCompose() {
    plugins {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    composeCompiler {
        enableStrongSkippingMode.set(true)

        // Needed for Layout Inspector to be able to see all of the nodes in the component tree:
        //https://issuetracker.google.com/issues/338842143
        includeSourceInformation.set(true)
    }

    android {
        buildFeatures.compose = true
    }

    // Workaround for:
    // Task 'generateDebugUnitTestLintModel' uses this output of task
    // 'generateResourceAccessorsForAndroidUnitTest' without declaring an explicit or
    // implicit dependency.
    tasks.matching { it is AndroidLintAnalysisTask || it is LintModelWriterTask }.configureEach {
        mustRunAfter(tasks.matching { it.name.startsWith("generateResourceAccessorsFor") })
    }
}

internal fun Project.composeCompiler(block: ComposeCompilerGradlePluginExtension.() -> Unit) {
    extensions.configure<ComposeCompilerGradlePluginExtension>(block)
}
