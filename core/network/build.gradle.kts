plugins {
    alias(libs.plugins.gradle.convention.android.library)
}

android {
    namespace = "com.fady.network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.converter.scalars)
    implementation(libs.retrofit.converter.network)
    implementation(libs.okhttp.network)
    implementation(libs.okhttp.logging.intercepter.network)

}

