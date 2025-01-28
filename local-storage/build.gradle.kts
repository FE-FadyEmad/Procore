plugins {
    alias(libs.plugins.gradle.convention.android.library)
}

android {
    namespace = "com.fady.storage"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.security.crypto)
    ksp(libs.androidx.room.compiler)
    annotationProcessor(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.guava)
    testImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.paging)
}

