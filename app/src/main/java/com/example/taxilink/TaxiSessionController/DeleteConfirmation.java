package com.example.taxilink.TaxiSessionController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.AccountReg.CreateAccountPage;
import com.example.taxilink.AccountReg.EmailVerificationPage;
import com.example.taxilink.R;
import com.example.taxilink.databinding.ConfirmProfileBinding;

public class DeleteConfirmation extends Fragment {


    private ConfirmProfileBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = ConfirmProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DeleteConfirmation.this.getContext(), "Account has been deleted" , Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(DeleteConfirmation.this)
                        .navigate(R.id.action_profileconfirmation_to_LoginPage);
            }
        });
        binding.nobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DeleteConfirmation.this)
                        .navigate(R.id.action_profileconfirmation_to_profileSettings);
            }
        });
    }

}
