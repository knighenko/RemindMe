package com.knyzhenko.remindme.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.knyzhenko.remindme.tabs.Calendar;
import com.knyzhenko.remindme.tabs.Future;
import com.knyzhenko.remindme.tabs.Past;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new Calendar();
            case 2:
                return new Past();
            default:
                return new Future();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
