package com.example.android.potsdamguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alyona on 13/04/2018.
 */

public class InfoAdapter extends ArrayAdapter<InfoLocation> {

    //Resource ID for the background color of the fragment
    private int mColorFragment;

    /**
     * Creating new {@Link InfoAdapter} object.
     *
     * @param context,      the current context that the adapter is being created in.
     * @param info_s        is the list of {@Link InfoLocation} to be displayed.
     * @param colorFragment is the resource ID for the background color of the fragment.
     */
    public InfoAdapter(Activity context, ArrayList<InfoLocation> info_s, int colorFragment) {
        super(context, 0, info_s);
        mColorFragment = colorFragment;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if the existing view has been reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link InfoLocation} object located at this position in the list
        InfoLocation currentInfo = (InfoLocation) getItem(position);

        // Find the Name TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentInfo.getmName());

        // Find the Address TextView in the list_item.xml layout with the ID version_name
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.location);
        addressTextView.setText(currentInfo.getmAddress());

        //Find the TextView with the information about the event
        TextView aboutTextView = (TextView) listItemView.findViewById(R.id.about);
        aboutTextView.setText(currentInfo.getmAbout());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentInfo.getmImageResourceID());

        if (currentInfo.hasImage()) {
            //Set the ImageView to the image resource specified in the current Word
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorFragment);
        //Set the background color of the next container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
