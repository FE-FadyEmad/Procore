plugins {
    alias(libs.plugins.gradle.convention.android.library)
    alias(libs.plugins.gradle.convention.compose)
}

android {
    namespace = "com.fady.feature.journeyA"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:util"))
    implementation(project(":domain:journey-domain"))

    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.hilt.navigation.compose)
    debugImplementation(libs.ui.tooling)
    implementation (libs.coil.compose)
}
