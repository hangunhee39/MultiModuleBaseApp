import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.feature")
}

android {
    setNamespace("feature.auth")
}

dependencies {
    implementation(libs.compose.shimmer)
}