package com.example.project_youssef;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Add_Vehicule extends AppCompatActivity {
    private static final int IMAGETOCHOSE = 1;

    ImageView image;
    Button add;
    EditText name;
    EditText desc;
    Drawable drawable;
    Uri imageUri;
    Button importimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);


        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        image = findViewById(R.id.image);

        add = findViewById(R.id.btnAdd);

        importimg = findViewById(R.id.btnimport);

      importimg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent gallery = new Intent();

                    gallery.setType( "image/*");
                     gallery.setAction( Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(gallery,"chose image to upload"),IMAGETOCHOSE);
            }

        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ListVehicule.add(new Vehicule(name.getText().toString(),desc.getText().toString(),drawable));
                MainActivity.myAdapter.notifyDataSetChanged();
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGETOCHOSE  ){
            imageUri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                image.setImageBitmap(bitmap);

                drawable=image.getDrawable();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}

