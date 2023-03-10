plugins {
    id("moviecatalog.android.library")
    id("moviecatalog.android.library.compose")
}

android {
    namespace = "com.noveogroup.moviecatalog.core.component"
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.coil.kt.compose)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.koin.android)
    implementation(libs.androidx.compose.material3)
}