package com.example.ardiantopambudi.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ardiantopambudi.myapplication5.adaptor.NamaAdaptor;

import retrofit2.Call;
import retrofit2.Callback;

public class Main2Activity extends AppCompatActivity {
private RecyclerView recycleListView;
    private NamaAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recycleListView =(RecyclerView)findViewById(R.id.recyclerview);
        ApiInterface apiInterface=ApiCall.getClient().create(ApiInterface.class);
        Call<Response> responseCall=apiInterface.ambilData();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().user.size()>0){
                   adaptor=new NamaAdaptor(response.body().user);
                    RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(Main2Activity.this);
                    recycleListView.setLayoutManager(mLayoutManager);
                    recycleListView.setItemAnimator(new DefaultItemAnimator());
                    //setadapter
                    recycleListView.setAdapter(adaptor);


                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("yayan", "onaFailure: "+t.getMessage());
            }
        });
    }
    }

