package com.example.taxilink.Friendship;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.AccountReg.CreateAccountPage;
import com.example.taxilink.R;
import com.example.taxilink.databinding.ProfilePageViewBinding;

public class ProfileView extends Fragment {

    private ProfilePageViewBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = ProfilePageViewBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ProfileBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.Friendship.ProfileView.this)
                        .navigate(R.id.action_ProfileView_to_CarpoolCustomerList);
            }
        });
        binding.addfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.Friendship.ProfileView.this)
                        .navigate(R.id.action_ProfileView_to_FriendsListPage);
                Toast.makeText(ProfileView.this.getContext(), "Friend Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
