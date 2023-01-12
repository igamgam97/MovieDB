buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlintner) apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}