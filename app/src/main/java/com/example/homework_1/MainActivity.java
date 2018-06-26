package com.example.homework_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String CREATE_KEY = "CREATE";
    final static String EDIT_KEY = "EDIT";
    final static String DELETE_KEY = "DELETE";
    final static String DISPLAY_KEY = "DISPLAY";
    final static int CREATE_CODE = 0;
    final static int EDIT_CODE = 1;
    final static int DELETE_CODE = 2;
    final static int DISPLAY_CODE = 3;

    final static String CONTACT_KEY = "CONTACT";
    static ArrayList<Contact> contacts = new ArrayList<>();
    final static String CONTACTS_LIST_KEY = "CONTACTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contacts");

        if (contacts.size()==0) {
            Contact contact = new Contact();
            contact.setFirstName("Hunter");
            contact.setLastName("Heavener");
            contact.setPhone("(704) 616-1658");
            contact.setNickname("DaPooHeist");
            contact.setCompany("UnderWare");
            contacts.add(contact);

            Contact contact2 = new Contact();
            contact2.setFirstName("Chris");
            contact2.setLastName("Bare");
            contact2.setPhone("(828) 781-4547");
            contacts.add(contact2);
        }

        //Check to see if information is being sent
        if(getIntent() != null){
            //Make sure the intent has extras before trying to access them because that sucks
            if (getIntent().getExtras() != null) {

                //Contact is being created
                if (getIntent().getExtras().getBoolean(MainActivity.CREATE_KEY) == true) {
                    Contact contact = (Contact) getIntent().getExtras().getSerializable(CONTACT_KEY);
                    contacts.add(contact);
                }

                //Contact is being edited
                if (getIntent().getExtras().getBoolean(MainActivity.EDIT_KEY) == true) {
                    Contact toRemove = null;
                    Contact contact = (Contact) getIntent().getExtras().getSerializable(CONTACT_KEY);
                    for (Contact c : contacts)
                        if (c.getPhone().equals(getIntent().getExtras().get(CreateContact.CONTACT_ID)))
                            toRemove = c;
                    contacts.remove(toRemove);
                    contacts.add(contact);
                }
            }
        }

        //Create new contact
        findViewById(R.id.contact_create_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent to the second activity and pass the student info through
                Intent intent = new Intent(MainActivity.this, CreateContact.class);
//                startActivityForResult(intent, CREATE_CODE);
                startActivity(intent);
            }
        });

        //Edit contact
        findViewById(R.id.contact_edit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent to the second activity and pass the student info through
                Intent intent = new Intent(MainActivity.this, DisplayContacts.class);
                intent.putExtra(EDIT_KEY, true);
                startActivity(intent);
            }
        });


        //Delete contact
        findViewById(R.id.contact_delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent to the second activity and pass the student info through
                Intent intent = new Intent(MainActivity.this, DisplayContacts.class);
                intent.putExtra(DELETE_KEY, true);
//                startActivityForResult(intent, DELETE_CODE);
                startActivity(intent);
            }
        });

        //Display contacts
        findViewById(R.id.contact_display_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent to the second activity and pass the student info through
                Intent intent = new Intent(MainActivity.this, DisplayContacts.class);
                intent.putExtra(CONTACTS_LIST_KEY, contacts);
                startActivity(intent);
            }
        });

        //Exit the app
        findViewById(R.id.app_exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


