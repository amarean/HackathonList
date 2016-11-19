package com.example.arian.hackathonlist;


/*
The only difference here is we are going to use a our Custom adapter instead of an Array Adapter.
We pass the foods array as part of the constructor.
Note: we don't have an array of images so we use the same one every time,
else we would modify CustomAdapter to accept that array too.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] clubs = {"ACMW", "BUCKEYE", "Dance", "Running", "Tennis", "Compute"};
        // Replace the Array adapter with your custom adapter.
        // ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListAdapter customListAdapter = new CustomAdapter(this,clubs);// Pass the food arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.list);
        customListView.setAdapter(customListAdapter);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String club = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, club, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}