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
        minSdk = 33
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
    implementation("androidx.core:core-ktx:1.12.0")

    // SESL CORE (From previous step)
    implementation("sesl.androidx.core:core-ktx:1.17.0+1.0.7-sesl8+rev1")
    implementation("sesl.androidx.appcompat:appcompat:1.7.1+1.0.21-sesl8+rev6")
    implementation("sesl.androidx.recyclerview:recyclerview:1.4.0+1.0.12-sesl8+rev2")
    implementation("sesl.androidx.preference:preference:1.2.1+1.0.0-sesl8+rev1")

    // SESL MATERIAL
    implementation("sesl.com.google.android.material:material:1.12.0+1.0.32-sesl8+rev1")

    // ONE UI DESIGN (The line from your instructions)
    implementation("io.github.tribalfs:oneui-design:0.8.15+oneui8")

    implementation("io.github.oneuiproject:icons:1.1.0")

    // 5. THE EXCLUSION PARADOX (Updated for new Group IDs)
    modules {
        // --- EXISTING RULES ---
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
        module("androidx.core:core") {
            replacedBy("sesl.androidx.core:core", "Use SESL Core")
        }
        module("androidx.core:core-ktx") {
            replacedBy("sesl.androidx.core:core-ktx", "Use SESL Core KTX")
        }

        // --- NEW CRITICAL RULES (ADD THESE) ---
        // This fixes the "Type Mismatch" error
        module("androidx.fragment:fragment") {
            replacedBy("sesl.androidx.fragment:fragment", "Use SESL Fragment")
        }
        module("androidx.activity:activity") {
            replacedBy("sesl.androidx.activity:activity", "Use SESL Activity")
        }
    }
}