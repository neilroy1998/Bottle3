package com.example.bottle2;

public class overview_members_manage {

    private int memID, memPrcnt, memImg;
    private String memName, memDesc;

    public overview_members_manage(int memID, int memPrcnt, int memImg, String memName, String memDesc) {
        this.memID = memID;
        this.memPrcnt = memPrcnt;
        this.memImg = memImg;
        this.memName = memName;
        this.memDesc = memDesc;
    }

    public String getMemDesc() {
        return memDesc;
    }

    public void setMemDesc(String memDesc) {
        this.memDesc = memDesc;
    }

    public int getMemID() {
        return memID;
    }

    public void setMemID(int memID) {
        this.memID = memID;
    }

    public int getMemPrcnt() {
        return memPrcnt;
    }

    public void setMemPrcnt(int memPrcnt) {
        this.memPrcnt = memPrcnt;
    }

    public int getMemImg() {
        return memImg;
    }

    public void setMemImg(int memImg) {
        this.memImg = memImg;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }
}
