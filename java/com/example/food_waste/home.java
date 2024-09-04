package com.example.food_waste;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView nav_view;
    BottomNavigationView bot_view;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    ActionBar ab;

   DrawerLayout drawer_lay;
   ActionBarDrawerToggle drawerToggle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.baseline_menu_24);
        drawer_lay=findViewById(R.id.drawer_lay);
        nav_view=findViewById(R.id.nav_menu);
        drawerToggle=new ActionBarDrawerToggle(this,drawer_lay,R.string.open,R.string.close);
        drawer_lay.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        nav_view.setNavigationItemSelectedListener(this);
        bot_view=findViewById(R.id.bot_nav);
        bot_view.setBackground(null);

        ImageButton profile=(ImageButton) findViewById(R.id.profile_t);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home.this,Profile.class);
                startActivity(intent);
            }
        });

        bot_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId=item.getItemId();
                if(itemId==R.id.Restaurent){
                    openFragment(new Restaurents_frag());
                    return true;
                }
                else if(itemId==R.id.NGO){
                    openFragment(new ngos_frag());
                    return true;
                }
                else if(itemId==R.id.Delivery){
                    openFragment(new deliver_frag());
                    return true;
                }
              return false;
            }
        });
        fragmentManager=getSupportFragmentManager();
        openFragment(new Restaurents_frag());

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.nav_menu){
            drawer_lay.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.Restaurents){
            openFragment(new Restaurents_frag());
            return true;
        }
        else if(itemId==R.id.Home){
            openFragment(new ngos_frag());
            return true;
        }
        else if(itemId==R.id.deliver){
            openFragment(new deliver_frag());
            return true;
        }
        else if(itemId==R.id.profile){
            Intent intent=new Intent(home.this,Profile.class);
            startActivity(intent);
        }
        else if(itemId==R.id.location){
            Intent intent=new Intent(home.this,new_address.class);
            startActivity(intent);
        }
        else if(itemId==R.id.share){
            shareApp();
        }
        else if(itemId==R.id.rateus){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.example.yourapp");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if(itemId==R.id.aboutus){
            Uri uri = Uri.parse("https://www.c40knowledgehub.org/s/topic/0TO1Q0000001lRqWAI/food-waste-management?language=en_US");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if(itemId==R.id.logout){
            Intent intent=new Intent(home.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        drawer_lay.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if(drawer_lay.isDrawerOpen(GravityCompat.START)){
            drawer_lay.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
    private void openFragment(Fragment fragment){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app!");
        intent.putExtra(Intent.EXTRA_TEXT, "Download the awesome app at: https://play.google.com/store/apps/details?id=" + getPackageName());
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    
}