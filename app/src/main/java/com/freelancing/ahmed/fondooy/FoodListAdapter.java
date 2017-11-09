package com.freelancing.ahmed.fondooy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ahmed on 11/6/2017.
 */

public class FoodListAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_food,parent,false);
            return new FoodListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FoodListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return FoodData.title.length;
    }

    private class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mItemText;
        private TextView mItemText2;
        private ImageView mItemImage;

        public FoodListViewHolder(View itemView){
            super(itemView);
            mItemText = (TextView) itemView.findViewById(R.id.itemText);
            mItemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            mItemText2 =(TextView) itemView.findViewById(R.id.itemText2);
            itemView.setOnClickListener(this);

        }
        public void bindView (int position){
            mItemText.setText(FoodData.title[position]);
            mItemText2.setText(FoodData.con[position]);
            mItemImage.setImageResource(FoodData.picturePath[position]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
