package com.example.project_youssef;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.ArrayList;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE1 = 1;
     ListView simpleList;
    static ArrayList<Vehicule> ListVehicule=new ArrayList<>();
    static MyAdapter myAdapter;
    Drawable d;
    Button add;
    Button delete;
    static ArrayList<Vehicule> VehiculesToDelete = new ArrayList<>();
    private int[] be_selected_item ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleGridView);


        Drawable img1 = getResources().getDrawable(R.drawable.honda);
        Drawable img2 = getResources().getDrawable(R.drawable.kia);
        Drawable img3 = getResources().getDrawable(R.drawable.maruti);
        Drawable img4 = getResources().getDrawable(R.drawable.tata);


        ListVehicule.add(new Vehicule("Honda","this is a description", img1));
        ListVehicule.add(new Vehicule("Kia Seltos","this is a description", img2));
        ListVehicule.add(new Vehicule("Maruti","this is a description", img3));
        ListVehicule.add(new Vehicule("Tata nixon","this is a description", img4));
        be_selected_item = new int[ListVehicule.size()];
        delete=(Button) findViewById(R.id.btn_delete);
        add=(Button) findViewById(R.id.btn_add);


       myAdapter=new MyAdapter(this,R.layout.grid_view_items,ListVehicule);
        simpleList.setAdapter(myAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Vehicule vtd;
                vtd=ListVehicule.get(i);



                be_selected_item[i]++;
                if(be_selected_item[i] % 2==0 ) {
                    simpleList.getChildAt(i).setBackgroundColor(Color.WHITE);
                    if ( VehiculesToDelete.contains(vtd)){
                        VehiculesToDelete.remove(vtd);

                    }

                }
                else {
                    simpleList.getChildAt(i).setBackgroundColor(Color.parseColor("#E91E63"));
                    if ( !VehiculesToDelete.contains(vtd)){
                        VehiculesToDelete.add(vtd);

                    }


                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Add_Vehicule.class);
                startActivity(i);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    new AlertDialog.Builder(MainActivity.this).setMessage("do you want to delete these items").setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                        @Override

                                public void onClick(DialogInterface dialog, int which) {
                                    for ( int k =0;k< VehiculesToDelete.size()  ; k++ ){
                                        Vehicule item=VehiculesToDelete.get(k);
                                        ListVehicule.remove(item);


/*
                                        if ( VehiculesToDelete.contains(ListVehicule.get(k))){
                                            ListVehicule.remove(k);
                                        }
                                        */

                                    }
                                            VehiculesToDelete.clear();

                                            myAdapter.notifyDataSetChanged();


                                }
                            }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    VehiculesToDelete.clear();
                                }
                            }).show();
                }

        });

    }
     /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_done) {
            String ItemSelected = "selected  items: \n";
            for (int i = 0; i < simpleList.getCount(); i++) {
                if (simpleList.isItemChecked(i)) {
                    ItemSelected += "hhh"+ "\n";
                }
            }
            Toast.makeText(this, ItemSelected, Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

       private OnItemClickListener selectLesson = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
            Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
            Intent.putExtra("Bitmap", bitmap);
            startActivity(intent);;
            intent.putExtra("id",i);
            startActivityForResult(intent, REQUEST_CODE1);
/*
            Intent intent = new  Intent(getBaseContext(), SecondActivity.c lass);
            intent.putExtra("AnimalName", animalList.get(i).getAnimalName());
            intent.putExtra("AnimalImage",R.drawable.lion);





        }
    };
   **/
/*
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE1) {
            if(resultCode==RESULT_OK) {
                int id= data.getIntExtra("id",-1);
                Vehicule v=ListVehicule.get(id);
                ListVehicule.remove(v);
                myAdapter=new MyAdapter(this,R.layout.grid_view_items,ListVehicule);
                simpleList.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
*/
}


