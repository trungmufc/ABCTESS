package com.example.mrt.testviewpager.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrt.testviewpager.Model.MerchantModel;
import com.example.mrt.testviewpager.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mr.T on 13/12/2017.
 */

public class MerchantAdapter extends RecyclerView.Adapter<MerchantAdapter.ViewHolder> {
    private ArrayList<MerchantModel> listmerchant;
    private Activity activity;

    public MerchantAdapter(ArrayList<MerchantModel> listmerchant, Activity activity) {
        this.listmerchant = listmerchant;
        this.activity = activity;
    }

    @Override
    public MerchantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_merchant, parent, false);
        return new MerchantAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MerchantAdapter.ViewHolder holder, int position) {
        MerchantModel merchantModel = listmerchant.get(position);
        String url = merchantModel.getImage_medium();
        Picasso.with(activity).load(url).into(holder.imgMerchant);
        holder.txtNameMerchant.setText(merchantModel.getName());
        holder.txtNumberMerchant.setText("#" + merchantModel.getDiscount_rate() + "%");
        holder.txtTonghoadon.setText("#" + merchantModel.getInfo_condition());


    }

    @Override
    public int getItemCount() {
        return listmerchant.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMerchant;
        TextView txtNameMerchant;
        TextView txtTonghoadon;
        TextView txtNumberMerchant;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMerchant = itemView.findViewById(R.id.img_merchant);
            txtNameMerchant = itemView.findViewById(R.id.txt_name_merchant);
            txtTonghoadon = itemView.findViewById(R.id.txt_tonghoadon);
            txtNumberMerchant = itemView.findViewById(R.id.txt_number_merchant);

            Display display = activity.getWindowManager().getDefaultDisplay();
            int height = (display.getWidth() * 9) / 16;
            imgMerchant.getLayoutParams().height = height;
        }
    }
}
