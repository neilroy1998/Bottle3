package com.example.bottle2;

public class tasks_for_me_manage {

    private String formetasksName, formeTasksDL, formeTasksProject;
    private int formetasksID;

    public tasks_for_me_manage(String formetasksName, String formeTasksDL, String formeTasksProject, int formetasksID) {
        this.formetasksName = formetasksName;
        this.formeTasksDL = formeTasksDL;
        this.formeTasksProject = formeTasksProject;
        this.formetasksID = formetasksID;
    }

    public String getFormetasksName() {
        return formetasksName;
    }

    public void setFormetasksName(String formetasksName) {
        this.formetasksName = formetasksName;
    }

    public String getFormeTasksDL() {
        return formeTasksDL;
    }

    public void setFormeTasksDL(String formeTasksDL) {
        this.formeTasksDL = formeTasksDL;
    }

    public String getFormeTasksProject() {
        return formeTasksProject;
    }

    public void setFormeTasksProject(String formeTasksProject) {
        this.formeTasksProject = formeTasksProject;
    }

    public int getFormetasksID() {
        return formetasksID;
    }

    public void setFormetasksID(int formetasksID) {
        this.formetasksID = formetasksID;
    }
}
