import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.library")
    id("hgh.android.compose")
}

android {
    setNamespace("core.ui")
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))

    implementation(libs.androidx.lifecycle.viewModelCompose)
}
