//package com.example.taxilink.AppData;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.taxilink.R;
//
//public class Camera extends AppCompatActivity {
//    Button btnCam;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.offer_link_page);
//        //btnCam = (Button) findViewById(R.id.btnCam);
//        btnCam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent = new Intent();
//                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivity(intent);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        });
//    }
//}
