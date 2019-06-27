package com.example.day;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {
    public  final List<Fragment> fragmentList = new ArrayList<>();
    public final List<String> fragmentListTitles = new ArrayList<>();
    public ViewPageAdapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }
    public  void  AddFrragment(Fragment fragment,String Title){
        fragmentList.add(fragment);
        fragmentListTitles.add(Title);
    }
}
