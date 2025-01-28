plugins {
    alias(libs.plugins.gradle.convention.android.library)
}

android {
    namespace = "com.fady.data.auth"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":local-storage"))

    implementation(libs.retrofit)
}
