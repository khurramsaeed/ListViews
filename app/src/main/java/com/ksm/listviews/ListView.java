package com.ksm.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    ArrayAdapter<LeaderBoard> adapter;
    ArrayList<LeaderBoard> leaderBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leaderBoard = new ArrayList<>();
        leaderBoard.add(new LeaderBoard("P1", "10"));
        leaderBoard.add(new LeaderBoard("P2", "05"));
        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.activity_main_listView);
        //List view har ingen metoder selv om items, subitems osv.
        //Til dette anvendes en Adapter.
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, leaderBoard);
        adapter = new ArrayAdapter<>(this,R.layout.list_item_rank, R.id.list_item_playerName, leaderBoard);
        listView.setAdapter(adapter);
        // Dette kan også anvendes, hvis man  har statisk data:
        //adapter.addAll("Customer 1");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                LeaderBoard leaderBoard = adapter.getItem(position);
                Toast.makeText(ListView.this, leaderBoard.getPlayerName(), Toast.LENGTH_SHORT).show();
                //Removes item from array and updates ListView
                adapter.remove(leaderBoard);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_main_addItem) {
            leaderBoard.add(new LeaderBoard("Added", "LeaderBoard"));
            // Detects changes in ArrayList
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
