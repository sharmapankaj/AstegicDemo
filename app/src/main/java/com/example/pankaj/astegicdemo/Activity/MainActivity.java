package com.example.pankaj.astegicdemo.Activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pankaj.astegicdemo.Adaptors.ContactsAdaptor;
import com.example.pankaj.astegicdemo.AstegicDemoApp;
import com.example.pankaj.astegicdemo.Database.AccountsData;
import com.example.pankaj.astegicdemo.Database.AccountsDataDao;
import com.example.pankaj.astegicdemo.Database.ContactsData;
import com.example.pankaj.astegicdemo.Database.ContactsDataDao;
import com.example.pankaj.astegicdemo.Database.ExtensionsData;
import com.example.pankaj.astegicdemo.Database.ExtensionsDataDao;
import com.example.pankaj.astegicdemo.Model.ContactsItemData;
import com.example.pankaj.astegicdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactsDataDao contactsDataDao;
    private AccountsDataDao accountsDataDao;
    private ExtensionsDataDao extensionsDataDao;
    private Spinner sp_Contact;
    private TextView tv_Staging,tv_context,tv_status,tv_userId;
    private ContactsItemData contactsItemData;
    private List<ContactsItemData> contactsItemDataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsItemData=new ContactsItemData();
        findAllIds();
        inserDataIntoTable();
        fillSpinner();
        setListeners();
    }
    private void findAllIds()
    {
        sp_Contact=(Spinner)findViewById(R.id.sp_Contact);
        tv_Staging=(TextView)findViewById(R.id.tv_Staging);
        tv_context=(TextView)findViewById(R.id.tv_context);
        tv_status=(TextView)findViewById(R.id.tv_status);
        tv_userId=(TextView)findViewById(R.id.tv_userId);
    }
    private void inserDataIntoTable()
    {
        contactsDataDao = AstegicDemoApp.getInstance().getDaoSession().getContactsDataDao();
        accountsDataDao = AstegicDemoApp.getInstance().getDaoSession().getAccountsDataDao();
        extensionsDataDao = AstegicDemoApp.getInstance().getDaoSession().getExtensionsDataDao();

        String contactQuery = "Select count(*) From " + ContactsDataDao.TABLENAME ;
        Cursor cursorContact = AstegicDemoApp.getInstance().getDaoSession().getDatabase().rawQuery(contactQuery, null);
        if (cursorContact != null && cursorContact.moveToFirst() && cursorContact.getCount() > 0)
        {
            int count=cursorContact.getInt(0);
            if(count==0)
            {
                /*insert data--*/

                /*2, 48f3, 1196
                3, 3e47, f1fe
                4, 2cac, 036e*/

                ContactsData contactsData=new ContactsData();
                contactsData.setContacts_id(2);
                contactsData.setContactId("48f3");
                contactsData.setStagingId("1196");
                contactsDataDao.insert(contactsData);

                ContactsData contactsData1=new ContactsData();
                contactsData1.setContacts_id(3);
                contactsData1.setContactId("3e47");
                contactsData1.setStagingId("f1fe");
                contactsDataDao.insert(contactsData1);

                ContactsData contactsData2=new ContactsData();
                contactsData2.setContacts_id(4);
                contactsData2.setContactId("48f3");
                contactsData2.setStagingId("036e");
                contactsDataDao.insert(contactsData2);
            }
        }

        String accountQuery = "Select count(*) From " + AccountsDataDao.TABLENAME ;
        Cursor accountContact = AstegicDemoApp.getInstance().getDaoSession().getDatabase().rawQuery(accountQuery, null);
        if (accountContact != null && accountContact.moveToFirst() && accountContact.getCount() > 0)
        {
            int count=accountContact.getInt(0);
            if(count==0)
            {
                /*insert data--*/
                /*
                status, userID, context
                1, test_one@gmail.com, Gmail
                0, test_two@gmail.com, Gmail1
                */
                AccountsData accountsData=new AccountsData();
                accountsData.setStatus(1);
                accountsData.setUserID("test_one@gmail.com");
                accountsData.setContext("Gmail");
                accountsDataDao.insert(accountsData);

                AccountsData accountsData1=new AccountsData();
                accountsData1.setStatus(0);
                accountsData1.setUserID("test_two@gmail.com");
                accountsData1.setContext("Gmail1");
                accountsDataDao.insert(accountsData1);
            }
        }

        String extensionQuery = "Select count(*) From " + ExtensionsDataDao.TABLENAME ;
        Cursor extensionContact = AstegicDemoApp.getInstance().getDaoSession().getDatabase().rawQuery(extensionQuery, null);
        if (extensionContact != null && extensionContact.moveToFirst() && extensionContact.getCount() > 0)
        {
            int count=extensionContact.getInt(0);
            if(count==0)
            {
                /*insert data--*/
                /*context, phoneContactId
                Gmail, 2
                Gmail, 3
                Gmail1,4*/

                ExtensionsData extensionsData=new ExtensionsData();
                extensionsData.setContext("Gmail");
                extensionsData.setPhoneContactId(2);
                extensionsDataDao.insert(extensionsData);

                ExtensionsData extensionsData1=new ExtensionsData();
                extensionsData1.setContext("Gmail");
                extensionsData1.setPhoneContactId(3);
                extensionsDataDao.insert(extensionsData1);

                ExtensionsData extensionsData2=new ExtensionsData();
                extensionsData2.setContext("Gmail1");
                extensionsData2.setPhoneContactId(4);
                extensionsDataDao.insert(extensionsData2);
            }
        }
    }
    private void fillSpinner()
    {
        String contactQuery = "Select * From " + ContactsDataDao.TABLENAME ;
        Cursor cursorContact = AstegicDemoApp.getInstance().getDaoSession().getDatabase().rawQuery(contactQuery, null);
        if (cursorContact != null && cursorContact.moveToFirst() && cursorContact.getCount() > 0)
        {
            for(int i=1;i<=cursorContact.getCount();i++)
            {
                int contactsID= cursorContact.getInt(cursorContact.getColumnIndex(ContactsDataDao.Properties.Contacts_id.columnName));
                String contactID= cursorContact.getString(cursorContact.getColumnIndex(ContactsDataDao.Properties.ContactId.columnName));
                String stagingID= cursorContact.getString(cursorContact.getColumnIndex(ContactsDataDao.Properties.StagingId.columnName));

                ContactsItemData contactsItemData=new ContactsItemData();
                contactsItemData.setContacts_id(contactsID);
                contactsItemData.setContactId(contactID);
                contactsItemData.setStagingId(stagingID);

                contactsItemDataList.add(contactsItemData);
                cursorContact.moveToNext();
            }
            ContactsAdaptor adapter = new ContactsAdaptor(MainActivity.this, R.layout.row_spinner, R.id.tv_Staging, contactsItemDataList);
            adapter.setDropDownViewResource(R.layout.row_spinner);
            sp_Contact.setAdapter(adapter);
        }
    }
    private void setListeners()
    {
        sp_Contact.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int contacts_id = contactsItemDataList.get(position).getContacts_id();
                displayData(contacts_id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }
    private void displayData(int contactsId)
    {
       // String a="Select * from "+

        String query="select c.[STAGING_ID],e.[CONTEXT],a.[STATUS],a.[USER_ID] " +
                " from CONTACTS_DATA c"+
                " left join EXTENSIONS_DATA e on c.[CONTACTS_ID]="+"e.[PHONE_CONTACT_ID]"+
                " left join ACCOUNTS_DATA a on e.[CONTEXT]="+"a.[CONTEXT]" +
                " where c.[CONTACTS_ID]="+contactsId;
        Cursor cursor= AstegicDemoApp.getInstance().getDaoSession().getDatabase().rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0)
        {
            String stagingID=cursor.getString(0);
            String context=cursor.getString(1);
            int status=cursor.getInt(2);
            String userID=cursor.getString(3);

            tv_Staging.setText(String.valueOf(stagingID));
            tv_status.setText(String.valueOf(status));
            tv_userId.setText(userID);
            tv_context.setText(context);
        }
    }

}
