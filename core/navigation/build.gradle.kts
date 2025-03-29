import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.library")
    id("hgh.android.compose")
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.navigation")
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
