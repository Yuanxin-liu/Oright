package com.example.oright.bean;

public class Favourite2 {
    private int fid;
    private int firm_id;
    private int pid;
    private String username;
    private String password;
    private String content;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(int firm_id) {
        this.firm_id = firm_id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Favourite2{" +
                "fid=" + fid +
                ", firm_id=" + firm_id +
                ", pid=" + pid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
