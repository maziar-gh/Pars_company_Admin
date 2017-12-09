package com.pars.company.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.pars.company.R;

public class Edit_profile extends AppCompatActivity {


    EditText edt_name, edt_namayanhe, edt_mobile, edt_tel,
            edt_pass, edt_conf_pass, edt_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_edit_profile);


        edt_name = (EditText) findViewById(R.id.txt_name_edit);
        edt_namayanhe = (EditText) findViewById(R.id.txt_namayande_edit);
        edt_mobile = (EditText) findViewById(R.id.txt_tel_edit);
        edt_tel = (EditText) findViewById(R.id.txt_telphon_edit);
        edt_pass = (EditText) findViewById(R.id.txt_password_edit);
        edt_conf_pass = (EditText) findViewById(R.id.txt_comfirm_password_edit);
        edt_address = (EditText) findViewById(R.id.txt_address_edit);



    }
}
