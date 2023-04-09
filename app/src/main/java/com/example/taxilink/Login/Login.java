//package com.example.taxilink.Login;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.navigation.fragment.NavHostFragment;
//
//import com.example.taxilink.R;
//import com.example.taxilink.databinding.LoginPageBinding;
//
//public class Login extends Fragment {
//
//    private LoginPageBinding binding;
//
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//
//        binding = LoginPageBinding.inflate(inflater, container, false);
//        return binding.getRoot();
//
//    }
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(Login.this)
//                        .navigate(R.id.action_LoginPage_to_HomePage);
//            }
//        });
//        binding.createNewAcct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(Login.this)
//                        .navigate(R.id.action_LoginPage_to_CreateAccountPage);
//            }
//        });
//    }
//}