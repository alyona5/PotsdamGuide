package com.example.android.potsdamguide;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link EventsFragment} subclass shows the list of information about the biggest events in Potsdam.
 */
public class EventsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<InfoLocation> info_s = new ArrayList<InfoLocation>();

        //Getting resources for the String messages
        String event1 = getResources().getString(R.string.event1);
        String event2 = getResources().getString(R.string.event2);
        String event3 = getResources().getString(R.string.event3);
        String addressEvent1 = getResources().getString(R.string.address_event1);
        String addressEvent2 = getResources().getString(R.string.address_event2);
        String addressEvent3 = getResources().getString(R.string.address_event3);
        String aboutEvent1 = getResources().getString(R.string.about_event1);
        String aboutEvent2 = getResources().getString(R.string.about_event2);
        String aboutEvent3 = getResources().getString(R.string.about_event3);

        //Adding the elements to the the ArrayList
        info_s.add(new InfoLocation(event1, addressEvent1, aboutEvent1, R.drawable.music));
        info_s.add(new InfoLocation(event2, addressEvent2, aboutEvent2, R.drawable.fireworks));
        info_s.add(new InfoLocation(event3, addressEvent3, aboutEvent3, R.drawable.xmas));

        InfoAdapter adapter = new InfoAdapter(getActivity(), info_s, R.color.colorBackground);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Starting the map of Potsdam
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                InfoLocation information = info_s.get(position);
                List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);

                Uri gmmIntentUri = Uri.parse("geo:52.395838,13.077224?z=10");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return rootView;
    }

}
