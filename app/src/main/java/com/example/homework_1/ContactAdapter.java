package com.example.homework_1;

import android.content.Context;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_contact_item, parent, false);

        TextView item_name = convertView.findViewById(R.id.item_name);
        TextView item_phone = convertView.findViewById(R.id.item_phone);

        //set the data from the contact object
        item_name.setText(contact.getFirstName() + " " + contact.getLastName());
        item_phone.setText(contact.getPhone());

        return convertView;
    }
}
