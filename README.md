# [Flextudio](https://flextudio.com) SDK for Android

[![Platform](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/FlexSDKUser/FlexApp-Andriod)
[![Languages](https://img.shields.io/badge/language-java-orange.svg)](https://github.com/FlexSDKUser/FlexApp-Andriod)


## Table of contents

1.  [Introduction](#introduction)
1.  [Requirements](#requirements)
1.  [Quick start](#quick-start)
1.  [Step by step](#step-by-step)


## Introduction

The Flextudio SDK for Android allows us to easily build native app to run modules developed in flextudio.
<br />

### How it works

The Flextudio SDK enables use of all features and services supported by flextudio platform. By simply adding the SDK dependencies into a new android app project, a fully functional flex app can be built without any other setup or initalization.

## Requirements

The minimum requirements for the Flextudio SDK for Android are:
- `Android Studio Chipmunk(2021.2.1) or higher`
- `Android 10 (API level 29) or higher`
- `Java 11 or higher`
- `Android Gradle plugin 7.2.0 or higher`

> **Note**: Flextudio SDK includes initialization of firebase push notification and other dependencies. You are only required to include google-services.json corresponding to your package Id to take full advantage of flextudio push notification services.

## Quick start

You can download the source code for sample app from this repository and open it in your android studio for one step installation and testing.

## Step by step
Follow the steps below to create a new app of your own using Flextudio SDK.

### Step 1:  Create new android app project with*'No Activity'*in android studio.
Open Android Studio and create a new android app project with No Activity as a template.  
_File > New > New Project_…  
![Create new android app](https://create-s3-test1.s3.ap-northeast-2.amazonaws.com/readme-andr-sdk/CreateProj.png "Create new android app")  
Provide your desired application and package name.
Click Next and then click Finish.
> **Note**: This package name is also needed to generate google-services.json file for your application to support firebase push notification and other services.


### Step 2: Add the following code to your `settings.gradle` file:
After newly created project is loaded, open file `settings.gradle` from navigation drawer.  
Project > settings.gradle  
And add these lines inside **dependencyResolutionManagement**. Finally, it should look like this.
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
    ...
	//Add these lines in your project settings.gradle file. Copy start
        maven {
            url "https://raw.github.com/embarkmobile/zxing-android-minimal/mvn-repo/maven-repository/"
        }
        maven {
            url 'https://maven.google.com/'
        }
        maven { url "https://jitpack.io" }
        maven { url 'https://oss.sonatype.org/content/repositories/ksoap2-android-releases' }
        maven { url "https://raw.githubusercontent.com/FlexSDKCreator/SDK_Andriod/main"
            credentials(HttpHeaderCredentials) {
                name "Authorization"
                value "Bearer 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"
            }
            authentication {
                header(HttpHeaderAuthentication)
            }
        }
		//copy end
		...
    }
}

```
### Step 3: In `build.gradle`(:project) file,  add  these line (optional)
Also, open `build.gradle`(Project: *) file from _Project > build.gradle_ and add these lines
```gradle
buildscript {
    dependencies {
        classpath 'com.google.gms:google-services:4.4.0'
    }
}
```
> Note: Make sure the above code block isn't added to your app `build.gradle` file. **buildscript** block should be at the top of the file. Google services dependency is required to enable firebase notification and other services. You can skip this if you don't require these services.

### Step 4: In `build.gradle`(:app) file,  add  lines

#### Part 1- Add google service plugin (optional)
Also, open `build.gradle`(Module: *.app) file from _Project > app> build.gradle_ and add this line
```gradle
apply plugin: 'com.google.gms.google-services'
```

> Note: Make sure the above code block isn't added to your project `build.gradle` file. Google services plugin is required to enable firebase notification and other services. You should skip this plugin if you skipped Step 2.

#### Part 2 - Add Flextudio SDK
inside **dependencies**, add this line
```gradle
dependencies {
	...
	implementation 'kr.co.flexapp.andr:flex-lib:1.0.12'
	...
	modules {
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk7 is now part of kotlin-stdlib")
        }
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk8 is now part of kotlin-stdlib")
        }
    }
}
```
> Note: This is the most important part of adding flextudio SDK dependencies to your app project.

### Step 5: Add `google-services.json` file into the module(app-level) directory of your app  
This file is generated from [Firebase Console](https://console.firebase.google.com/ "Firebase Console") for the package id of your project.  
![Add google-services.json file](https://create-s3-test1.s3.ap-northeast-2.amazonaws.com/readme-andr-sdk/googlesvc.png "Add google-services.json file")
> Note: It is required to register the app in firebase project and provide Flextudio Team 'Server key' to send push notifiications to your apps. Alternatively, we (Flextudio Team) can assist you to generate the  `google-services.json` file. This step can be skipped if you didn't complete Step 3 and Step 4 - Part 1.

### Step 6: In `gradle.properties`, add  line
Open file `gradle.properties` from _Project > gradle.properties_ and add  line
```gradle
android.useAndroidX=true
android.enableJetifier=true
```
### Step 7: Sync your gradle files
The setup requied for using the Flextudio SDK in your app is already complete. Press *Sync Now* to load dependencies to your local machine. (_File > Sync Project with Gradle Files_)

### Step 8: Run app
Now, build  and run the project.
_Run >   Run_ or  press Alt+Shift+F10 keys.
