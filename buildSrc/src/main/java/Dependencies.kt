object Dependencies {

	object Kotlin {
		const val std = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin.std}"
		const val serialization =
			"org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.Kotlin.serialization}"
		const val test =
			"org.jetbrains.kotlin:kotlin-test-junit:${Version.Kotlin.std}"
	}

	object JUnit {
		const val jupiter = "org.junit.jupiter:junit-jupiter:${Version.Test.junit5}"
	}

	object Android {
		const val espresso =
			"androidx.test.espresso:espresso-core:${Version.InstTest.espresso}"
	}

	object InstTest {
		const val android = "androidx.test.ext:junit:${Version.InstTest.android}"
	}

}