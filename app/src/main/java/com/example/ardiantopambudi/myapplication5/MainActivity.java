package com.example.ardiantopambudi.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textData);
        getData();
    }

    private void getData(){
        ApiInterface apiInterface=ApiCall.getClient().create(ApiInterface.class);
        Call<Response> responseCall=apiInterface.ambilData();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().user.size()>0){
                    for (int i = 0; i < response.body().user.size(); i++){
                        textView.setText(textView.getText().toString()+"\n"+response.body().user.get(i).nama);
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("yayan", "onaFailure: "+t.getMessage());
            }
        });
    }
}
