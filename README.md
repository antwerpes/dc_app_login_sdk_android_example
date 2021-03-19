DocCheck App Login SDK Example Android
==============================

This example app will demonstrate the usage of the [DocCheck App Login SDK](https://github.com/antwerpes/dc_app_login_sdk_android) for Android.

Configuration
------------

Change the login Id either within the `MainActivity.kt` 
```kotlin
class MainActivity : AppCompatActivity() {
    // ...
    private val loginId = "" // your login Id
    // ...
}


```
or within the app in the displayed input field. 

Make sure that the application identifier matches the bundle identifier used during configuration of ur credentials for the DocCheck App Login. This can be changed in the `build.gradle`.

```groovy
    applicationId "com.doccheck.loginapp" // your bundle id should match this to work
```
