package com.antimony.scriptoo.syntechx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by antimony on 12/10/17.
 */

public class EventsFragment extends Fragment {


    Toolbar toolbar;


    public static EventsFragment getInstance(){
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        toolbar = (Toolbar)getActivity().findViewById(R.id.events_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }
}
