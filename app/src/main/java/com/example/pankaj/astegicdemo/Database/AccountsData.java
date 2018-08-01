package com.example.pankaj.astegicdemo.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AccountsData
{
    @Id(autoincrement = true)
    private Long id;
    private int status;
    private String userID;
    private String context;
    @Generated(hash = 600322446)
    public AccountsData(Long id, int status, String userID, String context) {
        this.id = id;
        this.status = status;
        this.userID = userID;
        this.context = context;
    }
    @Generated(hash = 842116339)
    public AccountsData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getContext() {
        return this.context;
    }
    public void setContext(String context) {
        this.context = context;
    }



}
