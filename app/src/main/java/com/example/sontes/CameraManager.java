// CameraManager.java

package com.example.sontes;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;

public class CameraManager {
    private static final String TAG = "CameraManager";
    private Camera camera;

    public CameraManager() {
        // Default constructor
    }

    public void openCamera(int cameraId) {
        try {
            camera = Camera.open(cameraId);
            Log.d(TAG, "Camera opened: " + cameraId);
        } catch (Exception e) {
            Log.e(TAG, "Error opening camera: " + e.getMessage());
        }
    }

    public void releaseCamera() {
        if (camera != null) {
            camera.release();
            camera = null;
            Log.d(TAG, "Camera released.");
        }
    }

    public void startPreview() {
        if (camera != null) {
            camera.startPreview();
            Log.d(TAG, "Preview started.");
        }
    }

    public void stopPreview() {
        if (camera != null) {
            camera.stopPreview();
            Log.d(TAG, "Preview stopped.");
        }
    }
}