package com.ksm.listviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.ListView;
import java.util.List;

/**
 * Created by ksm on 11/11/2017.
 */

public class ListViewExpandedCustomAdapter extends AppCompatActivity {
    private RankListAdapter adapter;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_list_view_expanded_customadapter);

        ListView listView = (ListView) findViewById(R.id.activity_listviewexpanded_customerAdapter_listView);

        adapter = new RankListAdapter(this);
        adapter.add(new LeaderBoard("John Doe", "10"));
        adapter.add(new LeaderBoard("John Doe", "11"));
        adapter.add(new LeaderBoard("John Doe", "12"));
        adapter.add(new LeaderBoard("John Doe", "13"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                adapter.remove(adapter.getItem(position));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_main_addItem) {
            adapter.add(new LeaderBoard("added Player", "Ranked player"));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
