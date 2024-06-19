> [!NOTE]
> The code used in this directory `.MyApplication` requires this type of placement for libraries to be able to identify and load the libraries by identifying user specific architecture:
```plaintext
assets/
└── lib
    ├── arm64-v8a
    │   └── libpine.so
    └── armeabi-v7a
        └── libpine.so
```

Now in case you kisi want a single library like `assets/lib/libpine.so`:
```plaintext
assets/
└── lib
    └── libpine.so
```

for that you can modify `MyApplication.java` where it's checking device architecture for user like:

```java
            AssetManager assetManager = context.getAssets();

            // Get the list of native libraries in the assets folder
            String[] libs = assetManager.list(NATIVE_LIB_DIR);

            // Copy each native library to the app's data directory
            for (String lib : libs) {
                InputStream in = assetManager.open(NATIVE_LIB_DIR + "/" + lib);
```

I've commented this in the class also.