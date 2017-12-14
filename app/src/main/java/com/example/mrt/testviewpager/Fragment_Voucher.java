package com.example.mrt.testviewpager;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mr.T on 11/12/2017.
 */

public class Fragment_Voucher extends Fragment {
    public Fragment_Voucher() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_voucher, container, false);
        return v;
    }
}
