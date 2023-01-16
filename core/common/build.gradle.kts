plugins {
    id("moviecatalog.android.library")
    id("moviecatalog.android.library.compose")
}

android {
    namespace = "com.noveogroup.moviecatalog.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.navigation.compose)
}