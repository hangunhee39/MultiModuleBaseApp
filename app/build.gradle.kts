import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree.Companion.main

plugins {
    id("hgh.android.application")
}

android {
    namespace = "com.hgh.mmt"

    defaultConfig {
        applicationId = "com.hgh.mmt"
        versionCode = 1
        versionName = "1.0"

    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }

        create("benchmark") {
            matchingFallbacks.add("release")
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = false
        }
    }

}

dependencies {
    implementation(project(":feature:main"))
    implementation(project(":core:ui"))
    //implementation(project(":core:designsystem"))
}