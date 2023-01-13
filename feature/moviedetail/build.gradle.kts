plugins {
    id("movicatalog.android.library")
    id("movicatalog.android.library.compose")
}

android {
    namespace = "com.noveogroup.moviecatalog.feature.moviedetail"
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.koin.android)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.koin.android.compose)
    implementation(project(":core:designsystem"))
    implementation(project(":core:component"))
    implementation(project(":core:network"))
    implementation(project(":shared:movie-image-configuration"))

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.junit4)
    testImplementation(kotlin("test"))
    testImplementation(libs.mockk)
}