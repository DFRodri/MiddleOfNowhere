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

import com.example.android.middleofnowhere.CustomClass.Places;
import com.example.android.middleofnowhere.Adapter.PlacesAdapter;
import com.example.android.middleofnowhere.InfoActivity;
import com.example.android.middleofnowhere.R;

import java.util.ArrayList;

public class CategoryOne extends Fragment {

    //the "onCreate" method of our fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflates our view (I think that this is the equivalent of setContentView with an activity?)
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //our array list and the info we want to be seen later in the list view
        final ArrayList<Places> categoryOne = new ArrayList<>();
        categoryOne.add(new Places(R.drawable.museum_calouste_gulbenkian, getString(R.string.museum0),
                getString(R.string.museumInfo0), getString(R.string.museumWebsite0), getString(R.string.museumAddress0), getString(R.string.museumPhone0)));
        categoryOne.add(new Places(R.drawable.maritime_museum, getString(R.string.museum1),
                getString(R.string.museumInfo1), getString(R.string.museumWebsite1), getString(R.string.museumAddress1), getString(R.string.museumPhone1)));
        categoryOne.add(new Places(R.drawable.national_museum_of_ancient_art, getString(R.string.museum2),
                getString(R.string.museumInfo2), getString(R.string.museumWebsite2), getString(R.string.museumAddress2), getString(R.string.museumPhone2)));
        categoryOne.add(new Places(R.drawable.berardo_museum, getString(R.string.museum3),
                getString(R.string.museumInfo3), getString(R.string.museumWebsite3), getString(R.string.museumAddress3), getString(R.string.museumPhone3)));
        categoryOne.add(new Places(R.drawable.national_museum_bordalo_pinheiro, getString(R.string.museum4),
                getString(R.string.museumInfo4), getString(R.string.museumWebsite4), getString(R.string.museumAddress4), getString(R.string.museumPhone4)));

        //the creation of an adapter to our array list
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), categoryOne);

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
                Places place = categoryOne.get(position);

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
