package com.example.android.JulianDN_1202154120_Modul3;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/***
 * Main Activity for the Material Me app, a mock sports news application
 */
public class MainActivity extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Item> mItemData;
    private MenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));



        //Initialize the ArrayList that will contain the data
        mItemData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new MenuAdapter(this, mItemData );
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();
    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] aquaList = getResources().getStringArray(R.array.aqua_titles);
        String[] aquaInfo = getResources().getStringArray(R.array.aqua_info);
        TypedArray aquaImageResources = getResources().obtainTypedArray(R.array.aqua_images);
        String[] aquaDetail = getResources().getStringArray(R.array.detail_titles);
        //Clear the existing data (to avoid duplication)
        mItemData.clear();


        //Create the ArrayList of Item objects with the titles, images
        // and information about each sport
        for(int i=0; i<aquaList.length; i++){
            mItemData.add(new Item(aquaList[i], aquaInfo[i],
                    aquaImageResources.getResourceId(i,0),aquaDetail[i]));
        }

        //Recycle the typed array
        aquaImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
