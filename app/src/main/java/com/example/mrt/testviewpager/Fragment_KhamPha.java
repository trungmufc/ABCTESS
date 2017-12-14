package com.example.mrt.testviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mr.T on 11/12/2017.
 */

public class Fragment_KhamPha extends Fragment {
    RecyclerView rl_khampha;

    public Fragment_KhamPha() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_khampha, container, false);
        rl_khampha = v.findViewById(R.id.rl_khampha);
        return v;
    }


}
