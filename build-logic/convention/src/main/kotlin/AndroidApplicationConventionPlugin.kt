import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.fady.modularization.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureAndroid(commonExtension = this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libs.findLibrary("hilt.android").get())
                add("kapt", libs.findLibrary("hilt.compiler").get())
                add("kaptAndroidTest", libs.findLibrary("hilt.android.compiler").get())
                add("androidTestImplementation", libs.findLibrary("hilt.android.testing").get())
                add("androidTestImplementation", libs.findLibrary("androidx.test.ext.junit").get())
                add("testImplementation", libs.findLibrary("junit").get())
                add("testImplementation", libs.findLibrary("kotlinx.coroutines.test").get())
                add("testImplementation", libs.findLibrary("androidx.core.ktx").get())
                add("testImplementation", libs.findLibrary("mockito.core").get())
                add("testImplementation", libs.findLibrary("mockito.kotlin").get())
                add("testImplementation", libs.findLibrary("mockk").get())
                add("testImplementation", libs.findLibrary("cash.app.turbine.test").get())
                add("testImplementation", libs.findLibrary("androidx.test.ext.junit5").get())
                add("testImplementation", libs.findLibrary("androidx.test.ext.junit5.api").get())
                add("testImplementation", libs.findLibrary("androidx.test.ext.junit5.params").get())
            }

            val kaptExtension = extensions.getByType<KaptExtension>()
            kaptExtension.apply {
                correctErrorTypes = true
            }
        }
    }
}
