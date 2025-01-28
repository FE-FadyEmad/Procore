// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.android.tools.build.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.gradle.plugin)
        classpath(libs.symbol.processing.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.gradle.convention.android.application) apply false
    alias(libs.plugins.gradle.convention.android.library) apply false
    alias(libs.plugins.gradle.convention.android.test) apply false
    alias(libs.plugins.gradle.convention.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.ksp) apply false
}