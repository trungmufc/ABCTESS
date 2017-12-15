package com.example.mrt.testviewpager.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mrt.testviewpager.Model.LocationModel;
import com.example.mrt.testviewpager.R;

import java.util.ArrayList;

/**
 * Created by Mr.T on 15/12/2017.
 */

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.ViewHolder> {
    Activity activity;
    ArrayList<LocationModel> listLocation;

    public DistrictAdapter(Activity activity, ArrayList<LocationModel> listLocation) {
        this.activity = activity;
        this.listLocation = listLocation;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_merchant_district, parent, false);
        return new DistrictAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listLocation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llDistrict;
        private ImageView imgDistrict;
        private TextView txtDistrict;

        public ViewHolder(View itemView) {
            super(itemView);
            llDistrict = itemView.findViewById(R.id.ll_district);
            imgDistrict = itemView.findViewById(R.id.img_district);
            txtDistrict = itemView.findViewById(R.id.txt_district);

        }
    }
}
