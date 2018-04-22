package com.example.android.middleofnowhere.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.middleofnowhere.Adapter.PlacesAdapter;
import com.example.android.middleofnowhere.CustomClass.Places;
import com.example.android.middleofnowhere.InfoActivity;
import com.example.android.middleofnowhere.R;

import java.util.ArrayList;

public class CategoryTwo extends Fragment {

    //the "onCreate" method of our fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflates our view (I think that this is the equivalent of setContentView with an activity?)
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //our array list and the info we want to be seen later in the list view
        final ArrayList<Places> categoryTwo = new ArrayList<>();
        categoryTwo.add(new Places(R.drawable.pasteis_de_belem, getString(R.string.pastry0),
                getString(R.string.pastryInfo0), getString(R.string.pastryWebsite0), getString(R.string.pastryAddress0), getString(R.string.pastryPhone0)));
        categoryTwo.add(new Places(R.drawable.cister, getString(R.string.pastry1),
                getString(R.string.pastryInfo1), getString(R.string.pastryWebsite1), getString(R.string.pastryAddress1), getString(R.string.pastryPhone1)));
        categoryTwo.add(new Places(R.drawable.versailles, getString(R.string.pastry2),
                getString(R.string.pastryInfo2), getString(R.string.pastryWebsite2), getString(R.string.pastryAddress2), getString(R.string.pastryPhone2)));
        categoryTwo.add(new Places(R.drawable.a_brasileira, getString(R.string.pastry3),
                getString(R.string.pastryInfo3), getString(R.string.pastryWebsite3), getString(R.string.pastryAddress3), getString(R.string.pastryPhone3)));
        categoryTwo.add(new Places(R.drawable.national_confectionery, getString(R.string.pastry4),
                getString(R.string.pastryInfo4), getString(R.string.pastryWebsite4), getString(R.string.pastryAddress4), getString(R.string.pastryPhone4)));

        //the creation of an adapter to our array list
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), categoryTwo);

        //telling rootView the id of the list view we want to populate with our array list
        ListView listView = rootView.findViewById(R.id.listOfPlaces);
        //sets the adapter
        listView.setAdapter(adapter);

        //click listener set to our list view when the user wants to know a bit more about one of
        //the places in our list view
        //it works with a parcelable and a bundle since we just need one object from our array list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Places place = categoryTwo.get(position);

                Bundle bundle = new Bundle();
                bundle.putParcelable("selectedPlace", place);
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //returns all the work made related the rootView to the caller
        return rootView;
    }
}
