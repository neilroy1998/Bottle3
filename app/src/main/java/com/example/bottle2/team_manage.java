package com.example.bottle2;

public class team_manage {

    private int memID;
    private String memName;
    private String memPos;
    private String memPrcnt;
    private int memImg;

    public team_manage(int memID, String memName, String memPos, String memPrcnt, int memImg) {
        this.memID = memID;
        this.memName = memName;
        this.memPos = memPos;
        this.memPrcnt = memPrcnt;
        this.memImg = memImg;
    }

    public int getMemID() {
        return memID;
    }

    public void setMemID(int memID) {
        this.memID = memID;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemPos() {
        return memPos;
    }

    public void setMemPos(String memPos) {
        this.memPos = memPos;
    }

    public String getMemPrcnt() {
        return memPrcnt;
    }

    public void setMemPrcnt(String memPrcnt) {
        this.memPrcnt = memPrcnt;
    }

    public int getMemImg() {
        return memImg;
    }

    public void setMemImg(int memImg) {
        this.memImg = memImg;
    }
}
