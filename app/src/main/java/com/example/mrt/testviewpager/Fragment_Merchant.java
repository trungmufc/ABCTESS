package com.example.mrt.testviewpager;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mr.T on 19/12/2017.
 */

public class Fragment_Merchant extends Fragment {
    RecyclerView rl_merchant;

    public Fragment_Merchant() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_merchant, container, false);
        rl_merchant = v.findViewById(R.id.rl_merchant);
        return v;

    }
}
