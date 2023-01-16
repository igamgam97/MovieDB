plugins {
    id("moviecatalog.android.library")
    id("moviecatalog.android.library.compose")
}

android {
    namespace = "com.noveogroup.moviecatalog.core.designsystem"
}

dependencies {
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material3)
}