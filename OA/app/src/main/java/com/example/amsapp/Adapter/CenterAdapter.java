package com.example.amsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.amsapp.Models.CenterModel;
import com.example.amsapp.QRInfoActivity;
import com.example.amsapp.QRSurveyActivity;
import com.example.amsapp.R;
import com.example.amsapp.SelectBeforeSurveyActivity;

import java.util.List;

public class CenterAdapter extends RecyclerView.Adapter <CenterAdapter.CenterViewHolder>  {
    private Context mCtx;
    private List<CenterModel> MenuList;
    private String UserID;

    public CenterAdapter(Context mCtx, List<CenterModel> menuList, String userID) {
        this.mCtx = mCtx;
        MenuList = menuList;
        UserID = userID;
    }

    @NonNull
    @Override
    public CenterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mCtx).inflate(R.layout.center_item, viewGroup, false);
        return new CenterViewHolder(v, i);
    }

    @Override
    public void onBindViewHolder(@NonNull CenterViewHolder menuViewHolder, final int i) {

        CenterModel menu = MenuList.get(i);
        menuViewHolder.textViewTitle.setText(menu.getTitle());
        menuViewHolder.textViewDesc.setText(menu.getDesc());
        menuViewHolder.imageView.setImageResource(menu.getImg());
        switch (i) {
            case 0:
                menuViewHolder.layout.setBackgroundColor(Color.parseColor("#BFBFBF"));
                break;
            case 1:
                menuViewHolder.layout.setBackgroundColor(Color.parseColor("#8497B0"));
                break;
        }
        menuViewHolder.layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (i){
                    case 0:
                        OpenQRInfoActivity();
                        break;
                    case 1:
                        OpenSelectBeforeSurveyActivity();
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return MenuList.size();
    }

    class CenterViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewTitle, textViewDesc;
        private RelativeLayout layout;

        public CenterViewHolder(@NonNull View itemView, int i) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgCenterItem);
            textViewTitle = itemView.findViewById(R.id.txtCenterTitle);
            textViewDesc = itemView.findViewById(R.id.txtCenterDesc);
            layout = itemView.findViewById(R.id.itemRec);
        }
    }

    public void OpenSelectBeforeSurveyActivity()
    {
        Intent intent = new Intent(mCtx, SelectBeforeSurveyActivity.class);
        intent.putExtra("UserID", UserID);
        mCtx.startActivity(intent);
    }

    public void OpenQRInfoActivity()
    {
        Intent intent = new Intent(mCtx, QRInfoActivity.class);
        mCtx.startActivity(intent);
    }

}
