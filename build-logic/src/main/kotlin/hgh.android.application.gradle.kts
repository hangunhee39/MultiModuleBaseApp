import com.hgh.mmt.configureHiltAndroid
import com.hgh.mmt.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()