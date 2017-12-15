package com.example.mrt.testviewpager.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrt.testviewpager.Model.LocationModel;
import com.example.mrt.testviewpager.R;

import java.util.ArrayList;

/**
 * Created by Mr.T on 15/12/2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    Activity activity;
    private ArrayList<LocationModel> listCity;

    public CityAdapter(Activity activity, ArrayList<LocationModel> listCity) {
        this.activity = activity;
        this.listCity = listCity;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_merchant_city, parent, false);
        return new CityAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
            final LocationModel location = listCity.get(position);
            holder.txt_City.setText(location.getName());
            holder.txt_City.setTag(position);

    }

    @Override
    public int getItemCount() {
        return listCity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_City;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_City = itemView.findViewById(R.id.txt_city);
        }
    }
}
