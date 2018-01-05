package com.webonise.simtestcasesample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**adapter class to inflate the list
 * Created by webonise on 3/1/18.
 */

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder>{

    private ArrayList<ListDataModel> list;

    public ListDataAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public ListDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View activityView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ListDataViewHolder(activityView);
    }

    @Override
    public void onBindViewHolder(ListDataViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvAddress.setText(list.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        if(this.list!=null) {
        return this.list.size();
        }
        return 0;
    }

    public void setList(ArrayList<ListDataModel> list) {
        this.list.clear();
        this.list.addAll(list);
    }
    public class ListDataViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
        public ListDataViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        }
    }

}


