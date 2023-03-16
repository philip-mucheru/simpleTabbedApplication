package com.example.assg_2;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assg_2.fragment.CourseFragment;
import com.example.assg_2.fragment.PersonalFragment;
import com.example.assg_2.fragment.SummaryFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PersonalFragment();
            case 1:
                return new CourseFragment();
            case 2:
                return new SummaryFragment();
            default:
                return new PersonalFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
