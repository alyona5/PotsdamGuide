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
 * A  {@link MuseumsFragment} subclass shows the list of information about the museums in Potsdam.
 */
public class MuseumsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<InfoLocation> museum = new ArrayList<InfoLocation>();

        //Getting resources for the string messages
        String museum1 = getResources().getString(R.string.museum1);
        String museum2 = getResources().getString(R.string.museum2);
        String museum3 = getResources().getString(R.string.museum3);
        String museum4 = getResources().getString(R.string.museum4);
        String museum5 = getResources().getString(R.string.museum5);
        String addressMuseum1 = getResources().getString(R.string.address_museum1);
        String addressMuseum2 = getResources().getString(R.string.address_museum2);
        String addressMuseum3 = getResources().getString(R.string.address_museum3);
        String addressMuseum4 = getResources().getString(R.string.address_museum4);
        String addressMuseum5 = getResources().getString(R.string.address_museum5);
        String aboutMuseum1 = getResources().getString(R.string.about_museum1);
        String aboutMuseum2 = getResources().getString(R.string.about_museum2);
        String aboutMuseum3 = getResources().getString(R.string.about_museum3);
        String aboutMuseum4 = getResources().getString(R.string.about_museum4);
        String aboutMuseum5 = getResources().getString(R.string.about_museum5);

        //Adding the elements to the the ArrayList
        museum.add(new InfoLocation(museum1, addressMuseum1, aboutMuseum1, R.drawable.museum1));
        museum.add(new InfoLocation(museum2, addressMuseum2, aboutMuseum2, R.drawable.museum2));
        museum.add(new InfoLocation(museum3, addressMuseum3, aboutMuseum3, R.drawable.museum3));
        museum.add(new InfoLocation(museum4, addressMuseum4, aboutMuseum4, R.drawable.museum4));
        museum.add(new InfoLocation(museum5, addressMuseum5, aboutMuseum5, R.drawable.museum5));

        InfoAdapter adapter = new InfoAdapter(getActivity(), museum, R.color.colorBackground);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Launching the map of Potsdam with the location of the museums
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                InfoLocation information = museum.get(position);
                List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);

                Uri gmmIntentUri = Uri.parse("geo:52.395838,13.077224?z=10&q=museums");
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
