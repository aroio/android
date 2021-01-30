object Dependencies {

	object Kotlin {
		const val std = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin.std}"
		const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.Kotlin.serialization}"
	}

	object Test {
		const val junit5 = "org.junit.jupiter:junit-jupiter:${Version.Test.junit5}"
		const val kotlin = "org.jetbrains.kotlin:kotlin-test-junit:${Version.Kotlin.std}"
	}

	object InstTest {
		const val android = "androidx.test.ext:junit:${Version.InstTest.android}"
		const val espresso = "androidx.test.espresso:espresso-core:${Version.InstTest.espresso}"
	}

}