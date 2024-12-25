plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.dog_data_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.dog_data_app"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }

//    packaging {
//        resources.excludes.add("META-INF/DEPENDENCIES")
//        resources.excludes.add("META-INF/LICENSE")
//        resources.excludes.add("META-INF/LICENSE.txt")
//        resources.excludes.add("META-INF/license.txt")
//        resources.excludes.add("META-INF/NOTICE")
//        resources.excludes.add("META-INF/NOTICE.txt")
//        resources.excludes.add("META-INF/notice.txt")
//        resources.excludes.add("META-INF/ASL2.0")
//        resources.excludes.add("META-INF/*.kotlin_module")
//
//        }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    //coroutines
    implementation(libs.coroutines)

    //viewModel
    implementation(libs.view.model)

    //liveData
    implementation(libs.live.data)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //hilt-compose
    implementation(libs.hitl.compose)

    //live-data-compose
    implementation(libs.live.data.compose)

    //coil
    implementation(libs.coil)
    implementation(libs.coil.network)

    //TESTING
    //Mockk
    implementation(libs.mockk)
    //Junit
    testImplementation(libs.junit)
    //coroutines-test
    testImplementation(libs.coroutines.test)
    //core-test
    testImplementation(libs.core.test)

    testImplementation(libs.junit.jupiter)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)



}