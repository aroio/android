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
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
	implementation("androidx.appcompat:appcompat:1.2.0")
	
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	
	implementation("com.squareup.okhttp3:okhttp:4.9.0")
	
	implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.7.0")
	
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
	
	testImplementation("junit:junit:4.13.1")
	
	androidTestImplementation("androidx.test.ext:junit:1.1.2")
}