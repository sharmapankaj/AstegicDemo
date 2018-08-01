package com.example.pankaj.astegicdemo.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ExtensionsData
{
    @Id(autoincrement = true)
    private Long id;
    private String context;
    private int phoneContactId;
    @Generated(hash = 1175388185)
    public ExtensionsData(Long id, String context, int phoneContactId) {
        this.id = id;
        this.context = context;
        this.phoneContactId = phoneContactId;
    }
    @Generated(hash = 2123656688)
    public ExtensionsData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContext() {
        return this.context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public int getPhoneContactId() {
        return this.phoneContactId;
    }
    public void setPhoneContactId(int phoneContactId) {
        this.phoneContactId = phoneContactId;
    }

}
