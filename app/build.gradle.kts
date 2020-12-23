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
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
	
	val cardview_version = "1.0.0"
	val material_version = "1.2.1"
	val fragment_version = "1.2.5"
	val lifecycle_version = "2.2.0"
	val espresso_version = "3.3.0"
	
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation(dependencyNotation = "org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
	implementation(dependencyNotation = "androidx.appcompat:appcompat:1.2.0")
	
	implementation(dependencyNotation = "androidx.constraintlayout:constraintlayout:2.0.4")
	implementation(dependencyNotation = "androidx.lifecycle:lifecycle-extensions:$lifecycle_version")
	implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
	implementation(dependencyNotation = "androidx.fragment:fragment-ktx:$fragment_version")
	implementation(dependencyNotation = "androidx.cardview:cardview:$cardview_version")
	implementation(dependencyNotation = "com.google.android.material:material:$material_version")
	
	testImplementation(dependencyNotation = "junit:junit:4.13.1")
	
	androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.2")
	androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:$espresso_version")
}
