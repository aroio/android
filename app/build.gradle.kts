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

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}

	@Suppress("UnstableApiUsage")
	buildFeatures {
		viewBinding = true
	}
}

dependencies {
	implementation(project(":core"))
	implementation(project(":domain"))


	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation(Dependencies.Kotlin.std)
	implementation(dependencyNotation = "androidx.appcompat:appcompat:1.2.0")

	implementation(dependencyNotation = "androidx.constraintlayout:constraintlayout:2.0.4")
	implementation(dependencyNotation = "androidx.lifecycle:lifecycle-extensions:2.2.0")
	implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
	implementation(dependencyNotation = "androidx.fragment:fragment-ktx:1.2.5")
	implementation(dependencyNotation = "androidx.cardview:cardview:1.0.0")
	implementation(dependencyNotation = "com.google.android.material:material:1.3.0")

	testImplementation(Dependencies.JUnit.jupiter)
	testImplementation(Dependencies.Kotlin.test)

	androidTestImplementation(Dependencies.InstTest.android)
}
