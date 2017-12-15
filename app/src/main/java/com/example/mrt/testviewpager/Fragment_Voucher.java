package com.example.mrt.testviewpager;

import android.app.Activity;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by Mr.T on 11/12/2017.
 */

public class Fragment_Voucher extends Fragment {
    RecyclerView rl_voucher;
    static Activity activity;
    private int id_City = 0;
    ArrayList<LocationModel> listLocationl;
    CityAdapter cityAdapter;

    public Fragment_Voucher() {
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_voucher, container, false);
        activity = getActivity();
        rl_voucher = v.findViewById(R.id.rl_voucer);
        loadCityAdapter();
        loadDataCity(id_City);
        return v;
    }

    public void loadCityAdapter() {
        listLocationl = new ArrayList<>();
        cityAdapter = new CityAdapter(activity, listLocationl);
        rl_voucher.setAdapter(cityAdapter);
        rl_voucher.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
    }
    public void loadDataCity(int provineId){
            id_City = provineId;
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String url = "http://45.118.151.83:8000/region?parent_id=" + id_City;
        JsonObjectRequest JsonResTown = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listLocationl.clear();
                try {
                    JSONArray jsonArrTown = response.getJSONArray("records");
                    listLocationl.add(new LocationModel(-1, "Toàn quốc", 1));
                    for (int i = 0; i < jsonArrTown.length(); i++) {
                        JSONObject JsonTown = jsonArrTown.getJSONObject(i);
                        listLocationl.add(new LocationModel(
                                JsonTown.getInt("id"),
                                JsonTown.getString("name"),
                                JsonTown.getInt("parent_id")
                        ));
                    }
                    cityAdapter = new CityAdapter(activity, listLocationl);
                    rl_voucher.setAdapter(cityAdapter);
                    cityAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(JsonResTown);
    }
}
