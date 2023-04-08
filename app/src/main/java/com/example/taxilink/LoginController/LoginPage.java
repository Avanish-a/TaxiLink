package com.example.taxilink.LoginController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.EncryptionController.RSAEncryption.RSA;
import com.example.taxilink.R;
import com.example.taxilink.databinding.LoginPageBinding;
import com.google.android.material.button.MaterialButton;

public class LoginPage extends Fragment {

    private LoginPageBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = LoginPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView email = binding.emailField;
        TextView password = binding.passwordField;
        MaterialButton loginBtn = binding.loginBtn;
        TextView createAccount = binding.createNewAcct;

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = email.getText().toString();
                String enteredPass = password.getText().toString();

                String emailRSA = LoginController.encrypt(enteredEmail);
                String passRSA = LoginController.encrypt(enteredPass);

                if (LoginController.login(emailRSA, passRSA) != null) {
                    NavHostFragment.findNavController(LoginPage.this)
                            .navigate(R.id.action_LoginPage_to_HomePage);
                } else {
                    Toast.makeText(LoginPage.this.getContext(), "Incorrect email or password." +
                            " Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoginPage.this)
                        .navigate(R.id.action_LoginPage_to_CreateAccountPage);
            }
        });
    }
}