plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "lk.javainstitute.managesalary"
    compileSdk = 34

    defaultConfig {
        applicationId = "lk.javainstitute.managesalary"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
//    implementation("com.github.LottieFiles:dotlottie-android:0.5.0")
    implementation ("com.airbnb.android:lottie:6.0.0")
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
}