package com.example.android.potsdamguide;

/**
 * {@Link InfoLocation} is created to represent the Name of the event, place or historical sight in
 * the list item, the address of the exact location and the short information.
 */

public class InfoLocation {

    //The name of the place
    private String mName;

    //The address of the place
    private String mAddress;

    //Information about the place, event.
    private String mAbout;

    //Image that is assigned to the TextView
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = 0;

    /**
     * Creating new InfoLocation object
     *
     * @param name
     * @param address
     * @param about
     * @param imageResourceID
     */

    public InfoLocation(String name, String address, String about, int imageResourceID) {
        mName = name;
        mAddress = address;
        mAbout = about;
        mImageResourceID = imageResourceID;
    }

    //Get the name of the place
    public String getmName() {
        return mName;
    }

    //Get the address of the place
    public String getmAddress() {
        return mAddress;
    }

    //Get the information about the place
    public String getmAbout() {
        return mAbout;
    }

    //Get the image for the TextView
    public int getmImageResourceID() {
        return mImageResourceID;
    }

    //Returns whether or not there is an image for the word
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
