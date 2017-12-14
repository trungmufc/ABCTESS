package com.example.mrt.testviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mr.T on 11/12/2017.
 */

public class Fragment_DiaDiem extends Fragment {
    public Fragment_DiaDiem() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_diadiem, container, false);
        return v;
    }
}
