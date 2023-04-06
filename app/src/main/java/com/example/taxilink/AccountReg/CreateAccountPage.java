package com.example.taxilink.AccountReg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.FirstFragment;
import com.example.taxilink.R;
import com.example.taxilink.databinding.CreateAccountBinding;

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

        binding.SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CreateAccountPage.this)
                        .navigate(R.id.action_CreateAccountPage_to_EmailVerificationPage);
            }
        });
    }
}
