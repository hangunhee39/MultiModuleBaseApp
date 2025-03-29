import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.feature")
}

android {
    setNamespace("feature.home")
}

dependencies {
    implementation(libs.kotlinx.immutable)
    implementation(libs.compose.shimmer)
}
