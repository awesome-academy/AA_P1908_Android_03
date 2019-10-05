package vn.sunasterisk.acitivitylifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: SecondActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: SecondActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: SecondActivity");
    }
}
