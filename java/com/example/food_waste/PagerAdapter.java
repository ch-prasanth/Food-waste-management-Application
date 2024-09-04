package com.example.food_waste;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.food_waste.fragments.accepted;
import com.example.food_waste.fragments.completed;
import com.example.food_waste.fragments.pending;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new pending();
            case 1:
                return new accepted();
            case 2:
                return new completed();
            default:
                return new pending();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
