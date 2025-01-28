plugins {
    `kotlin-dsl`
}

group = "com.fady.modularization.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */
    plugins {
        register("gradleConventionAndroidApplication") {
            id = "gradle.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("gradleConventionAndroidLibrary") {
            id = "gradle.convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("gradleConventionAndroidTest") {
            id = "gradle.convention.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("gradleConventionCompose") {
            id = "gradle.convention.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}
