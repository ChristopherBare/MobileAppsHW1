package com.example.homework_1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayContacts extends AppCompatActivity {

    ArrayList<Contact> contacts = MainActivity.contacts;
    ArrayAdapter<Contact> adapter;
    ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);
        setTitle("Contacts (" + MainActivity.contacts.size() + ")");

        adapter = new ContactAdapter(this, R.layout.activity_contact_item, contacts);
        itemList.setAdapter(adapter);

        adapter.addAll(contacts);
        adapter.notifyDataSetChanged();

//        setListAdapter(adapter);
    }
}
