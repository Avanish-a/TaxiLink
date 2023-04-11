package com.example.taxilink.AccountReg;

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

import com.example.taxilink.BaseEntity.User;
import com.example.taxilink.R;
import com.example.taxilink.databinding.CreateAccountBinding;
import com.google.android.material.button.MaterialButton;

public class CreateAccountPage extends Fragment{

    private CreateAccountBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CreateAccountBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView firstName = binding.firstNameField;
        TextView lastName = binding.lastNameField;
        TextView email = binding.emailRegField;
        TextView password = binding.passwordField;
        TextView dob = binding.dobField;

        MaterialButton submitBtn = (MaterialButton) binding.SubmitButton;
        MaterialButton backBtn = (MaterialButton) binding.BackButton;

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredFirstName = firstName.getText().toString();
                String enteredLastName = lastName.getText().toString();
                String enteredEmail = email.getText().toString();
                String enteredPassword = password.getText().toString();
                String enteredDob = dob.getText().toString();
                if (!enteredFirstName.isEmpty() && !enteredLastName.isEmpty()&& !enteredEmail.isEmpty()&& !enteredPassword.isEmpty()&& !enteredDob.isEmpty()){
                    User newCustomer = new User(enteredFirstName, enteredLastName, enteredDob, "", enteredEmail, enteredPassword);

                    // add to database;

                    NavHostFragment.findNavController(CreateAccountPage.this)
                            .navigate(R.id.action_CreateAccountPage_to_EmailVerificationPage);
                } else {
                    Toast.makeText(CreateAccountPage.this.getContext(), "Please fill in all fields" +
                            " Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CreateAccountPage.this)
                        .navigate(R.id.action_CreateAccountPage_to_LoginPage);
            }
        });
    }
}
