import com.hgh.mmt.configureCoroutineAndroid
import com.hgh.mmt.configureHiltAndroid
import com.hgh.mmt.configureKotlinAndroid


plugins {
    id("com.android.library")
    //id("droidknights.verify.detekt")
}

configureKotlinAndroid()
//configureKotest()
configureCoroutineAndroid()
configureHiltAndroid()
