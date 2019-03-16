package com.example.bottle2;

import java.util.Date;

public class todo_manage {
    
    private int tasksID;
    private String taskHead;
    private String taskContents;
    private Date tasksDate;
    private boolean tasksIsDone;

    public todo_manage(int tasksID, String taskHead, String taskContents, Date tasksDate) {
        this.tasksID = tasksID;
        this.taskHead = taskHead;
        this.taskContents = taskContents;
        this.tasksDate = tasksDate;
        this.tasksIsDone = false;
    }

    public int getTasksID() {
        return tasksID;
    }

    public void setTasksID(int tasksID) {
        this.tasksID = tasksID;
    }

    public String getTaskHead() {
        return taskHead;
    }

    public void setTaskHead(String taskHead) {
        this.taskHead = taskHead;
    }

    public String getTaskContents() {
        return taskContents;
    }

    public void setTaskContents(String taskContents) {
        this.taskContents = taskContents;
    }

    public Date getTasksDate() {
        return tasksDate;
    }

    public void setTasksDate(Date tasksDate) {
        this.tasksDate = tasksDate;
    }

    public boolean isTasksIsDone() {
        return tasksIsDone;
    }

    public void setTasksIsDone(boolean tasksIsDone) {
        this.tasksIsDone = tasksIsDone;
    }
}
