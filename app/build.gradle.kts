import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

android {
    namespace = "com.dgu.camputhon"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dgu.camputhon"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", getApiKey("base.url"))
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    // Glide
    implementation("com.github.bumptech.glide:glide:4.13.2")
    implementation("com.android.identity:identity-credential-android:20231002")
    kapt("com.github.bumptech.glide:glide:4.13.2")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    kapt("com.google.dagger:hilt-compiler:2.50")

    // Shared Preference
    implementation("androidx.security:security-crypto-ktx:1.1.0-alpha06")

    // KTX
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Network
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // JSON
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    // Coil
    implementation("io.coil-kt:coil:2.5.0")
    implementation("io.coil-kt:coil-svg:2.4.0")

    // ExifInterface
    implementation("androidx.exifinterface:exifinterface:1.3.7")

    // kakao
    implementation("com.kakao.sdk:v2-user:2.18.0")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:29.0.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.android.gms:play-services-tagmanager:18.0.4")

    // dataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("com.google.android.exoplayer:exoplayer:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")

// media3
    implementation("androidx.media3:media3-exoplayer:1.1.1")
    implementation("androidx.media3:media3-ui:1.1.1")
    implementation("com.arthenica:mobile-ffmpeg-full:4.4")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey) ?: "null"
}


