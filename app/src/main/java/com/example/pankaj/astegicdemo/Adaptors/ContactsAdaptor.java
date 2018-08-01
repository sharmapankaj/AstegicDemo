package com.example.pankaj.astegicdemo.Adaptors;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pankaj.astegicdemo.Model.ContactsItemData;
import com.example.pankaj.astegicdemo.R;

import java.util.List;

public class ContactsAdaptor extends ArrayAdapter<ContactsItemData>
{
    private int contactid;
    private List<ContactsItemData> list;
    private LayoutInflater inflater;

    public ContactsAdaptor(Activity context, int contactid, int id, List<ContactsItemData>
            list) {
        super(context, id, list);
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.contactid = contactid;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(contactid, parent, false);
        TextView textView = itemView.findViewById(R.id.tv_spinner);
        textView.setText(list.get(position).getContactId());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent) {
        return getView(position, convertView, parent);

    }
}
