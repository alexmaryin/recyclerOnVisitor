val lifecycleVersion = "2.4.0-alpha01"
val hiltVersion = "2.33-beta"

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "ru.alexmaryin.recycleronvisitor"
        minSdk = 22
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    // Core
    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")

    // Data binding
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation ("androidx.activity:activity-ktx:1.2.2")
    implementation ("androidx.fragment:fragment-ktx:1.3.2")

    // images download from internet
    implementation ("com.squareup.picasso:picasso:2.71828")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3-native-mt")

    //Hilt
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    kapt ("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kapt ("androidx.hilt:hilt-compiler:1.0.0-beta01")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.4")

    // UI
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
}