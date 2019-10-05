package vn.sunasterisk.buoi02;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        intViews();

        registerListeners();
    }

    protected abstract void registerListeners();

    protected abstract void intViews();

    protected abstract int getLayoutResId();
}
