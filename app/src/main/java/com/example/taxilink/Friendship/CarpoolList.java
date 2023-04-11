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
import com.example.taxilink.databinding.CarpoolListBinding;
import com.example.taxilink.databinding.CarpoolCustomerListBinding;

public class CarpoolList extends Fragment {

    private CarpoolListBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CarpoolListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.friendsListBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(com.example.taxilink.Friendship.CarpoolList.this)
                        .navigate(R.id.action_CarpoolList_to_FriendsListPage);
            }
        });
        RelativeLayout layout1 = (RelativeLayout) view.findViewById(R.id.relativeLayout1);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(com.example.taxilink.Friendship.CarpoolList.this)
                        .navigate(R.id.action_CarpoolList_to_CarpoolCustomerList);
            }
        });
    }
}
