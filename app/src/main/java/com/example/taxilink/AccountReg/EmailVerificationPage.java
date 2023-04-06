package com.example.taxilink.AccountReg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taxilink.databinding.EmailVerifBinding;

public class EmailVerificationPage extends Fragment{

    private EmailVerifBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = EmailVerifBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}
