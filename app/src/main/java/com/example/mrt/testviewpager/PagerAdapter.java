package com.example.mrt.testviewpager;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Mr.T on 11/12/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    final int page_count = 3;
    private String tabTitile[] = new String[]{"Khám phá", "Voucher mới", "Địa điểm"};


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new Fragment_KhamPha();
                break;
            case 1:
                frag = new Fragment_Voucher();
                break;
            case 2:
                frag = new Fragment_DiaDiem();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return page_count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitile[position];
    }
}
