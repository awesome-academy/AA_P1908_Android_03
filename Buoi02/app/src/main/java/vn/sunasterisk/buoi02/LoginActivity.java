package vn.sunasterisk.buoi02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private Button mButtonLogin;
    private TextView mTextSignUp;
    private EditText mTextUsername;
    private EditText mTextPassword;

    private static final int SIGN_UP_USER_REQUEST = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void registerListeners() {
        mButtonLogin.setOnClickListener(this);
        mTextSignUp.setOnClickListener(this);
    }

    @Override
    protected void intViews() {
        mButtonLogin = findViewById(R.id.button_login);
        mTextSignUp = findViewById(R.id.text_sign_up);
        mTextUsername = findViewById(R.id.text_username_input);
        mTextPassword = findViewById(R.id.text_password_input);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                login();
                break;
            case R.id.text_sign_up:
                signUp();
                break;
            default:
                break;
        }
    }

    private void signUp() {
        Intent intent = new Intent(this,
                SignUpActivity.class);
        startActivityForResult(intent, SIGN_UP_USER_REQUEST);
    }

    private void login() {
        String username = mTextUsername.getText().toString();
        String password = mTextPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                    this,
                    "username and password is not empty!",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        if (username.equals("nguyen.minh.tuan") && password.equals("123456")) {
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            openMainActivity();
        } else {
            Toast.makeText(this, "Login Failure!", Toast.LENGTH_SHORT).show();
        }
    }

    private void openMainActivity() {
        Intent intent = new Intent(this,
                MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent returnIntent) {
        if(requestCode == SIGN_UP_USER_REQUEST){
            if(resultCode == RESULT_OK){
                String username = returnIntent
                        .getStringExtra(SignUpActivity.USERNAME_KEY);
                String password = returnIntent
                        .getStringExtra(SignUpActivity.PASSWORD_KEY);

                mTextUsername.setText(username);
                mTextPassword.setText(password);
            }
        }
    }
}
