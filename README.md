# NewPineExample

- [AndroidIDE](https://m.androidide.com/) project
- To import for Android Studio you can change just few things in settings gradle and gradle inside `/app`
- Instead of using `AppComponentFactory`, this uses `.MyApplication` (i.e, `android:name`) for loading library
- loading [pine](https://github.com/canyie/pine) library from assets
    - By default architecture specific
    - if you want to load specific library without checking for specific arch [read](https://github.com/AbhiTheModder/NewPineExample/blob/main/app%2Fsrc%2Fmain%2Fjava%2Fcom%2Fnewpine%2Fexample%2FREADME.md)
- needs only one class rather than using different classes unlike `AppComponentFactory` method to load libs
- Load libraries based on arch of user system automatically

> [!NOTE]
> This is just an approach to showcase we can use `android:name` attribute also for hooking our target apps
