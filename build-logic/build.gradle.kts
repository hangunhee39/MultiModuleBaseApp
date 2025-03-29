plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.verify.detektPlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "hgh.android.hilt"
            implementationClass = "com.hgh.mmt.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "hgh.kotlin.hilt"
            implementationClass = "com.hgh.mmt.HiltKotlinPlugin"
        }
    }
}
