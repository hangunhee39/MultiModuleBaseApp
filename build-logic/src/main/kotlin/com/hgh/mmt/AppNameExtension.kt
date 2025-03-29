package com.hgh.mmt

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.hgh.mmt.$name"
    }
}