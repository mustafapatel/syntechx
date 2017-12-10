package com.antimony.scriptoo.syntechx;

import android.content.Context;
import android.content.Intent;
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


    private static class ViewHolder{
        TextView name;
        ImageView image;
    }


    public EventsAdapter(Context context, ArrayList<EventClass> events){
        super(context, 0, events);
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        EventClass event = getItem(position);
        //GET EVENT FROM ARRAYADAPTER

        ViewHolder viewHolder;

        if(convertView == null){

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_card, parent, false);

            viewHolder.name = convertView.findViewById(R.id.event_card_title);
            viewHolder.image = convertView.findViewById(R.id.events_card_background);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //INFLATE THE VIEW



        viewHolder.name.setText(event.name);
        viewHolder.image.setBackgroundResource(event.getEventBackgroundResource());
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), EventActivity.class);
                i.putExtra("ID", position);
                getContext().startActivity(i);
            }
        });



        return convertView;
    }
}
