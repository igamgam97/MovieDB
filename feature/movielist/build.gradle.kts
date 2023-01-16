plugins {
    id("movicatalog.android.library")
    id("movicatalog.android.library.compose")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.noveogroup.moviecatalog.feature.movielist"
}

dependencies {
    ksp(libs.moshi.ksp)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.koin.android)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.androidx.paging.compose)
    implementation(libs.shimmer.compose)
    implementation(libs.koin.android.compose)
    implementation(project(":core:designsystem"))
    implementation(project(":core:component"))
    implementation(project(":core:network"))
    implementation(project(":core:common"))
    implementation(project(":shared:movie-image-configuration"))
}