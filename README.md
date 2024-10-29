# NewPineExample

- [AndroidIDE](https://m.androidide.com/) project
- To import for Android Studio you can change just few things in settings gradle and gradle inside `/app`
- Instead of using `AppComponentFactory`, this uses `.MyApplication` (i.e, `android:name`[Manifest] or `.super`[Smali]) for loading library
- loading [pine](https://github.com/canyie/pine) library from assets
    - By default architecture specific
    - if you want to load specific library without checking for specific arch [read](/app/src/main/java/com/newpine/example/README.md)
- needs only one class rather than using different classes unlike `AppComponentFactory` method (check [this](https://github.com/AbhiTheModder/Fine/blob/main/app/src/main/java/com/abhi/pineexample/Loader.java) project in case you wanna see how that is done) to load libs
- Load libraries based on arch of user system automatically

> [!TIP]
> If you're looking for [Android Studio](https://developer.android.com/studio) Version of this check out [studio](https://github.com/AbhiTheModder/NewPineExample/tree/studio) branch of this repo.

> [!NOTE]
> This is just an approach to showcase we can use `android:name` attribute also for hooking our target apps
