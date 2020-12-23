plugins {
	id("com.android.library")
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
	implementation(project(path = ":core"))
	
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation(dependencyNotation = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
	implementation(dependencyNotation =  "androidx.appcompat:appcompat:1.2.0")
	
	// Room
	implementation(dependencyNotation = "androidx.room:room-runtime:2.2.6")
	annotationProcessor(dependencyNotation = "androidx.room:room-compiler:2.2.6")
	
	testImplementation(dependencyNotation = "junit:junit:4.13.1")
	
	androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.2")
}