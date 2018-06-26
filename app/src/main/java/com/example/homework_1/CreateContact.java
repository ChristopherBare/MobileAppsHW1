package com.example.homework_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    final static String CONTACT_ID = "CONTACT_ID";

    private String firstNameString;
    private String lastNameString;
    private String phoneString;
    private String oldPhone;
    private ImageView image;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        setTitle("Create Contact");

        final EditText firstName = (EditText) findViewById(R.id.edit_first_name);
        final EditText lastName = (EditText) findViewById(R.id.edit_last_name);
        final EditText phone = (EditText) findViewById(R.id.edit_phone);
        final EditText company = (EditText) findViewById(R.id.edit_company);
        final EditText email = (EditText) findViewById(R.id.edit_email);
        final EditText url = (EditText) findViewById(R.id.edit_url);
        final EditText address = (EditText) findViewById(R.id.edit_address);
        final EditText birthday = (EditText) findViewById(R.id.edit_birthday);
        final EditText nickname = (EditText) findViewById(R.id.edit_nickname);
        final EditText facebook = (EditText) findViewById(R.id.edit_Facebook);
        final EditText twitter = (EditText) findViewById(R.id.edit_Twitter);
        final EditText skype = (EditText) findViewById(R.id.edit_Skype);
        final EditText youtube = (EditText) findViewById(R.id.edit_YouTube);
        image = (ImageView) findViewById(R.id.item_image);

        if (getIntent()!=null && getIntent().getExtras()!=null && getIntent().getExtras().getBoolean(MainActivity.EDIT_KEY)){
            contact = (Contact) getIntent().getExtras().get(MainActivity.CONTACT_KEY);
            firstName.setText(contact.getFirstName());
            lastName.setText(contact.getLastName());
            phone.setText(contact.getPhone());
            company.setText(contact.getCompany());
            email.setText(contact.getEmail());
            url.setText(contact.getUrl());
            address.setText(contact.getAddress());
            birthday.setText(contact.getBirthday());
            nickname.setText(contact.getNickname());
            facebook.setText(contact.getFacebook());
            twitter.setText(contact.getTwitter());
            skype.setText(contact.getSkype());
            youtube.setText(contact.getYoutube());

            oldPhone = contact.getPhone();
        }

        findViewById(R.id.button_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Ensure that all fields contain data
                if (firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || phone.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "First three fields are required", Toast.LENGTH_LONG).show();

                //Validate phone number
                if (phone.getText().toString().length() > 15) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid phone number", Toast.LENGTH_LONG).show();

                } else {
                    //Set fields to values from page elements
                    firstNameString = firstName.getText().toString();
                    lastNameString = lastName.getText().toString();
                    phoneString = phone.getText().toString();

                    //Create a contact object from the information gathered and set the required information
                    Contact contact = new Contact();
                    contact.setFirstName(firstNameString);
                    contact.setLastName(lastNameString);
                    contact.setPhone(phoneString);

                    //If any of the other fields are filled out, add the info to the contact
                    if (!company.getText().toString().isEmpty()) contact.setCompany(company.getText().toString());
                    if (!email.getText().toString().isEmpty()) contact.setEmail(email.getText().toString());
                    if (!url.getText().toString().isEmpty()) contact.setUrl(url.getText().toString());
                    if (!address.getText().toString().isEmpty()) contact.setAddress(address.getText().toString());
                    if (!birthday.getText().toString().isEmpty()) contact.setBirthday(birthday.getText().toString());
                    if (!nickname.getText().toString().isEmpty()) contact.setNickname(nickname.getText().toString());
                    if (!facebook.getText().toString().isEmpty()) contact.setFacebook(facebook.getText().toString());
                    if (!twitter.getText().toString().isEmpty()) contact.setTwitter(twitter.getText().toString());
                    if (!skype.getText().toString().isEmpty()) contact.setSkype(skype.getText().toString());
                    if (!youtube.getText().toString().isEmpty()) contact.setYoutube(youtube.getText().toString());



                    //Start an intent to the main activity and pass the contact info through
                    Intent intent = new Intent(CreateContact.this, MainActivity.class);
                    intent.putExtra(MainActivity.CONTACT_KEY, contact);
                    if (getIntent().getExtras()!=null && getIntent().getExtras().getBoolean(MainActivity.CREATE_KEY)) intent.putExtra(MainActivity.CREATE_KEY, true);
                    if (getIntent().getExtras()!=null && getIntent().getExtras().getBoolean(MainActivity.EDIT_KEY)){
                        intent.putExtra(MainActivity.EDIT_KEY, true);
                        intent.putExtra(CONTACT_ID, oldPhone);
                    }
                    startActivity(intent);
                    finish();
                }
            }
        });

        findViewById(R.id.item_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
        }
    }


}
