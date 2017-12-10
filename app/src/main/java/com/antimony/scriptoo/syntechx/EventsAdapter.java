package com.antimony.scriptoo.syntechx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsAdapter extends ArrayAdapter<EventClass> {


    public EventsAdapter(Context context, ArrayList<EventClass> events){
        super(context, 0, events);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        EventClass event = getItem(position);
        //GET EVENT FROM ARRAYADAPTER

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_card, parent, false);
        }
        //INFLATE THE VIEW


        //POPULATE THE STUFF
        TextView name = (TextView)convertView.findViewById(R.id.event_card_title);
        name.setText(event.name);

        ImageView image = (ImageView)convertView.findViewById(R.id.events_card_background);
        image.setBackgroundResource(event.getEventBackgroundResource());

        return convertView;
    }
}
