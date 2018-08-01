package com.example.pankaj.astegicdemo.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ContactsData
{
    @Id(autoincrement = true)
    private Long id;
    private int contacts_id;
    private String contactId;
    private String stagingId;
    @Generated(hash = 161528324)
    public ContactsData(Long id, int contacts_id, String contactId,
            String stagingId) {
        this.id = id;
        this.contacts_id = contacts_id;
        this.contactId = contactId;
        this.stagingId = stagingId;
    }
    @Generated(hash = 500888781)
    public ContactsData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getContacts_id() {
        return this.contacts_id;
    }
    public void setContacts_id(int contacts_id) {
        this.contacts_id = contacts_id;
    }
    public String getContactId() {
        return this.contactId;
    }
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
    public String getStagingId() {
        return this.stagingId;
    }
    public void setStagingId(String stagingId) {
        this.stagingId = stagingId;
    }
    

}
