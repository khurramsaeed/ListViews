package com.ksm.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ksm on 11/11/2017.
 */
// Adapters are responsible for creating list item views from data.
public class RankListAdapter extends BaseAdapter {
    private final ArrayList<LeaderBoard> leaderBoards;
    private Context context;
    private final LayoutInflater layoutInflater;

    public RankListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        leaderBoards = new ArrayList<>();
    }

    public void add(LeaderBoard item) {
        leaderBoards.add(item);

        //ListView gets notified of data change and it will therefore also notify its adapter to update listview
        notifyDataSetChanged();
    }

    public void remove(LeaderBoard item) {
        leaderBoards.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return leaderBoards.size();
    }

    @Override
    public LeaderBoard getItem(int position) {
        return leaderBoards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LeaderBoardViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_leaderboard, viewGroup, false);
            viewHolder = new LeaderBoardViewHolder();
            viewHolder.playerName = (TextView) convertView.findViewById(R.id.list_item_playerName);
            viewHolder.playerRank = (TextView) convertView.findViewById(R.id.list_item_playerRank);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (LeaderBoardViewHolder) convertView.getTag();
        }

        LeaderBoard leaderBoard = getItem(position);
        viewHolder.playerName.setText(leaderBoard.getPlayerName());
        viewHolder.playerRank.setText(leaderBoard.getPlayerRank());

        return convertView;
    }

    private class LeaderBoardViewHolder {
        public TextView playerName;
        public TextView playerRank;
    }
}
