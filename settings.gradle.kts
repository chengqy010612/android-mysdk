pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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


        google()
        mavenCentral()
    }
}

rootProject.name = "ClientApp"
include(":app")
 