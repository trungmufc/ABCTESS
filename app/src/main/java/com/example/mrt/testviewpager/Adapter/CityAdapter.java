package com.example.mrt.testviewpager.Adapter;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrt.testviewpager.Fragment_DiaDiem;
import com.example.mrt.testviewpager.Fragment_Voucher;
import com.example.mrt.testviewpager.MainActivity;
import com.example.mrt.testviewpager.Model.LocationModel;
import com.example.mrt.testviewpager.PagerAdapter;
import com.example.mrt.testviewpager.R;

import java.util.ArrayList;

/**
 * Created by Mr.T on 15/12/2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    static MainActivity mainActivity;
    Activity activity;
    private ArrayList<LocationModel> listCity;
    Fragment_DiaDiem fragment_diaDiem = new Fragment_DiaDiem();
    Fragment_Voucher fragment_voucher;
    PagerAdapter pagerAdapter;

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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, location.getId() + "", Toast.LENGTH_SHORT).show();
                mainActivity.setIndexPager();

            }
        });

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
