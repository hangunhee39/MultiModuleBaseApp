import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.feature")
}

android {
    setNamespace("feature.user")
}

dependencies {
    implementation(libs.compose.shimmer)
}