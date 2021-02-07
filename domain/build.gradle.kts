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
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(dependencyNotation = project(path = ":network"))
	implementation(dependencyNotation = project(path = ":database"))
	implementation(dependencyNotation = project(path = ":core"))

	implementation(Dependencies.Kotlin.std)
	testImplementation(Dependencies.JUnit.jupiter)
	testImplementation(Dependencies.Kotlin.test)
}

android.sourceSets.all {
	java.srcDir("src/$name/kotlin")
}
