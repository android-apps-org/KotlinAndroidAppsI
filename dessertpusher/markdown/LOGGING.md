# [Logcat](https://developer.android.com/studio/debug/am-logcat)

##  [Timber](https://github.com/JakeWharton/timber)

- generates tags
- avoid logs in release app apks
- easy integration with crash reporting

## [Android Debug Bridge (adb)](https://developer.android.com/studio/command-line/adb)

- add adb to path
  - Tools -> SDK Manager -> Android SDK Location
  - add to path per OS
- adb shell am kill com.jdemaagd.sobremesa

## Saved Instance State

- When OS restarts app:
- Android does its best to reset app to state it had before
- Android takes state of some of the views and saves them to a bundle
  - whenever user navigates away from Activity
  - i.e. text in EditText (must have id)
  - also Back Stack information
- Uses Bundle to try and get Activity back to same state as before
- Does not know about custom data
  - need to manually add to bundle

## Configuration Change

- state of device changes so radically
  - easiest way to resolve is to rebuild Activity
- uses onSaveInstanceState to restore Activity
- Examples of Configuration Change:
  - language change on device
  - remove plug in hardware keyboard
  - device rotation

## Share Dialog Example

- Opening share popup puts Activity in onPause state
- Clicking outside share dialog puts Activity in onResume state
- Not same as navigating away from Activity
  - Activity is still on screen (partially) and considered in foreground
  - this is what differentiates onStop/onStart from onResume/onPause
  - onResume/onPause have to do with focus
    - onResume called when Activity has focus
    - onPause called when Activity loses focus
- onStart called when Activity becomes visible
- onStop called when Activity goes off screen

