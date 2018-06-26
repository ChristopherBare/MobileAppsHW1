package com.example.homework_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        setTitle("Contact Details");

        if (getIntent() != null && getIntent().getExtras() != null) {
            Contact contact = (Contact) getIntent().getExtras().getSerializable(MainActivity.CONTACT_KEY);

            TextView name = (TextView) findViewById(R.id.details_name);
            TextView phone = (TextView) findViewById(R.id.details_phone);
            TextView company = (TextView) findViewById(R.id.details_company);
            TextView email = (TextView) findViewById(R.id.details_email);
            TextView url = (TextView) findViewById(R.id.details_url);
            TextView address = (TextView) findViewById(R.id.details_address);
            TextView birthday = (TextView) findViewById(R.id.details_birthday);
            TextView nickname = (TextView) findViewById(R.id.details_nickname);
            TextView facebook = (TextView) findViewById(R.id.details_facebook);
            TextView twitter = (TextView) findViewById(R.id.details_twitter);
            TextView skype = (TextView) findViewById(R.id.details_skype);
            TextView youtube = (TextView) findViewById(R.id.details_youtube);
            ImageView image = (ImageView) findViewById(R.id.details_image);

            name.setText(contact.getFirstName()+" "+contact.getLastName());
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
            if (contact.getImage()!=null) image.setImageBitmap(contact.getImage());
        }
    }
}
