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

public class CategoryZero extends Fragment {

    //the "onCreate" method of our fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflates our view (I think that this is the equivalent of setContentView with an activity?)
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //our array list and the info we want to be seen later in the list view
        final ArrayList<Places> categoryZero = new ArrayList<>();
        categoryZero.add(new Places(R.drawable.sao_jorge_castle, getString(R.string.monument0),
                getString(R.string.monumentInfo0), getString(R.string.monumentWebsite0), getString(R.string.monumentAddress0), getString(R.string.monumentPhone0)));
        categoryZero.add(new Places(R.drawable.jeronimos_monastery, getString(R.string.monument1),
                getString(R.string.monumentInfo1), getString(R.string.monumentWebsite1), getString(R.string.monumentAddress1), getString(R.string.monumentPhone1)));
        categoryZero.add(new Places(R.drawable.belem_tower, getString(R.string.monument2),
                getString(R.string.monumentInfo2), getString(R.string.monumentWebsite2), getString(R.string.monumentAddress2), getString(R.string.monumentPhone2)));
        categoryZero.add(new Places(R.drawable.santa_justa_lift, getString(R.string.monument3),
                getString(R.string.monumentInfo3), getString(R.string.monumentWebsite3), getString(R.string.monumentAddress3), getString(R.string.monumentPhone3)));
        categoryZero.add(new Places(R.drawable.monument_to_the_discoveries, getString(R.string.monument4),
                getString(R.string.monumentInfo4), getString(R.string.monumentWebsite4), getString(R.string.monumentAddress4), getString(R.string.monumentPhone4)));

        //the creation of an adapter to our array list
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), categoryZero);

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
                Places place = categoryZero.get(position);

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
