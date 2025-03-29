import com.hgh.mmt.setNamespace

plugins {
    id("hgh.android.library")
}

android {
    setNamespace("core.datastore")
}

dependencies {
    testImplementation(libs.junit4)
    testImplementation(libs.kotlin.test)
    implementation(libs.androidx.datastore)
}
