pluginManagement {
//    includeBuild("build-logic")

    includeBuild("D:\\AndroidStudioProjects\\weui\\core")
    includeBuild("D:\\AndroidStudioProjects\\weui\\build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven { url = uri("https://artifact.bytedance.com/repository/pangle") }
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url = uri("C:/Users/chengqingyuan/.m2/repositor") }
//        maven { url 'https://maven.aliyun.com/repository/public' }
        maven("https://maven.aliyun.com/repository/public")
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven {
            url = uri(
                "https://maven.aliyun.com/repository/jcenter"
            )
        }

//穿山甲
        maven { url = uri("https://artifact.bytedance.com/repository/pangle") }
        google()
        mavenCentral()
//        mavenLocal()

    }
}

rootProject.name = "ClientApp"
include(":app")
//ui
//include(":core:ui:theme")
//include(":core:ui:components")
//include(":core:data:model")
//include(":core:data:repository")
//include(":core:utils")
include(":mylibrary")
