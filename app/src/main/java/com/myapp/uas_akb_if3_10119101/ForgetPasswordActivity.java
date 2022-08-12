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
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {
    private EditText inputEmail;
    private Button btnreset;
    private TextView btnlogin;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        inputEmail = (EditText) findViewById(R.id.email);
        btnreset = (Button) findViewById(R.id.btn_reset);
        btnlogin = (TextView)findViewById(R.id.btn_log);
        auth = FirebaseAuth.getInstance();
        btnreset.setOnClickListener(new View.OnClickListener() {

            //Validasi Email
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();

                if (TextUtils.isEmpty(email)){
                    inputEmail.setError("Email harus diisi!");
                }else {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener(ForgetPasswordActivity.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ForgetPasswordActivity.this, "reset password berhasil, silahkan cek email!", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(ForgetPasswordActivity.this, "password gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        //button Login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgetPasswordActivity.this, LoginActivity.class));
            }
        });
    }
}