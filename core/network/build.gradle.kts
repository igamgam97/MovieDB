plugins {
    id("moviecatalog.android.library")
}

android {
    namespace = "com.noveogroup.moviecatalog.core.network"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "API_KEY", "\"c9856d0cb57c3f14bf75bdc6c063b8f3\"")
        }
        debug {
            buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "API_KEY", "\"c9856d0cb57c3f14bf75bdc6c063b8f3\"")
        }
    }
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.okhttp.logging)
    implementation(libs.okhttp.core)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.retrofit.kotlin.moshi.converter)
    implementation(libs.retrofit.kotlin.moshi)
}