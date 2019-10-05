package vn.sunasterisk.buoi02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends BaseActivity implements View.OnClickListener {

    private EditText mTextUsername;
    private EditText mTextPassword;
    private EditText mTextConfirmPassword;
    private Button mButtonSignUp;

    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void registerListeners() {
        mButtonSignUp.setOnClickListener(this);
    }

    @Override
    protected void intViews() {
        mTextUsername = findViewById(R.id.text_username);
        mTextPassword = findViewById(R.id.text_password);
        mTextConfirmPassword = findViewById(R.id.text_password_confirm);
        mButtonSignUp = findViewById(R.id.button_sign_up);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_sign_up;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_up:
                signUp();
                break;
            default:
                break;
        }
    }

    private void signUp() {
        String username = mTextUsername.getText().toString();
        String password = mTextPassword.getText().toString();
        String confirmPassword = mTextConfirmPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Fields is not empty!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, R.string.toast_wrong_password,
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra(USERNAME_KEY, username);
            returnIntent.putExtra(PASSWORD_KEY, password);
            setResult(RESULT_OK, returnIntent);
            finish();
        }
    }
}
