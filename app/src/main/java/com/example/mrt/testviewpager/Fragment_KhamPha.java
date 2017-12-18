package com.example.mrt.testviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mrt.testviewpager.Adapter.MerchantAdapter;
import com.example.mrt.testviewpager.Model.MerchantModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mr.T on 11/12/2017.
 */

public class Fragment_KhamPha extends Fragment {
    static Activity activity;
    private String SORT = "id%20desc";
    RecyclerView rl_khampha;
    MerchantAdapter merchantAdapter;
    ArrayList<MerchantModel> listmerchant;
    private String CATEGORY_ID = "category_id=";
    private String CITY_ID = "city_id=";
    private String DISTRICT_ID = "district_id=";
    private static int idPage = 1;
    int category = -1;
    int city_id = -1;
    int district_id = -1;
    boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    LinearLayoutManager mLayoutManager;

    public Fragment_KhamPha() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_khampha, container, false);
        activity = getActivity();
        rl_khampha = v.findViewById(R.id.rl_khampha);
        loadAdapter();
        loadDataMerchant();
        scroll();
        return v;
    }

    public void scroll() {
        mLayoutManager = new LinearLayoutManager(activity);
        rl_khampha.setLayoutManager(mLayoutManager);
        merchantAdapter = new MerchantAdapter(listmerchant, activity);
        rl_khampha.setAdapter(merchantAdapter);
        rl_khampha.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
                if (loading) {
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        Toast.makeText(getActivity(), "aaaaa", Toast.LENGTH_SHORT).show();
                        loading = false;
                        loadDataMerchant();

                    }
                }
            }
        });
    }

    public void loadAdapter() {
        listmerchant = new ArrayList<>();
        merchantAdapter = new MerchantAdapter(listmerchant, activity);
        rl_khampha.setAdapter(merchantAdapter);
        rl_khampha.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));

    }

    public void loadDataMerchant() {
        //SORT = merchant;
        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = "http://45.118.151.83:8000/merchant?"
                + "page=" + idPage
                + "&" + "order=" + SORT;
        Log.d("mylog", url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("records");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        MerchantModel merchant = new MerchantModel();
                        JSONObject res = (JSONObject) jsonArray.get(i);

                        merchant.setName((String) res.get("name"));
                        merchant.setInfo_condition((String) res.get("info_condition"));
                        int a = (int) res.get("discount_rate");
                        merchant.setDiscount_rate(String.valueOf(a));

                        JSONArray jsonImage = (JSONArray) res.get("image_list");
                        for (int j = 0; j < jsonImage.length(); j++) {
                            JSONObject js = (JSONObject) jsonImage.get(j);
                            merchant.setImage_medium((String) js.get("image_medium"));
                        }
                        listmerchant.add(merchant);
                    }

                    if (jsonArray.length() > 0) {
                        idPage++;
                    }
                    merchantAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(stringRequest);
    }
}
