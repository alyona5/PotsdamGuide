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
 * A simple {@link HotelsFragment} subclass has the list of the hotels in Potsdam.
 */
public class HotelsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<InfoLocation> hotel = new ArrayList<InfoLocation>();

        //Getting resources for the String messages
        String hotel1 = getResources().getString(R.string.hotel1);
        String hotel2 = getResources().getString(R.string.hotel2);
        String hotel3 = getResources().getString(R.string.hotel3);
        String hotel4 = getResources().getString(R.string.hotel4);
        String hotel5 = getResources().getString(R.string.hotel5);
        String hotel6 = getResources().getString(R.string.hotel6);
        String hotel7 = getResources().getString(R.string.hotel7);
        String hotel8 = getResources().getString(R.string.hotel8);
        String addressHotel1 = getResources().getString(R.string.address_hotel1);
        String addressHotel2 = getResources().getString(R.string.address_hotel2);
        String addressHotel3 = getResources().getString(R.string.address_hotel3);
        String addressHotel4 = getResources().getString(R.string.address_hotel4);
        String addressHotel5 = getResources().getString(R.string.address_hotel5);
        String addressHotel6 = getResources().getString(R.string.address_hotel6);
        String addressHotel7 = getResources().getString(R.string.address_hotel7);
        String addressHotel8 = getResources().getString(R.string.address_hotel8);
        String aboutHotel1 = getResources().getString(R.string.about_hotel1);
        String aboutHotel2 = getResources().getString(R.string.about_hotel2);
        String aboutHotel3 = getResources().getString(R.string.about_hotel3);
        String aboutHotel4 = getResources().getString(R.string.about_hotel4);
        String aboutHotel5 = getResources().getString(R.string.about_hotel5);
        String aboutHotel6 = getResources().getString(R.string.about_hotel6);
        String aboutHotel7 = getResources().getString(R.string.about_hotel7);
        String aboutHotel8 = getResources().getString(R.string.about_hotel8);

        //Adding elements to the list
        hotel.add(new InfoLocation(hotel1, addressHotel1, aboutHotel1, R.drawable.hotel1));
        hotel.add(new InfoLocation(hotel2, addressHotel2, aboutHotel2, R.drawable.hotel2));
        hotel.add(new InfoLocation(hotel3, addressHotel3, aboutHotel3, R.drawable.hotel3));
        hotel.add(new InfoLocation(hotel4, addressHotel4, aboutHotel4, R.drawable.hotel4));
        hotel.add(new InfoLocation(hotel5, addressHotel5, aboutHotel5, R.drawable.hotel5));
        hotel.add(new InfoLocation(hotel6, addressHotel6, aboutHotel6, R.drawable.hotel6));
        hotel.add(new InfoLocation(hotel7, addressHotel7, aboutHotel7, R.drawable.hotel7));
        hotel.add(new InfoLocation(hotel8, addressHotel8, aboutHotel8, R.drawable.hotel8));

        InfoAdapter adapter = new InfoAdapter(getActivity(), hotel, R.color.colorBackground);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Starting the map with the locations of hotels
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                InfoLocation information = hotel.get(position);
                List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);

                Uri gmmIntentUri = Uri.parse("geo:52.395838,13.077224?z=10&q=hotels");
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
