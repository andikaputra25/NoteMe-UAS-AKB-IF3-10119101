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

public class RegisterActivity extends AppCompatActivity {
    TextView log;
    EditText inputEmail, password, confirmpassword;
    String email, password1, password2;
    Button btnDaftar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Action kembali ke login
        log = (TextView) findViewById(R.id.sudahadaakun);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });

        //Action untuk Login
        inputEmail = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.password2);
        btnDaftar = findViewById(R.id.btn_reg);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cek inputan
                registrasi();
            }
        });

    }
    //Validasi Register
    private void registrasi() {
        email =  inputEmail.getText().toString();
        password1 =  password.getText().toString();
        password2 =  confirmpassword.getText().toString();
        if (TextUtils.isEmpty(email)){
            inputEmail.setError("Email Harus Diisi!");
        }else if(TextUtils.isEmpty(password1)){
            password.setError("Password Harus Diisi!");
        }else if (password.length() < 6){
            confirmpassword.setError("Password minimal 6 karakter!");
        }else {
            mAuth.createUserWithEmailAndPassword(email, password2)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Jika Registrasi success
                                Toast.makeText(RegisterActivity.this, "Registrasi Sukses", Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                // Jika Registrasi Gagal
                                Toast.makeText(RegisterActivity.this, "Registrasi Gagal, masukkan password minimal 6 character!", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
        }
    }
}