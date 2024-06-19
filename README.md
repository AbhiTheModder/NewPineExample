# NewPineExample

- [AndroidIDE](https://m.androidide.com/) project
- Instead of using `AppComponentFactory`, this uses `.MyApplication` (i.e, `android:name`) for loading library
- loading [pine](https://github.com/canyie/pine) library from assets
- needs only one class rather than using different classes unlike `AppComponentFactory` method to load libs
- Load libraries based on arch of user system automatically

> [!NOTE]
> This is just an approach to showcase we can use `android:name` attribute also for hooking our target apps
