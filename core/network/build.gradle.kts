plugins {
    id("movicatalog.android.library")
}

android {
    namespace = "com.noveogroup.moviecatalog.core.network"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "API_KEY", "\"23197e6016670687445147376c72dc68\"")
        }
        debug {
            buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "API_KEY", "\"23197e6016670687445147376c72dc68\"")
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