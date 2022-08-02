plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "org.devscast.template"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArgument("runnerBuilder", "de.mannodermaus.junit5.AndroidJUnit5Builder")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // android core ----------------------------------------------
    implementation (libs.androidx.core.core.ktx)
    implementation (libs.androidx.lifecycle.lifecycle.runtime.ktx)
    //-------------------------------------------------------------

    //   compose -----------------------------------------------------
    implementation (libs.androidx.compose.ui)
    implementation (libs.androidx.compose.ui.tooling.preview)
    implementation (libs.androidx.compose.material.material)
    implementation (libs.androidx.activity.activity.compose)
    androidTestImplementation (libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    //---------------------------------------------------------------

    // junit --------------------------------------------------------
    testImplementation (libs.junit.junit)
    androidTestImplementation (libs.androidx.test.junit.ext)
    androidTestImplementation (libs.androidx.test.espresso.core)
    // --------------------------------------------------------------
}