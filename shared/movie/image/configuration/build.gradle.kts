plugins {
    id("movicatalog.android.library")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.noveogroup.moviecatalog.shared.movie.image.configuration"
}

dependencies {
    ksp(libs.moshi.ksp)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.koin.android)
}