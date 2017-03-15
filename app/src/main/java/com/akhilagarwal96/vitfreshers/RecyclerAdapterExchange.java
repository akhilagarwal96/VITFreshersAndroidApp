package com.akhilagarwal96.vitfreshers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapterExchange extends RecyclerView.Adapter<RecyclerAdapterExchange.RecyclerViewHolder> {

    private ArrayList<DataProviderExchange> arrayList = new ArrayList<DataProviderExchange>();

    public RecyclerAdapterExchange(ArrayList<DataProviderExchange> arrayList) {

        this.arrayList = arrayList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resale_cards,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        DataProviderExchange dataProviderExchange = arrayList.get(position);
        holder.name_ex.setText(dataProviderExchange.getT_name());
        holder.room_ex.setText(dataProviderExchange.getT_room());
        holder.phone_ex.setText(dataProviderExchange.getT_phone());
        holder.desc_ex.setText(dataProviderExchange.getT_desc());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView name_ex,room_ex,phone_ex,desc_ex;

        public RecyclerViewHolder(View view){
            super(view);

            name_ex = (TextView) view.findViewById(R.id.name_ex);
            room_ex = (TextView) view.findViewById(R.id.room_ex);
            phone_ex = (TextView) view.findViewById(R.id.phone_ex);
            desc_ex = (TextView) view.findViewById(R.id.product_ex);

        }

    }
}
