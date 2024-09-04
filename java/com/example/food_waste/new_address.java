package com.example.food_waste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class new_address extends AppCompatActivity {
    EditText door,land,street,city;
    Button save,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);
        add= (Button) findViewById(R.id.extra);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddressDialog();
            }
        });
    }
    // Inside MainActivity class
    private void openAddressDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_box);

        EditText door = dialog.findViewById(R.id.ed1);
        EditText land = dialog.findViewById(R.id.ed2);
        EditText street = dialog.findViewById(R.id.ed3);
        EditText city = dialog.findViewById(R.id.ed4);
        Button save = dialog.findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String door_a = door.getText().toString();
                String land_a = land.getText().toString();
                String street_a = street.getText().toString();
                String city_a = city.getText().toString();
                addCardView(door_a+","+land_a+","+street_a+","+city_a); // Call a method to add a new CardView
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void addCardView(String address) {
        CardView newCardView = new CardView(this);
        newCardView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        TextView addressTextView = new TextView(this);
        addressTextView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        addressTextView.setText(address);
        newCardView.addView(addressTextView);

        // You can customize the CardView's appearance here if needed

        RelativeLayout mainLayout = findViewById(R.id.add); // Replace with your main layout's ID
        mainLayout.addView(newCardView);
    }

}