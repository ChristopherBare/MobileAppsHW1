package com.example.homework_1;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayContacts extends AppCompatActivity {

    ArrayList<Contact> contacts = MainActivity.contacts;
    ContactAdapter adapter;
    ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);
        setTitle("Contacts");

        adapter = new ContactAdapter(this, R.layout.activity_contact_item, contacts);
        itemList = findViewById(R.id.list_view_contacts);
        itemList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.item_phone);
                String phone = textView.getText().toString();
                Contact toRemove = null;

                for(Contact c: contacts) {
                    if (c.getPhone().equals(phone)) {
                        if (getIntent().getExtras().getBoolean(MainActivity.DELETE_KEY) == true) {
                            toRemove = c;
                        }
                        else if (getIntent().getExtras().getBoolean(MainActivity.EDIT_KEY) == true) {
                            Intent intent = new Intent(DisplayContacts.this, CreateContact.class);
                            intent.putExtra(MainActivity.CONTACT_KEY, c);
                            intent.putExtra(MainActivity.EDIT_KEY, true);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(DisplayContacts.this, ContactDetails.class);
                            intent.putExtra(MainActivity.CONTACT_KEY, c);
                            startActivity(intent);
                        }
                    }
                }
                MainActivity.contacts.remove(toRemove);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

