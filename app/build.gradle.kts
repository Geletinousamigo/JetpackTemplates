plugins {
    id("template.android.application")
    id("template.android.application.compose")
    id("template.android.tv.application.compose")
    id("template.android.hilt")
}

android {
    namespace = "com.nikhil.jetpacktemplates"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nikhil.jetpacktemplates"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    /**
     * Configure SigningConfigs for Release buildType
     */
    signingConfigs {
        create("release") {

        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/gradle/incremental.annotation.processors")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
//    implementation(project(":core:ui"))
//    implementation(project(":core:data"))
//    implementation(project(":core:model"))
//    androidTestImplementation(kotlin("test"))
//    debugImplementation(libs.androidx.compose.ui.testManifest)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)

    // Core functions
//    testImplementation(project(":core:testing"))
//    testImplementation(project(":core:datastore-test"))
//    testImplementation(project(":core:data-test"))
//    testImplementation(project(":core:network"))
//    testImplementation(libs.androidx.navigation.testing)
//    testImplementation(kotlin("test"))
//    kspTest(libs.hilt.compiler)
}