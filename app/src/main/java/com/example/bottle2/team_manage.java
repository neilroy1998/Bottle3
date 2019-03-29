package com.example.bottle2;

public class team_manage {

    private int teamID;
    private String teamName;
    private String teamDesc;

    public team_manage(int teamID, String teamName, String teamDesc) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.teamDesc = teamDesc;
    }

    public int getteamID() {
        return teamID;
    }

    public void setteamID(int teamID) {
        this.teamID = teamID;
    }

    public String getteamName() {
        return teamName;
    }

    public void setteamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc;
    }
}
