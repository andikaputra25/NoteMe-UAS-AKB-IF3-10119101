package com.myapp.uas_akb_if3_10119101;

/**
 *
 * NIM : 10119101
 * Nama : Andika Putra
 * Kelas : IF-3
 *
 * **/

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextView reg, forgotpassword;
    EditText inputEmail, inputPassword;
    String email, password;
    Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        //untuk Login
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_log);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cek inputan
                ceklogin();
            }
        });

        //action untuk membuat akun baru
        reg = (TextView) findViewById(R.id.create_account);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(create);
            }
        });

        //untuk lupa password
        forgotpassword = (TextView) findViewById(R.id.forgetpassword);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(forgot);
            }
        });

    }
    //Validasi Login
    private void ceklogin() {
      email =  inputEmail.getText().toString();
      password =  inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            inputEmail.setError("Masukkan Email!");
        }else if(TextUtils.isEmpty(password)){
            inputPassword.setError("Password Harus Diisi!");
        }else if (password.length() < 6){
            inputPassword.setError("Password minimal 6 karakter!");
        }else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Jika Login Sukses
                                Toast.makeText(LoginActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();
                                //Masuk ke Beranda(Halaman Utama)
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            } else {
                                // Jika Login Gagal
                                Toast.makeText(LoginActivity.this, "Login Gagal!", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
        }
    }
}