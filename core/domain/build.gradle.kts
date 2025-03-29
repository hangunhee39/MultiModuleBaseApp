import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.library")
}

android {
    setNamespace("core.domain")
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:data-local"))
    implementation(project(":core:model"))

    implementation(libs.inject)
}
