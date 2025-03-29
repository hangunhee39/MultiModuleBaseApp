import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.feature")
}

android {
    setNamespace("feature.main")

    defaultConfig {testInstrumentationRunner =
        "com.droidknights.app.core.testing.runner.HghTestRunner"
    }
}

dependencies {
    implementation(project(":feature:home"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:user"))
    implementation(project(":feature:setting"))
//    implementation(projects.feature.setting)
//    implementation(projects.feature.contributor)
//    implementation(projects.feature.session)
//    implementation(projects.feature.bookmark)
    androidTestImplementation(project(":core:testing"))
//    debugImplementation(projects.core.ui)
//
//    implementation(projects.widget)
//    implementation(projects.core.dataApi)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.kotlinx.immutable)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.android.compiler)
}