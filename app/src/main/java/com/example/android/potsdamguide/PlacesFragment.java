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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link PlacesFragment} subclass shows the list of information about the historical sights,
 * parks and monuments in Potsdam.
 */
public class PlacesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<InfoLocation> places = new ArrayList<InfoLocation>();

        //Getting resources for the string messages
        String place1 = getResources().getString(R.string.place1);
        String place2 = getResources().getString(R.string.place2);
        String place3 = getResources().getString(R.string.place3);
        String place4 = getResources().getString(R.string.place4);
        String place5 = getResources().getString(R.string.place5);
        String addressPlace1 = getResources().getString(R.string.address_place1);
        String addressPlace2 = getResources().getString(R.string.address_place2);
        String addressPlace3 = getResources().getString(R.string.address_place3);
        String addressPlace4 = getResources().getString(R.string.address_place4);
        String addressPlace5 = getResources().getString(R.string.address_place5);
        String aboutPlace1 = getResources().getString(R.string.about_place1);
        String aboutPlace2 = getResources().getString(R.string.about_place2);
        String aboutPlace3 = getResources().getString(R.string.about_place3);
        String aboutPlace4 = getResources().getString(R.string.about_place4);
        String aboutPlace5 = getResources().getString(R.string.about_place5);

        //Adding the elements to the the ArrayList
        places.add(new InfoLocation(place1, addressPlace1, aboutPlace1, R.drawable.park1));
        places.add(new InfoLocation(place2, addressPlace2, aboutPlace2, R.drawable.park2));
        places.add(new InfoLocation(place3, addressPlace3, aboutPlace3, R.drawable.park3));
        places.add(new InfoLocation(place4, addressPlace4, aboutPlace4, R.drawable.place4));
        places.add(new InfoLocation(place5, addressPlace5, aboutPlace5, R.drawable.place5));

        InfoAdapter adapter = new InfoAdapter(getActivity(), places, R.color.colorBackground);

        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Starting the map of Potsdam
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                InfoLocation information = places.get(position);
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
