import java.util.Properties

plugins {
    id("moviecatalog.android.application")
    id("moviecatalog.android.application.compose")
}

android {

    signingConfigs {
        create("release") {
            val properties = Properties().apply {
                load(File("./app/keystore/keystore.properties").reader())
            }
            storeFile = File(projectDir, properties.getProperty("storeFile"))
            storePassword = properties.getProperty("storePassword")
            keyPassword = properties.getProperty("keyPassword")
            keyAlias = properties.getProperty("keyAlias")
        }
    }

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

            signingConfig = signingConfigs.getByName("release")
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