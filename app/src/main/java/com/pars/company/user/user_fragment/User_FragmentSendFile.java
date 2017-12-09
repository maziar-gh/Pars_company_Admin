package com.pars.company.user.user_fragment;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;
import com.pars.company.NextActivityFile;
import com.pars.company.R;

import java.io.File;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class User_FragmentSendFile extends Fragment {

    private Context contInst;
    private View view;
    private LinearLayoutManager mLayoutManager;

    ImageView imgFileSendfile ,imgGallerySendfile , imgCameraSendfile , viewImage;
    Button btnNextSendFile;
    Bitmap bitMap;
    static int TAKE_PICTURE = 1;

    private FilePickerDialog dialog;



    private FragmentActivity myContext;


    public static User_FragmentSendFile newInstance() {

        Bundle args = new Bundle();
        User_FragmentSendFile fragment = new User_FragmentSendFile();
        fragment.setArguments(args);
        return fragment;
    }






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_fragment_sendfile, container, false);
        contInst = getActivity();
        //java code




        imgFileSendfile = (ImageView)view.findViewById(R.id.img_file_sendfile);
        imgGallerySendfile = (ImageView)view.findViewById(R.id.img_gallrty_sendfile);
        imgCameraSendfile = (ImageView)view.findViewById(R.id.img_camera_sendfile);
        viewImage = (ImageView)view.findViewById(R.id.viewImage);
        btnNextSendFile = (Button) view.findViewById(R.id.btn_next_sendFile);

        btnNextSendFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NextActivityFile.class);
                startActivity(intent);
            }
        });



        //Create a DialogProperties object.
        final DialogProperties properties=new DialogProperties();

        dialog=new FilePickerDialog(contInst,properties);
        dialog.setTitle("Select a File");
        dialog.setPositiveBtnName("Select");
        dialog.setNegativeBtnName("Cancel");
        //Setting selection mode to multiple selection.
        properties.selection_mode = DialogConfigs.MULTI_MODE;
        //properties.selection_mode = DialogConfigs.SINGLE_MODE;
        //Setting selection type to files and directories.
        properties.selection_type=DialogConfigs.FILE_AND_DIR_SELECT;
        properties.error_dir=new File("/mnt");
        //Set new properties of dialog.
        dialog.setProperties(properties);

//                Pre marking of files in Dialog
//                ArrayList<String> paths=new ArrayList<>();
//                paths.add("/mnt/sdcard/.VOD");
//                paths.add("/mnt/sdcard/.VOD/100.jpg");
//                paths.add("/mnt/sdcard/.VOD/1000.jpg");
//                paths.add("/mnt/sdcard/.VOD/1010.jpg");
//                paths.add("/mnt/sdcard/.VOD/1020.jpg");
//                paths.add("/mnt/sdcard/.VOD/1070.jpg");
//                dialog.markFiles(paths);


        imgFileSendfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

            }
        });


        imgCameraSendfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create intent with ACTION_IMAGE_CAPTURE action
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // start camera activity
                startActivityForResult(intent, TAKE_PICTURE);
            }
        });

        imgGallerySendfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new   Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, 2);
            }
        });



        ///java code
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == TAKE_PICTURE && resultCode== RESULT_OK && intent != null){
            // get bundle
            Bundle extras = intent.getExtras();

            // get bitmap
            bitMap = (Bitmap) extras.get("data");
            viewImage.setImageBitmap(bitMap);

        }
    }

    // method to check if you have a Camera
    private boolean hasCamera(){
        return getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    // method to check you have Camera Apps
    private boolean hasDefualtCameraApp(String action){
        final PackageManager packageManager = getActivity().getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        return list.size() > 0;

    }



}

