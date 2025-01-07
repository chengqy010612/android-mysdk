pluginManagement {
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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
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
    }
}

rootProject.name = "ClientApp"
include(":app")
 