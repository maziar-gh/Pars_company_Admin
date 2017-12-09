package com.pars.company.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pars.company.Adapter.RecyclerAdapter_User_Receive;
import com.pars.company.R;

public class User_receive extends AppCompatActivity {


    RecyclerView recyclerview_receive_user;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_receive);


        recyclerview_receive_user =(RecyclerView)findViewById(R.id.recyclerview_receive_user);

        //for class name create
        layoutManager = new LinearLayoutManager(this);
        recyclerview_receive_user.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter_User_Receive();
        recyclerview_receive_user.setAdapter(adapter);
    }
}
