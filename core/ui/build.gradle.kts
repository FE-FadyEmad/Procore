plugins {
    alias(libs.plugins.gradle.convention.android.library)
    alias(libs.plugins.gradle.convention.compose)
}

android {
    namespace = "com.fady.ui"
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.ui.tooling.preview.android)
}

