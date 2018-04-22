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

public class CategoryThree extends Fragment {

    //the "onCreate" method of our fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflates our view (I think that this is the equivalent of setContentView with an activity?)
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //our array list and the info we want to be seen later in the list view
        final ArrayList<Places> categoryThree = new ArrayList<>();
        categoryThree.add(new Places(R.drawable.portvgalia, getString(R.string.restaurant0),
                getString(R.string.restaurantInfo0), getString(R.string.restaurantWebsite0), getString(R.string.restaurantAddress0), getString(R.string.restaurantPhone0)));
        categoryThree.add(new Places(R.drawable.feitoria, getString(R.string.restaurant1),
                getString(R.string.restaurantInfo1), getString(R.string.restaurantWebsite1), getString(R.string.restaurantAddress1), getString(R.string.restaurantPhone1)));
        categoryThree.add(new Places(R.drawable.a_tasquinha_do_lagarto, getString(R.string.restaurant2),
                getString(R.string.restaurantInfo2), getString(R.string.restaurantWebsite2), getString(R.string.restaurantAddress2), getString(R.string.restaurantPhone2)));
        categoryThree.add(new Places(R.drawable.solar_dos_presuntos, getString(R.string.restaurant3),
                getString(R.string.restaurantInfo3), getString(R.string.restaurantWebsite3), getString(R.string.restaurantAddress3), getString(R.string.restaurantPhone3)));
        categoryThree.add(new Places(R.drawable.o_miudinho, getString(R.string.restaurant4),
                getString(R.string.restaurantInfo4), getString(R.string.restaurantWebsite4), getString(R.string.restaurantAddress4), getString(R.string.restaurantPhone4)));

        //the creation of an adapter to our array list
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), categoryThree);

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
                Places place = categoryThree.get(position);

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
