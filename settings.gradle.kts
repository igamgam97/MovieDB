pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MovieDB"
include(":app")
include(":core:network")
include(":core:common")
include(":core:design-system")
project(":core:design-system").projectDir = file("core/designsystem")
include(":core:movie-component")
project(":core:movie-component").projectDir = file("core/component")
include(":shared:movie-image-configuration")
project(":shared:movie-image-configuration").projectDir = file("shared/movie/image/configuration")
include(":feature:movie-list")
project(":feature:movie-list").projectDir = file("feature/movielist")
include(":feature:movie-detail")
project(":feature:movie-detail").projectDir = file("feature/moviedetail")