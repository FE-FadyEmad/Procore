package com.fady.modularization

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

internal fun configureAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        compileSdk = 34

        defaultConfig {
            minSdk = 24

            testInstrumentationRunner = "com.fady.modularization.testing.HiltTestRunner"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro",
                )
            }
        }
        testOptions {
            unitTests {
                isReturnDefaultValues = true
                all {
                    it.useJUnitPlatform()
                    it.testLogging {
                        exceptionFormat = TestExceptionFormat.FULL
                        events = setOf(TestLogEvent.FAILED)
                    }
                }
            }
        }
        buildFeatures.buildConfig = false
    }
}
