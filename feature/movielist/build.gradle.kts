plugins {
    id("movicatalog.android.library")
    id("movicatalog.android.library.compose")
}

android {
    namespace = "com.noveogroup.moviecatalog.feature.movielist"
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.koin.android)
    implementation(project(":core:designsystem"))
}