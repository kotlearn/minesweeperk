package com.f776.convention

import org.gradle.api.Project
import java.io.FileInputStream
import java.util.Properties

fun Project.getVersionCodeAndNameProperty(): Pair<Int, String> {
    val versionPropertiesInputStream = FileInputStream("$rootDir/versions.properties")
    val versionProperties = Properties().apply {
        load(versionPropertiesInputStream)
    }
    val versionCodeProperty = versionProperties.getProperty("versionCode").toInt()
    val versionMajorProperty = versionProperties.getProperty("versionMajor").toInt()
    val versionMinorProperty = versionProperties.getProperty("versionMinor").toInt()
    val versionPatchProperty = versionProperties.getProperty("versionPatch").toInt()
    val versionNameProperty = "$versionMajorProperty.$versionMinorProperty.$versionPatchProperty"

    return versionCodeProperty to versionNameProperty
}