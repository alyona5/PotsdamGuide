package com.example.android.potsdamguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link InfoLocation} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    //Context of the app
    private Context mContext;

    /**
     * Create a new {@Link CategoryAdapter object}
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter across swipes.
     * @param context context of the app
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EventsFragment();
        } else if (position == 1) {
            return new PlacesFragment();
        } else if (position == 2) {
            return new MuseumsFragment();
        } else if (position == 3) {
            return new DiningFragment();
        } else {
            return new HotelsFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    //The array of icons
    final int[] icons = {
            R.drawable.ic_event_white_24dp,
            R.drawable.ic_place_white_24dp,
            R.drawable.ic_account_balance_white_24dp,
            R.drawable.ic_restaurant_white_24dp,
            R.drawable.ic_hotel_white_24dp
    };

    @Override
    public CharSequence getPageTitle(int position) {
        //  Drawable image = getResources().getDrawable(imageResId[position]);
        Drawable image = ContextCompat.getDrawable(mContext, icons[position]);
        //  Drawable image = mContext.getResources().getDrawable(icon[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
