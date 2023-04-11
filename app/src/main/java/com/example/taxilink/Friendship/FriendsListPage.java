package com.example.taxilink.Friendship;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxilink.BaseEntity.User;
import com.example.taxilink.R;
import com.example.taxilink.TaxiSessionController.RequestResultPage;
import com.example.taxilink.databinding.FriendsListPageBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class FriendsListPage extends Fragment {
    private FriendsListPageBinding binding;
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("Users/Dr0vM3JOZFuMk9dZbG4j");

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FriendsListPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton backBtn = binding.friendsListBackBtn;
        TextView friends = binding.friendsListText;

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FriendsListPage.this)
                        .navigate(R.id.action_FriendsList_to_HomePage);
            }
        });
        binding.previousCarpoolsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FriendsListPage.this)
                        .navigate(R.id.action_FriendsListPage_to_CarpoolList);
            }
        });

        friends.setText("No friends yet.");
    }
    public void fetchFriends(View view) {
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    User fetchedUser = documentSnapshot.toObject(User.class);
                    String firstName = fetchedUser.getFirstName();
                    String lastName = fetchedUser.getLastName();
                    //friends.setText(firstName + " " +  lastName);
                }
            }
        });
    }
}
