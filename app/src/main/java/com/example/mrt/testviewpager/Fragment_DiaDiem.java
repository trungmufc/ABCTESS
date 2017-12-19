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
import com.example.mrt.testviewpager.Adapter.DistrictAdapter;
import com.example.mrt.testviewpager.Model.LocationModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mr.T on 11/12/2017.
 */

public class Fragment_DiaDiem extends Fragment {
    RecyclerView rl_district;
    static Activity activity;
    private static int id_City = -1;
    private static int id_District = -1;
    static ArrayList<LocationModel> listLocationl;
    static DistrictAdapter districtAdapter;

    public Fragment_DiaDiem() {
    }

    public  static void loadData() {
      loadDataCity(MainActivity.idPlace);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_diadiem, container, false);
        rl_district = v.findViewById(R.id.rl_district);
        activity = getActivity();
        loadDistrictAdapter();
        return v;
    }

  /*  @Override
    public void onResume() {
        super.onResume();
        loadDataCity(id_City);

    }*/

    public void loadDistrictAdapter() {
        listLocationl = new ArrayList<>();
        districtAdapter = new DistrictAdapter(activity, listLocationl);
        rl_district.setAdapter(districtAdapter);
        rl_district.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
    }
    public static void loadDataCity(int Id_District ) {
         MainActivity.idPlace = Id_District;

        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String Url = "http://45.118.151.83:8000/region?parent_id=" + MainActivity.idPlace ;

        JsonObjectRequest JsonResTown = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listLocationl.clear();
                try {
                    JSONArray jsonArrTown = response.getJSONArray("records");
                    for (int i = 0; i < jsonArrTown.length(); i++) {
                        JSONObject JsonTown = jsonArrTown.getJSONObject(i);
                        listLocationl.add(new LocationModel(
                                JsonTown.getInt("id"),
                                JsonTown.getString("name"),
                                JsonTown.getInt("parent_id")
                        ));
                    }
                    districtAdapter.notifyDataSetChanged();
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
