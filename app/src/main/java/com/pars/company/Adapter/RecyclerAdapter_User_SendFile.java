package com.pars.company.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pars.company.R;


public class RecyclerAdapter_User_SendFile extends RecyclerView.Adapter<RecyclerAdapter_User_SendFile.ViewHolder> {




    private String[] titles =

            {

            "مالیاتی ",
            "حقوقی",
            "رزومه",

            };



    private String[] time =

            {

                    "95/10/5",
                    "93/2/15",
                    "96/5/45",


            };




    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public TextView tv_subject_usersendfile;
        public TextView tv_date_usersendfile;
        public Button enterClass;
        Context mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            tv_subject_usersendfile = (TextView)itemView.findViewById(R.id.tv_subject_usersendfile);
            tv_date_usersendfile = (TextView)itemView.findViewById(R.id.tv_date_usersendfile);
//            enterClass = (Button) itemView.findViewById(R.id.btn_enterClass_onlineClass);




        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_activity_sendfile_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv_subject_usersendfile.setText(titles[i]);
        viewHolder.tv_date_usersendfile.setText(time[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

}