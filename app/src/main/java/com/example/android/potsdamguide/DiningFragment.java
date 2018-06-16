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
 * A simple {@link DiningFragment} subclass shows the list of the restaurants and cafes in Potsdam.
 */
public class DiningFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<InfoLocation> dining = new ArrayList<InfoLocation>();

        //Getting resources for the string messages
        final String restaurant1 = getResources().getString(R.string.restaurant1);
        String restaurant2 = getResources().getString(R.string.restaurant2);
        String restaurant3 = getResources().getString(R.string.restaurant3);
        String restaurant4 = getResources().getString(R.string.restaurant4);
        String restaurant5 = getResources().getString(R.string.restaurant5);
        String restaurant6 = getResources().getString(R.string.restaurant6);
        String restaurant7 = getResources().getString(R.string.restaurant7);
        String restaurant8 = getResources().getString(R.string.restaurant8);
        String addressRestaurant1 = getResources().getString(R.string.address_restaurant1);
        String addressRestaurant2 = getResources().getString(R.string.address_restaurant2);
        String addressRestaurant3 = getResources().getString(R.string.address_restaurant3);
        String addressRestaurant4 = getResources().getString(R.string.address_restaurant4);
        String addressRestaurant5 = getResources().getString(R.string.address_restaurant5);
        String addressRestaurant6 = getResources().getString(R.string.address_restaurant6);
        String addressRestaurant7 = getResources().getString(R.string.address_restaurant7);
        String addressRestaurant8 = getResources().getString(R.string.address_restaurant8);
        String aboutRestaurant1 = getResources().getString(R.string.about_restaurant1);
        String aboutRestaurant2 = getResources().getString(R.string.about_restaurant2);
        String aboutRestaurant3 = getResources().getString(R.string.about_restaurant3);
        String aboutRestaurant4 = getResources().getString(R.string.about_restaurant4);
        String aboutRestaurant5 = getResources().getString(R.string.about_restaurant5);
        String aboutRestaurant6 = getResources().getString(R.string.about_restaurant6);
        String aboutRestaurant7 = getResources().getString(R.string.about_restaurant7);
        String aboutRestaurant8 = getResources().getString(R.string.about_restaurant8);

        //Adding elements to the list
        dining.add(new InfoLocation(restaurant1, addressRestaurant1, aboutRestaurant1, R.drawable.restaurant1));
        dining.add(new InfoLocation(restaurant2, addressRestaurant2, aboutRestaurant2, R.drawable.restaurant2));
        dining.add(new InfoLocation(restaurant3, addressRestaurant3, aboutRestaurant3, R.drawable.restaurant3));
        dining.add(new InfoLocation(restaurant4, addressRestaurant4, aboutRestaurant4, R.drawable.restaurant4));
        dining.add(new InfoLocation(restaurant5, addressRestaurant5, aboutRestaurant5, R.drawable.restaurant5));
        dining.add(new InfoLocation(restaurant6, addressRestaurant6, aboutRestaurant6, R.drawable.restaurant6));
        dining.add(new InfoLocation(restaurant7, addressRestaurant7, aboutRestaurant7, R.drawable.restaurant7));
        dining.add(new InfoLocation(restaurant8, addressRestaurant8, aboutRestaurant8, R.drawable.restaurant8));

        InfoAdapter adapter = new InfoAdapter(getActivity(), dining, R.color.colorBackground);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Launching the map of Potsdam with the location of the restaurants, bars and cafes
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                InfoLocation information = dining.get(position);
                List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);

                Uri gmmIntentUri = Uri.parse("geo:52.395838,13.077224?z=10&q=restaurants");
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
