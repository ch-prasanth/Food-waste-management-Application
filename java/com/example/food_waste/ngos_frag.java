package com.example.food_waste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ngos_frag extends Fragment {
    ImageButton imbt1,imbt2,imbt3,imbt4;
    CardView cv1,cv2,cv3,cv4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_restaurents, container, false);
        imbt1=rootview.findViewById(R.id.imageButton1);
        imbt2=rootview.findViewById(R.id.imageButton2);
        imbt3=rootview.findViewById(R.id.imageButton3);
        imbt4=rootview.findViewById(R.id.imageButton4);
        cv1=rootview.findViewById(R.id.cv1);
        cv2=rootview.findViewById(R.id.cv2);
        cv3=rootview.findViewById(R.id.cv3);
        cv4=rootview.findViewById(R.id.cv4);
        imbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), donate.class);
                startActivity(intent);
            }
        });
        imbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), History.class);
                startActivity(intent);
            }
        });
        imbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), login.class);
                startActivity(intent);
            }
        });
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), History.class);
                startActivity(intent);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), edit_profile.class);
                startActivity(intent);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGoogleMaps();
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), edit_profile.class);
                startActivity(intent);
            }
        });
        return rootview;

    }
    private void openGoogleMaps() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode("My Current Location"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }


}