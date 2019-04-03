package com.example.bottle2;

public class profile_tasks_manage {
    private String persontasksName, personTasksDL, personTasksProject;
    private int persontasksID;

    public profile_tasks_manage(String persontasksName, String personTasksDL, String personTasksProject, int persontasksID) {
        this.persontasksName = persontasksName;
        this.personTasksDL = personTasksDL;
        this.personTasksProject = personTasksProject;
        this.persontasksID = persontasksID;
    }

    public String getpersontasksName() {
        return persontasksName;
    }

    public void setpersontasksName(String persontasksName) {
        this.persontasksName = persontasksName;
    }

    public String getpersonTasksDL() {
        return personTasksDL;
    }

    public void setpersonTasksDL(String personTasksDL) {
        this.personTasksDL = personTasksDL;
    }

    public String getpersonTasksProject() {
        return personTasksProject;
    }

    public void setpersonTasksProject(String personTasksProject) {
        this.personTasksProject = personTasksProject;
    }

    public int getpersontasksID() {
        return persontasksID;
    }

    public void setpersontasksID(int persontasksID) {
        this.persontasksID = persontasksID;
    }
}
