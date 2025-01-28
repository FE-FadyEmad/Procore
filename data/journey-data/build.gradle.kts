plugins {
    alias(libs.plugins.gradle.convention.android.library)
}

android {
    namespace = "com.fady.data.journey"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":local-storage"))
    implementation(project(":data:auth"))
    implementation(project(":domain:journey-domain"))

    implementation(libs.retrofit)

}
