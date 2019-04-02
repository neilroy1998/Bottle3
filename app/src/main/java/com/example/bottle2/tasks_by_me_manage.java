package com.example.bottle2;

public class tasks_by_me_manage {

    private String bymetasksName, bymeTasksDL, bymeTasksProject, bymeTasksTo;
    private int bymetasksID;

    public tasks_by_me_manage(String bymetasksName, String bymeTasksDL, String bymeTasksProject, String bymeTasksTo, int bymetasksID) {
        this.bymetasksName = bymetasksName;
        this.bymeTasksDL = bymeTasksDL;
        this.bymeTasksProject = bymeTasksProject;
        this.bymeTasksTo = bymeTasksTo;
        this.bymetasksID = bymetasksID;
    }

    public String getBymetasksName() {
        return bymetasksName;
    }

    public void setBymetasksName(String bymetasksName) {
        this.bymetasksName = bymetasksName;
    }

    public String getBymeTasksDL() {
        return bymeTasksDL;
    }

    public void setBymeTasksDL(String bymeTasksDL) {
        this.bymeTasksDL = bymeTasksDL;
    }

    public String getBymeTasksProject() {
        return bymeTasksProject;
    }

    public void setBymeTasksProject(String bymeTasksProject) {
        this.bymeTasksProject = bymeTasksProject;
    }

    public String getBymeTasksTo() {
        return bymeTasksTo;
    }

    public void setBymeTasksTo(String bymeTasksTo) {
        this.bymeTasksTo = bymeTasksTo;
    }

    public int getBymetasksID() {
        return bymetasksID;
    }

    public void setBymetasksID(int bymetasksID) {
        this.bymetasksID = bymetasksID;
    }
}
