package com.ksm.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewExpanded extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_expanded);

        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        data.add(new LeaderBoard("Khurram", "1").toHashMap());
        data.add(new LeaderBoard("Alex", "2").toHashMap());
        data.add(new LeaderBoard("Niko", "3").toHashMap());

        // Vigtigt string værdier her skal matche med dem fra Leaderboard java klasse
        String[] hashMapProperties = {"PlayerName", "Rank"};
        int[] textViewIds = {R.id.list_item_playerName, R.id.list_item_playerRank};

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item_leaderboard, hashMapProperties, textViewIds);

        ListView listView = findViewById(R.id.activity_listviewexpanded_listView);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_main_addItem) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
