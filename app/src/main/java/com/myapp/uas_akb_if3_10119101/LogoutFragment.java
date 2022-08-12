package com.myapp.uas_akb_if3_10119101;

/**
 *
 * NIM : 10119101
 * Nama : Andika Putra
 * Kelas : IF-3
 *
 * **/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;


public class LogoutFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private Button btnSignOut;

    public LogoutFragment() {
        // Required empty public constructor
    }


    public static LogoutFragment newInstance(String param1, String param2) {
        LogoutFragment fragment = new LogoutFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logout, container, false);

        btnSignOut = view.findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
            }
        });

        return view;
    }

}