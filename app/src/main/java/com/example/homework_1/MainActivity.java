package com.example.homework_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String CREATE_KEY = "NAME";
    final static String EDIT_KEY = "EMAIL";
    final static String DELETE_KEY = "RADIO";
    final static String DISPLAY_KEY = "MOOD";
    final static int CREATE_CODE = 0;
    final static int EDIT_CODE = 1;
    final static int DELETE_CODE = 2;
    final static int DISPLAY_CODE = 3;

    static ArrayList<Contact> contacts = new ArrayList<>();
    final static String CONTACTS_LIST_KEY = "CONTACTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contacts (" + contacts.size() + ")");

        //Check to see if information is being sent
        if(getIntent() != null){
            //Make sure the intent has extras before trying to access them because that sucks
            if (getIntent().getExtras() != null) {

                //Contact is being created
                if (getIntent().getExtras().getBoolean(MainActivity.CREATE_KEY) == true) {
                    Contact contact = (Contact) getIntent().getExtras().getSerializable(CreateContact.CONTACT_KEY);
                    contacts.add(contact);
                    setTitle("Contacts (" + contacts.size() + ")");
                }
            }
        }

        findViewById(R.id.contact_create_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent to the second activity and pass the student info through
                Intent intent = new Intent(MainActivity.this, CreateContact.class);
                startActivityForResult(intent, CREATE_CODE);
            }
        });

        findViewById(R.id.contact_display_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent to the second activity and pass the student info through
                Intent intent = new Intent(MainActivity.this, DisplayContacts.class);
                intent.putExtra(CONTACTS_LIST_KEY, contacts);
                startActivity(intent);
            }
        });
    }
}
