package com.example.taxilink.Friendship;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.R;
import com.example.taxilink.databinding.CarpoolCustomerListBinding;

public class CarpoolCustomerList extends Fragment {

    private CarpoolCustomerListBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CarpoolCustomerListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.friendsListBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.Friendship.CarpoolCustomerList.this)
                        .navigate(R.id.action_CarpoolCustomerList_to_CarpoolList);
            }
        });
        RelativeLayout layout1 = (RelativeLayout) view.findViewById(R.id.relativeLayout2);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(com.example.taxilink.Friendship.CarpoolCustomerList.this)
                        .navigate(R.id.action_CarpoolCustomerList_to_ProfileView);
            }
        });
    }
}