// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

	val kotlin_version by extra("1.4.21")
	repositories {
		google()
		jcenter()
	}

	dependencies {
		classpath(dependencyNotation = "com.android.tools.build:gradle:4.1.2")
		classpath(dependencyNotation = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
		// NOTE: Do not place your application dependencies here; they belong
		// in the individual module build.gradle files
	}
}

allprojects {
	repositories {
		google()
		jcenter()
	}
}

tasks.register("clean", Delete::class) {
	delete(rootProject.buildDir)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
	kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}