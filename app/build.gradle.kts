plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.samsungsettingsreplica"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.samsungsettingsreplica"
        minSdk = 36
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // 1. Base Kotlin
    implementation("androidx.core:core-ktx:1.17.0")

    // 2. SESL CORE (One UI 8 / Android 15)
    implementation("sesl.androidx.core:core-ktx:1.17.0+1.0.7-sesl8+rev1")
    implementation("sesl.androidx.appcompat:appcompat:1.7.1+1.0.21-sesl8+rev6")
    implementation("sesl.androidx.recyclerview:recyclerview:1.4.0+1.0.12-sesl8+rev2")
    implementation("sesl.androidx.preference:preference:1.2.1+1.0.0-sesl8+rev1")
    implementation("sesl.androidx.drawerlayout:drawerlayout:1.2.0+1.0.0-sesl8+rev0")

    // 3. SESL MATERIAL (The Styling)
    implementation("sesl.com.google.android.material:material:1.12.0+1.0.32-sesl8+rev1")

    // 4. ONE UI DESIGN (The Complex Widgets)
    implementation("io.github.tribalfs:oneui-design:0.8.15+oneui8")

    // 5. THE EXCLUSION PARADOX (Updated for new Group IDs)
    modules {
        module("androidx.recyclerview:recyclerview") {
            replacedBy("sesl.androidx.recyclerview:recyclerview", "Use SESL RecyclerView")
        }
        module("androidx.drawerlayout:drawerlayout") {
            replacedBy("sesl.androidx.drawerlayout:drawerlayout", "Use SESL DrawerLayout")
        }
        module("com.google.android.material:material") {
            replacedBy("sesl.com.google.android.material:material", "Use SESL Material")
        }
        module("androidx.preference:preference") {
            replacedBy("sesl.androidx.preference:preference", "Use SESL Preference")
        }
        module("androidx.appcompat:appcompat") {
            replacedBy("sesl.androidx.appcompat:appcompat", "Use SESL AppCompat")
        }
    }
}