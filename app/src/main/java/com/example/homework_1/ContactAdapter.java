package com.example.homework_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {


    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_contact_item, parent, false);

        TextView item_name = convertView.findViewById(R.id.item_name);
        TextView item_phone = convertView.findViewById(R.id.item_phone);
        ImageView item_image = convertView.findViewById(R.id.item_image);

        //set the data from the contact object
        item_name.setText(contact.getFirstName() + " " + contact.getLastName());
        item_phone.setText(contact.getPhone());
        if (contact.getImage()!=null){
            byte[] image_data = contact.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image_data, 0, image_data.length);
            item_image.setImageBitmap(bitmap);
        }

        return convertView;
    }
}
