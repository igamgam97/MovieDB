plugins {
    id("movicatalog.android.application")
    id("movicatalog.android.application.compose")
    alias(libs.plugins.kotlintner)
}

android {

    defaultConfig {
        applicationId = "com.noveogroup.moviedb"
        versionCode = 1
        versionName = "1.0.0"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    flavorDimensions.add("environment")
    productFlavors {
        create("dev") {
            applicationIdSuffix = ".$name"
            dimension = "environment"
        }

        create("prod") {
            applicationIdSuffix = ".$name"
            dimension = "environment"
        }
    }
    lint {
        abortOnError = true
        checkAllWarnings = true
        disable += setOf(
                "AllowBackup",
                "ContentDescription",
                "InvalidPackage",
                "SpUsage",
                "IconMissingDensityFolder",
                "SelectableText",
                "RtlCompat",
                "RtlEnabled",
                "RtlHardcoded",
                "RtlSymmetry",
                "MissingPrefix",
                "MissingRegistered",
                "LockedOrientationActivity",
        )
    }

    namespace = "com.noveogroup.moviedb"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.koin.android)
    implementation(project(":core:design-system"))
    implementation(project(":feature:movie-list"))
    implementation(project(":feature:movie-detail"))
}