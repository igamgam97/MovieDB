plugins {
    id("movicatalog.android.library")
}

android {
    namespace = "com.noveogroup.moviecatalog.shared.movie.image.configuration"
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.koin.android)
}