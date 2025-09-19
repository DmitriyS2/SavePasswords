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
        google()
        mavenCentral()
    }
}

rootProject.name = "SavePasswords"
include(":app")
include(":app_feature:base_feature")
include(":app_feature:login_feature")
include(":app_feature:registration_feature")
include(":app_feature:main_feature")
include(":app_feature:new_item_feature")
include(":common")
include(":domain")
include(":data")
include(":util")
