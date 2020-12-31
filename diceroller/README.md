# Dice Roller: Android Anatomy

## Think About

- What buttons and text do I click normally in my favorite apps?
  - What might their listeners do?
- What views might comprise my favorite app layouts?
- What Android versions do my favorite apps support?
  - Why? (you can find this on the Google Play Store)

## Kotlin and Gradle Versions

- [Android Releases](https://developer.android.com/studio/releases)
- [Kotlin](https://kotlinlang.org/)
- [Kotlin latest Releases](https://github.com/JetBrains/kotlin/releases/tag/v1.4.0)
- [Gradle Releases](https://gradle.org/releases/)
- [Android Gradle Plugin Release Notes](https://developer.android.com/studio/releases/gradle-plugin)
- [Generated Gradle Files](https://developer.android.com/training/basics/firstapp/#review_the_list_of_generated_gradle_files)
- [Gradle - Building Android Apps](https://docs.gradle.org/current/samples/sample_building_android_apps.html)
- [Gradle Plugin](https://developer.android.com/studio/releases/gradle-plugin)
- [Distribution Dashboard](https://developer.android.com/about/dashboards/)

## Activity

- MainActivity
  - An Activity: core Android class
    - responsible for drawing an app user interface
    - and receiving input events
- When app launches, it launches specific Activity (i.e. MainActivity)
  - declared in Android.Manifest
  - with correct intent-filter tag
- Activities have an associated layout file (i.e. activity_main.xml)
- AppCompatActivity: subclass of Android
  - gives access to modern Android features
  - while providing backwards compatibility with older Android versions
  - use to make app available to largest amount of users and devices possible

## Layout

- activity_main
  - xml file that express what the app looks like
    - define text, images, buttons
    - and where they will appear on screen
  - XML view tags (i.e. text, images, buttons)
- Layout Inflation: connects Activity and Layout
  - triggered when the Activity starts
  - views defined in xml are inflated into Kotlin View objects in memory
  - then Activity can draw them to screen and also modify them dynamically
- Text: units in sp (scale independent pixels)
  - measurement for sizing text independently of device display quality

## Gradle (Android Build Tool)

- What devices run your app
- Compile to executable
- Dependency management
- App signing for Google Play
- Automated Tests

## Run in Android Studio

- Series of gradle commands compiles source code, dependencies, and associated resources into APK
  - Resources
  - Compiled Code
  - AndroidManifest
  - Other stuff
- Android Application Package
  - executable file format for distributing/installing Android applications
- After its built by Gradle, Android Studio transfers APK to physical device/emulator
- Project build.gradle
  - project wide build settings
- Module build.gradle
  - Module: collection of source files and resources for a discrete piece of functionality in app

## Resources

- [Android Versions](https://en.wikipedia.org/wiki/Android_version_history)
- [setContentView](https://developer.android.com/reference/android/app/Activity.html#setContentView(int))
- [LinearLayout](https://developer.android.com/guide/topics/ui/layout/linear)
- [Styles and Themes](https://medium.com/@mananwason/working-with-styles-and-themes-in-android-e4ff4e6301ee)
- [Toast Messages](https://developer.android.com/guide/topics/ui/notifiers/toasts)

