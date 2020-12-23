plugins {
	id("com.android.library")
	id("kotlinx-serialization")
	kotlin("android")
}

android {
	compileSdkVersion(30)
	buildToolsVersion("30.0.2")
	
	defaultConfig {
		minSdkVersion(21)
		targetSdkVersion(30)
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFile(proguardFile = "consumer-rules.pro")
	}
	
	buildTypes {
		getByName("release") {
			minifyEnabled(false)
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
}

dependencies {
	implementation(project(":core"))
	
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation(Dependencies.Kotlin.std)
	implementation(Dependencies.Kotlin.serialization)

	implementation(dependencyNotation = "com.squareup.retrofit2:retrofit:2.9.0")
	implementation(dependencyNotation = "com.squareup.okhttp3:okhttp:4.9.0")
	implementation(dependencyNotation = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.7.0")

	testImplementation(Dependencies.Test.junit5)
	testImplementation(Dependencies.Test.kotlin)
	androidTestImplementation(Dependencies.InstTest.android)
}