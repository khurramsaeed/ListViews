package com.ksm.listviews;

import java.util.HashMap;

/**
 * Created by Khurram Saeed Malik on 10/11/2017.
 */

public class LeaderBoard {
    private final String playerName;
    private final String playerRank;

    public LeaderBoard(String playerName, String playerRank) {
        this.playerName = playerName;
        this.playerRank = playerRank;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerRank() {
        return playerRank;
    }

    @Override
    public String toString() {
        return getPlayerName() + " " + getPlayerRank();
    }

    public HashMap<String, String> toHashMap() {
        HashMap<String, String> returnValue = new HashMap<>();
        returnValue.put("PlayerName", getPlayerName());
        returnValue.put("Rank", getPlayerRank());
        return returnValue ;
    }
}
