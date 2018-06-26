package com.example.homework_1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

            //Get all 13 elements
            TextView name = findViewById(R.id.details_name);
            TextView phone = findViewById(R.id.details_phone);
            TextView company = findViewById(R.id.details_company);
            TextView email = findViewById(R.id.details_email);
            TextView url = findViewById(R.id.details_url);
            TextView address = findViewById(R.id.details_address);
            TextView birthday = findViewById(R.id.details_birthday);
            TextView nickname = findViewById(R.id.details_nickname);
            TextView facebook = findViewById(R.id.details_facebook);
            TextView twitter = findViewById(R.id.details_twitter);
            TextView skype = findViewById(R.id.details_skype);
            TextView youtube = findViewById(R.id.details_youtube);
            ImageView image = findViewById(R.id.details_image);

            //Set all 13 elements
            String nameString = contact.getFirstName()+" "+contact.getLastName();
            name.setText(nameString);
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
            if(contact.getImage()!=null){
                byte[] image_data = contact.getImage();
                Bitmap bitmap = BitmapFactory.decodeByteArray(image_data, 0, image_data.length);
                image.setImageBitmap(bitmap);
            }
        }
    }
}
