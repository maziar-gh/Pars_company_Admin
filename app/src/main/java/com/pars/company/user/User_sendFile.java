package com.pars.company.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pars.company.R;
import com.pars.company.Adapter.RecyclerAdapter_User_SendFile;

public class User_sendFile extends AppCompatActivity {


    RecyclerView recyclerview_sendfile_user;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_send_file);


        recyclerview_sendfile_user =(RecyclerView)findViewById(R.id.recyclerview_sendfile_user);

        //for class name create
        layoutManager = new LinearLayoutManager(this);
        recyclerview_sendfile_user.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter_User_SendFile();
        recyclerview_sendfile_user.setAdapter(adapter);
    }
}
