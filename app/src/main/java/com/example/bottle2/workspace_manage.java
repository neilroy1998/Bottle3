package com.example.bottle2;

public class workspace_manage {

    int workspace_id;
    String workspace_name;

    public workspace_manage(int workspace_id, String workspace_name) {
        this.workspace_id = workspace_id;
        this.workspace_name = workspace_name;
    }

    public int getWorkspace_id() {
        return workspace_id;
    }

    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    public String getWorkspace_name() {
        return workspace_name;
    }

    public void setWorkspace_name(String workspace_name) {
        this.workspace_name = workspace_name;
    }
}
