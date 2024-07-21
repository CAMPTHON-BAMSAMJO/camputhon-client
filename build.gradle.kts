// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
    repositories {
        google()
        mavenCentral()
        maven("https://devrepo.kakao.com/nexus/content/groups/public/")
    }
}

plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.5.1" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.android.library") version "8.1.3" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}