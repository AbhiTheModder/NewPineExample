package com.newpine.example;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.core.app.AppComponentFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import top.canyie.pine.Pine;
import top.canyie.pine.callback.MethodReplacement;

public class MyApplication extends Application {
    // Name of the folder inside assets/ containing your libs    
    private static final String NATIVE_LIB_DIR = "lib";

    public static void loadNativeLibraries(Context context) {
    try {
        // Get the data directory of the app
        File dataDir = context.getDataDir();

        // Create a directory for the native libraries if it doesn't exist
        File libDir = new File(dataDir, NATIVE_LIB_DIR);
        if (!libDir.exists()) {
            libDir.mkdirs();
        }

        // Get the AssetManager to access the files in the assets folder
        AssetManager assetManager = context.getAssets();

        // Get the list of the device's supported ABIs
        String[] supportedAbis = Build.SUPPORTED_ABIS;

        // Iterate through the supported ABIs and check if there's a matching architecture-specific folder
        for (String abi : supportedAbis) {
            // Get libraries present inside assets on our defined directory with user's system architecture
            String[] libs = assetManager.list(NATIVE_LIB_DIR + "/" + abi);
            if (libs.length > 0) {
                // Load the native libraries from the matching folder
                for (String lib : libs) {
                    // Open the input stream
                    InputStream in = assetManager.open(NATIVE_LIB_DIR + "/" + abi + "/" + lib);
                    // Create an output stream
                    // This is the folder where the library files will be copied to
                    FileOutputStream out = new FileOutputStream(new File(libDir, lib));
                    // Create a buffer to hold the data being read from the input stream
                    byte[] buffer = new byte[1024];
                    //Read data from input stream into buffer
                    int read;
                    // Write our read data from input stream to output stream
                    while ((read = in.read(buffer)) != -1) {
                        out.write(buffer, 0, read);
                    }

                    // close input and output stream after done
                    in.close();
                    out.close();
                }
                break; // Exit the loop once a matching folder is found
            }
        }

            // Load our library
            String lib = "libpine.so"; // Name of the library, You can change as per your need
            System.load(new File(libDir, lib).getAbsolutePath()); // Load our library

    } catch (IOException e) {
        e.printStackTrace();
    } 
}
    
    public static void hook() {
        // PineHook process
        try {
            // Define a target method
            Method isPro = Class.forName("com.newpine.example.MainActivity").getDeclaredMethod("isPro");
            // Start hook on target method
            Pine.hook(isPro, MethodReplacement.returnConstant(true));
        } catch (Throwable th) {
            throw new ExceptionInInitializerError(th);
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // Load native libraries
        loadNativeLibraries(this);
      //  Start hook()
        hook();
    }
}
