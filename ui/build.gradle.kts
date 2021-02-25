plugins {
	id("com.android.library")
	kotlin("android")
}

android {
	compileSdkVersion 30
	
	defaultConfig {
		minSdkVersion 21
		targetSdkVersion 30
		versionCode 1
		versionName "1.0"
		
		testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles "consumer-rules.pro"
	}
	
	buildTypes {
		release {
			minifyEnabled false
			proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
		}
	}
	compileOptions {
		sourceCompatibility JavaVersion.VERSION_1_8
		targetCompatibility JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = '1.8'
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.0.0-beta01"
	}
}

dependencies {
	
	implementation(Dependencies.Kotlin.std)
	implementation("androidx.core:core-ktx:1.3.2")
	
	implementation("androidx.compose.ui:ui:1.0.0-beta01")
	// Tooling support (Previews, etc.)
	implementation("androidx.compose.ui:ui-tooling:1.0.0-beta01")
	// Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
	implementation("androidx.compose.foundation:foundation:1.0.0-beta01")
	// Material Design
	implementation("androidx.compose.material:material:1.0.0-beta01")
	
	testImplementation(Dependencies.JUnit.jupiter)
	testImplementation(Dependencies.Kotlin.test)
	
	androidTestImplementation("androidx.test.ext:junit:1.1.2")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}