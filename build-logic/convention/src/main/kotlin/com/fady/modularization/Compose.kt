package com.fady.modularization

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

@Suppress("UnstableApiUsage")
internal fun Project.configureCompose(commonExtension: BaseExtension) {
    commonExtension.apply {
        buildFeatures.apply {
            compose = true
        }

        val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
//            add("implementation", platform(libs.findLibrary("androidx.compose.material3").get()))
            add("implementation", platform(libs.findLibrary("androidx.compose.bom").get()))
//            add("implementation", platform(libs.findLibrary("androidx-compose-ui").get()))
//            add("implementation", platform(libs.findLibrary("androidx.ui.graphics").get()))
//            add("implementation", platform(libs.findLibrary("androidx.ui.tooling.preview.android").get()))
//            add("debugImplementation", platform(libs.findLibrary("androidx.ui.tooling").get()))
//            add("androidTestImplementation", libs.findLibrary("androidx.compose.ui.test.junit4").get())
        }
    }
}
