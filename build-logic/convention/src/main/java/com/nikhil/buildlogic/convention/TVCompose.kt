package com.nikhil.buildlogic.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureTVCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", libs.findLibrary("tv-compose-foundation").get())
            add("implementation", libs.findLibrary("tv-compose-material").get())
            add("androidTestImplementation", platform(bom))
        }
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
//            freeCompilerArgs += "-opt-in=androidx.tv.tvMaterial3.ExperimentalTvMaterial3Api"
            freeCompilerArgs += "-opt-in=androidx.tv.material3.ExperimentalTvMaterial3Api"
            freeCompilerArgs += "-opt-in=androidx.tv.foundation.ExperimentalTvFoundationApi"
        }
    }
}