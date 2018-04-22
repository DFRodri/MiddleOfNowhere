package com.example.android.middleofnowhere;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.android.middleofnowhere.Adapter.CreditsAdapter;
import com.example.android.middleofnowhere.Adapter.SimpleFragmentPageAdapter;
import com.example.android.middleofnowhere.CustomClass.Credits;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //ALL HAIL SAINT BUTTERKNIFE!
    //Later findViewById!
    //ButterKnife - http://jakewharton.github.io/butterknife/
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.slidingTabs)
    TabLayout tabLayout;
    @BindView(R.id.iconCredits)
    ImageView iconCredits;
    @BindView(R.id.credits)
    LinearLayout creditsMenu;
    @BindView(R.id.creditsList)
    ListView resourcesUsed;

    //global variable that holds the resources used
    private final ArrayList<Credits> creditsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //ViewPager and Tab Layout adapters
        SimpleFragmentPageAdapter adapter = new SimpleFragmentPageAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //call to method that add icons to the tab layout tabs
        setupIcons();

        //call to method that add the objects with the info of the resources used to the array list
        setupCredits();

        //adapter of the credits' list view
        CreditsAdapter creditsAdapter = new CreditsAdapter(this, creditsArrayList);
        resourcesUsed.setAdapter(creditsAdapter);

        //click listener of the credits
        //it hides and show a menu with them with clicks on the icon of the app
        iconCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creditsMenu.getVisibility() == View.VISIBLE) {
                    creditsMenu.setVisibility(View.GONE);
                } else {
                    creditsMenu.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    //method to display icons in the tab layout
    private void setupIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_monument_grey_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_museum_grey_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pastry_grey_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_restaurant_grey_24dp);
    }

    //method that adds the credits objects to the array list
    private void setupCredits(){
        creditsArrayList.add(new Credits("PlanetWare","planetware.com/tourist-attractions-/lisbon-p-lisb-lisb.htm"));
        creditsArrayList.add(new Credits("Deli Portugal","deliportugal.com/compra/pasteis-de-belem-3-pacotes-x-6-uni-459536"));
        creditsArrayList.add(new Credits("Trip Advisor","tripadvisor.com.br/LocationPhotoDirectLink-g189158-d3422202-i75850971-Confeitaria_Cister-Lisbon_Lisbon_District_Central_Portugal.html"));
        creditsArrayList.add(new Credits("CNN","edition.cnn.com/travel/article/lisbon-portugal-pastry-tarts-pastelarias/index.html"));
        creditsArrayList.add(new Credits("Lisbonne-Idee","lisbonne-idee.pt/p3079-rua-garrett-encontra-belas-lojas-antigas-famosos-cafes.html"));
        creditsArrayList.add(new Credits("Restos de Collecção","restosdecoleccao.blogspot.pt/2017/12/"));
        creditsArrayList.add(new Credits("Timeout","timeout.pt/lisboa/pt/museus/os-museus-que-tem-de-visitar-em-lisboa"));
        creditsArrayList.add(new Credits("Facebook","facebook.com/pg/tasquinhadolagarto/about/?ref=page_internal"));
        creditsArrayList.add(new Credits("Solar dos Presuntos","solardospresuntos.com/pt-pt/contactos.aspx"));
        creditsArrayList.add(new Credits("Restaurante Feitoria","restaurantefeitoria.com/"));
        creditsArrayList.add(new Credits("Portugália","portugalia.pt/pt/fale-connosco.html#tm-top-a"));
        creditsArrayList.add(new Credits("Restaurante O Miúdinho","omiudinho.com/contactos"));
        creditsArrayList.add(new Credits("LifeCooler","lifecooler.com/artigo/comer/restaurante-solar-dos-presuntos/330512/"));
        creditsArrayList.add(new Credits("Itinari","itinari.com/location/pastelaria-versailles"));
        creditsArrayList.add(new Credits("Castelo de São Jorge","castelodesaojorge.pt/en/history/"));
        creditsArrayList.add(new Credits("Google Maps","google.com/maps"));
        creditsArrayList.add(new Credits("Wikipedia","wikipedia.org"));
    }
}
