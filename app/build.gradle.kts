plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.clientapp"
    compileSdk = 34

    defaultConfig {
//        applicationId = "com.example.clientapp"
//        applicationId = "com.bide.jushangtou"
        applicationId = "com.missgem.hwhnhl"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndk {
            abiFilters += listOf("armeabi", "armeabi-v7a", "arm64-v8a")
        }
    }


    signingConfigs {
        create("keyStore") {
            keyAlias = "hunanhaolao"
            keyPassword = "hunanhaolao123"
            storeFile = file("../ym.keystore")
            storePassword = "hunanhaolao123"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
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
    //
    implementation(libs.androidx.navigation.compose)
    //
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation("com.pangle.cn:ads-sdk-pro:5.6.0.7")
//    implementation("com.pangle.cn:ads-sdk-pro:6.5.0.4")
//    implementation(files("libs/open_ad_sdk_6.5.0.2.aar"))

//微信
    implementation("com.tencent.mm.opensdk:wechat-sdk-android:6.8.0")

    //ui
    implementation("cn.itpiggy:compose-ui:1.0.1")

//视频
    implementation("io.sanghun:compose-video:1.2.0")
    implementation("androidx.media3:media3-exoplayer:1.1.0") // [Required] androidx.media3 ExoPlayer依赖
    implementation("androidx.media3:media3-session:1.1.0") // [Required] MediaSession扩展依赖
    implementation("androidx.media3:media3-ui:1.1.0") // [Required] 基础播放器UI

    implementation("androidx.media3:media3-exoplayer-dash:1.1.0") // [Optional] 如果你的媒体项是DASH
    implementation("androidx.media3:media3-exoplayer-hls:1.1.0") // [Optional] 如果你的媒体项是HLS (m3u8..)

    implementation("com.tencent.liteav:LiteAVSDK_Player_Premium:latest.release")

//    implementation(project(":core:ui:theme"))
//    implementation(project(":core:ui:components"))
//    implementation(project(":core:utils"))
//    implementation(files("./libs/LiteAVSDK_Professional_12.2.0.15072.aar"))

//    implementation("org.example.hello:0.0.3")
    implementation(project(":mylibrary"))
}