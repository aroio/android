plugins {
	id("com.android.application")
	kotlin("android")
}


android {
	compileSdkVersion(30)
	buildToolsVersion("30.0.2")

	defaultConfig {
		applicationId("de.abacuselectronics.aroiorc")
		minSdkVersion(21)
		targetSdkVersion(30)
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		getByName("release") {
			minifyEnabled(false)
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}

	@Suppress("UnstableApiUsage")
	buildFeatures {
		viewBinding = true
	}
}

dependencies {
	implementation(project(":core"))
	implementation(project(":network"))
	implementation(project(":database"))
	implementation(project(":nsd"))


	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation(Dependencies.Kotlin.std)
	implementation(dependencyNotation = "androidx.appcompat:appcompat:1.2.0")

	implementation(dependencyNotation = "androidx.constraintlayout:constraintlayout:2.0.4")
	implementation(dependencyNotation = "androidx.lifecycle:lifecycle-extensions:2.2.0")
	implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
	implementation(dependencyNotation = "androidx.fragment:fragment-ktx:1.2.5")
	implementation(dependencyNotation = "androidx.cardview:cardview:1.0.0")
	implementation(dependencyNotation = "com.google.android.material:material:1.2.1")

	testImplementation(Dependencies.Test.junit5)
	testImplementation(Dependencies.Test.kotlin)

	androidTestImplementation(Dependencies.InstTest.android)
	androidTestImplementation(Dependencies.InstTest.espresso)
}
