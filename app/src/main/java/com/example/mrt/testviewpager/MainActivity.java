package com.example.mrt.testviewpager;


import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mrt.testviewpager.Adapter.CityAdapter;
import com.example.mrt.testviewpager.Model.LocationModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  static   ViewPager viewPager;
    TabLayout tabLayout;
    static  int idPlace = -1;
    ArrayList<LocationModel> listlocation;
    CityAdapter cityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter pagerAdapter = new PagerAdapter(manager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(2);
        //tabLayout.setTabsFromPagerAdapter(pagerAdapter);

    }


    public static void setIndexPager(int idDistrict)

    {
        idPlace = idDistrict;
        viewPager.setCurrentItem(2);
        Fragment_DiaDiem.loadData();
    }

}
