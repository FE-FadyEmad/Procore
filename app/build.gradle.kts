plugins {
    alias(libs.plugins.gradle.convention.android.application)
    alias(libs.plugins.gradle.convention.compose)
}

android {
    namespace = "com.fady.procore"

    defaultConfig {
        applicationId = "com.fady.procore"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":feature:journeyA"))
    implementation(project(":data:journey-data"))

    // Core Android dependencies
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Arch Components
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    // Compose
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.ui.tooling.preview.android)

}