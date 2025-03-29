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


rootProject.name = "MultiModule"
include(":app")

include(":feature:main")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:navigation")
include(":core:designsystem")
include(":core:ui")
include(":core:datastore")
include(":core:data-local")
include(":feature:home")
include(":core:testing")
include(":feature:user")
include(":feature:setting")
include(":feature:auth")
