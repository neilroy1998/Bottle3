package com.example.bottle2;

public class alltasks_manage {

    private String alltasksName, allTasksDL, allTasksProject;
    private int alltasksID;

    public alltasks_manage(String alltasksName, String allTasksDL, String allTasksProject, int alltasksID) {
        this.alltasksName = alltasksName;
        this.allTasksDL = allTasksDL;
        this.allTasksProject = allTasksProject;
        this.alltasksID = alltasksID;
    }

    public String getAlltasksName() {
        return alltasksName;
    }

    public void setAlltasksName(String alltasksName) {
        this.alltasksName = alltasksName;
    }

    public String getAllTasksDL() {
        return allTasksDL;
    }

    public void setAllTasksDL(String allTasksDL) {
        this.allTasksDL = allTasksDL;
    }

    public String getAllTasksProject() {
        return allTasksProject;
    }

    public void setAllTasksProject(String allTasksProject) {
        this.allTasksProject = allTasksProject;
    }

    public int getAlltasksID() {
        return alltasksID;
    }

    public void setAlltasksID(int alltasksID) {
        this.alltasksID = alltasksID;
    }
}
