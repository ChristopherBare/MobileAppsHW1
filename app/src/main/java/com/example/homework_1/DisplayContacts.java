package com.example.homework_1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayContacts extends AppCompatActivity {

    ArrayList<Contact> contacts = MainActivity.contacts;
    ContactAdapter adapter;
    ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);
        setTitle("Contacts (" + MainActivity.contacts.size() + ")");
        Log.d("demo", "before adapter line");

        if (contacts.size()==0) {
            Contact contact = new Contact();
            contact.setFirstName("Hunter");
            contact.setLastName("Heavener");
            contact.setPhone("(704) 616-1658");
            contacts.add(contact);

            Contact contact2 = new Contact();
            contact2.setFirstName("Chris");
            contact2.setLastName("Bare");
            contact2.setPhone("(828) 781-4547");
            contacts.add(contact2);

            setTitle("Contacts (" + MainActivity.contacts.size() + ")");
        }
        adapter = new ContactAdapter(this, R.layout.activity_contact_item, contacts);
        itemList = findViewById(R.id.list_view_contacts);
        itemList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}

