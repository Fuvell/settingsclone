pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Load Secret Token
val localProperties = java.util.Properties()
val localPropertiesFile = rootProject.projectDir.resolve("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(java.io.FileInputStream(localPropertiesFile))
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // 1. SESL AndroidX (Core, Recycler, Preference)
        maven {
            name = "SeslAndroidX"
            url = java.net.URI("https://maven.pkg.github.com/tribalfs/sesl-androidx")
            credentials {
                username = localProperties.getProperty("gpr.usr")
                password = localProperties.getProperty("gpr.key")
            }
        }

        // 2. SESL Material (Buttons, Colors, Shapes)
        maven {
            name = "SeslMaterial"
            url = java.net.URI("https://maven.pkg.github.com/tribalfs/sesl-material-components-android")
            credentials {
                username = localProperties.getProperty("gpr.usr")
                password = localProperties.getProperty("gpr.key")
            }
        }

        // 3. OneUI Design (The Big Headers & Pickers)
        maven {
            name = "OneUIDesign"
            url = java.net.URI("https://maven.pkg.github.com/tribalfs/oneui-design")
            credentials {
                username = localProperties.getProperty("gpr.usr")
                password = localProperties.getProperty("gpr.key")
            }
        }
    }
}

rootProject.name = "SamsungSettingsReplica"
include(":app")