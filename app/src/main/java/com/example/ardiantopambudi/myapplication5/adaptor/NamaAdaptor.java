package com.example.ardiantopambudi.myapplication5.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ardiantopambudi.myapplication5.R;
import com.example.ardiantopambudi.myapplication5.UserItem;

import java.util.List;

/**
 * Created by ardiantopambudi on 03/04/2018.
 */

public class NamaAdaptor extends RecyclerView.Adapter<NamaAdaptor.Myholder>{
   private List<UserItem> myData;
    public NamaAdaptor(List<UserItem> data) {
        this.myData=data;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =null;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemnama, parent,  false);
        return new Myholder(itemView);
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        holder.nama.setText(myData.get(position).nama);
    }

    @Override
    public int getItemCount() {
     return myData.size();

    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView nama;
        public Myholder(View itemView) {
            super(itemView);
            nama=(TextView)itemView.findViewById(R.id.nama);
        }
    }
}
