plugins {
    id("moviecatalog.android.library")
    id("moviecatalog.android.library.compose")
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.ksp)

}

android {
    namespace = "com.noveogroup.moviecatalog.feature.moviedetail"
}

dependencies {
    ksp(libs.moshi.ksp)
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
    implementation(project(":core:design-system"))
    implementation(project(":core:movie-component"))
    implementation(project(":core:network"))
    implementation(project(":shared:movie-image-configuration"))

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.junit4)
    testImplementation(kotlin("test"))
    testImplementation(libs.mockk)
}