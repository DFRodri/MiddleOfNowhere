package com.example.android.middleofnowhere.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.middleofnowhere.CustomClass.Places;
import com.example.android.middleofnowhere.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Class of the adapter to be used in our MainActivity
//Makes use of ViewHolder to make things faster
public class PlacesAdapter extends ArrayAdapter<Places> {

    public PlacesAdapter(Activity context, ArrayList<Places> placesArrayList) {
        super(context, 0, placesArrayList);
    }

    //The class that holds the views that will be recycled
    static class ViewHolder {
        //ALL HAIL SAINT BUTTERKNIFE!
        //Later findViewById!
        //ButterKnife - http://jakewharton.github.io/butterknife/
        @BindView(R.id.place)
        RelativeLayout place;
        @BindView(R.id.previewImage)
        ImageView previewImage;
        @BindView(R.id.titlePlace)
        TextView titlePlace;
        @BindView(R.id.descriptionPlace)
        TextView descriptionPlace;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    //The getView method to display (return) each row of what we want as we want with a certain layout as a base
    //Makes use of a ViewHolder class created previously to recycle data even further
    //R.id.<layout name> -> the layout
    //getMethods -> what we want to be displayed in each recycled view
    //the views loaded with the holder -> what we want to populate with data
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //each element (Item) of our list has data stored in different positions
        //this makes sure that we're accessing the right one
        final Places currentPlace = getItem(position);

        //fetches the info from the Places Object stored
        int newImage = currentPlace.getNewImage();
        String newTitlePlace = currentPlace.getNewPlaceName();
        String newDescription = currentPlace.getNewShortDescription();
        CharSequence convertedDescription = Html.fromHtml(newDescription);

        //sets the info fetched from the get methods so we can have something displayed
        holder.previewImage.setImageResource(newImage);
        holder.titlePlace.setText(newTitlePlace);
        holder.descriptionPlace.setText(convertedDescription);

        //returns all the work made related the convertView to the caller
        return convertView;
    }
}
