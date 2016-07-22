// -----------------------------------------------------------------------
// Device ID for testing Firebase Cloud Messaging: f6RhbW5Sgwc:APA91bHSEyS4c38y2GaBjEkyNES6UHxG6Tnk5LMhaoY5mpKUwS9LI_u9kADuRAFj2q0TfK_AO5tvmeig7zaf050-0_B7SLgKg6mKKjq4gMf-JJxoiKpHjc2NjJW54-VGJ6pF20GnP17p
// -----------------------------------------------------------------------
package com.ks.poc.testfcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        // Check if Google Play Service is available
        GoogleApiAvailability googleApiChecker = GoogleApiAvailability.getInstance();
        int resultCode = googleApiChecker.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            // Google API is not available
            Toast.makeText(MainActivity.this, "Google Play Service is NOT available", Toast.LENGTH_SHORT).show();
            googleApiChecker.getErrorDialog(this,resultCode,0).show();
        } else {
            Toast.makeText(MainActivity.this, "Google Play Service is available", Toast.LENGTH_SHORT).show();
        }

        String token = FirebaseInstanceId.getInstance().getToken();
        if (token != null) {
            Log.d(this.getClass().getName(), "Token: " + token);
        } else {
            Toast.makeText(MainActivity.this, "No token found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if Google Play Service is available
        GoogleApiAvailability googleApiChecker = GoogleApiAvailability.getInstance();
        int resultCode = googleApiChecker.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            // Google API is not available
            Toast.makeText(MainActivity.this, "Google Play Service is NOT available", Toast.LENGTH_SHORT).show();
            googleApiChecker.getErrorDialog(this,resultCode,0).show();
        } else {
            Toast.makeText(MainActivity.this, "Google Play Service is available", Toast.LENGTH_SHORT).show();
        }

        String token = FirebaseInstanceId.getInstance().getToken();
        if (token != null) {
            Log.d(this.getClass().getName(), "Token: " + token);
        } else {
            Toast.makeText(MainActivity.this, "No token found", Toast.LENGTH_SHORT).show();
        }

        // display content of the received intent
        if (getIntent() != null) {
            Toast.makeText(MainActivity.this, "Intent toString: " + getIntent().toString(), Toast.LENGTH_LONG).show();
            Log.d(this.getClass().getName(), "Intent toString: " + getIntent().toString());
            if (getIntent().getExtras() != null) {
                for (String key : getIntent().getExtras().keySet()) {
                    String value = getIntent().getExtras().getString(key);
                    Toast.makeText(MainActivity.this, "Key: " + key + " Value: " + value, Toast.LENGTH_LONG).show();
                    Log.d(this.getClass().getName(), "Intent Key: " + key + " Value: " + value);
                }
            }
        } else {
            Toast.makeText(MainActivity.this, "No Intent found", Toast.LENGTH_SHORT).show();
        }
    }
}
