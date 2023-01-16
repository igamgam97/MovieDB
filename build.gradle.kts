buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*
 * IDE marks `libs` red.
 * Bug, see https://youtrack.jetbrains.com/issue/KTIJ-19369
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlintner) apply false
}

println("") // workaround version catalog problem https://github.com/gradle/gradle/issues/20131