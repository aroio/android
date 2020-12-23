plugins {
	id("com.android.library")
	kotlin("android")
}

android {
	compileSdkVersion(apiLevel = 30)
	buildToolsVersion(version = "30.0.2")

	defaultConfig {
		minSdkVersion(minSdkVersion = 21)
		targetSdkVersion(targetSdkVersion = 30)
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFile(proguardFile = "consumer-rules.pro")
	}

	buildTypes {
		getByName("release") {
			minifyEnabled(enabled = false)
			proguardFiles(
				getDefaultProguardFile(name = "proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
}

dependencies {
	implementation(project(path = ":core"))
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

	implementation(dependencyNotation = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
	implementation(dependencyNotation = "androidx.appcompat:appcompat:1.2.0")
	implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
	implementation(dependencyNotation = "com.github.andriydruk:rx2dnssd:0.9.13")

	testImplementation(dependencyNotation = "junit:junit:4.13.1")

	androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.2")
}