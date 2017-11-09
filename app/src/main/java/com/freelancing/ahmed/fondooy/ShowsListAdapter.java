package com.freelancing.ahmed.fondooy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ahmed on 11/7/2017.
 */

public class ShowsListAdapter  extends RecyclerView.Adapter  {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_show,parent,false);
        return new ShowsListAdapter.ShowsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ShowsListAdapter.ShowsListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return ShowsData.title.length;
    }


private class ShowsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView mItemText;
    private TextView mItemText2;
    private ImageView mItemImage;

    public ShowsListViewHolder(View itemView){
        super(itemView);
        mItemText = (TextView) itemView.findViewById(R.id.itemText2);
        mItemImage = (ImageView) itemView.findViewById(R.id.itemImage2);
        mItemText2 =(TextView) itemView.findViewById(R.id.itemText22);
        itemView.setOnClickListener(this);

    }
    public void bindView (int position){
        mItemText.setText(ShowsData.title[position]);
        mItemText2.setText(ShowsData.con[position]);
        mItemImage.setImageResource(ShowsData.picturePath[position]);
    }

    @Override
    public void onClick(View v) {

    }
}
}
