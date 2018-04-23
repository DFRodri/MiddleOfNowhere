package com.example.android.middleofnowhere;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.middleofnowhere.CustomClass.Places;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    //ALL HAIL SAINT BUTTERKNIFE!
    //Later findViewById!
    //ButterKnife - http://jakewharton.github.io/butterknife/
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.close)
    ImageView goBack;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.website)
    TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ButterKnife.bind(this);

        //fetch the data of the object passed from a fragment
        final Places currentPlace = this.getIntent().getExtras().getParcelable("selectedPlace");

        //fetch used to populate the views inside the activity_info layout file
        String name = currentPlace.getNewPlaceName();
        title.setText(name);
        int bigImage = currentPlace.getNewImage();
        image.setBackgroundResource(bigImage);
        String info = currentPlace.getNewShortDescription();
        CharSequence convertedInfo = Html.fromHtml(info);
        desc.setText(convertedInfo);
        String realAddress = currentPlace.getNewAddress();
        address.setText(realAddress);
        String phoneNumber = currentPlace.getNewPhoneNumber();
        phone.setText(phoneNumber);
        String website = currentPlace.getNewWebsite();
        //if used to show that in some cases there is no website to display so instead we show a NA
        if (website.equals("NA")) {
            url.setText(website);
        }

        //click listener used to open a website when the user clicks on the website image
        //it makes use of an implicit intent to achieve that
        //it also care that when there is no website, the user gets a "toast warning" about it
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentPlace.getNewWebsite().equals("NA")) {
                    Uri homepage = Uri.parse(currentPlace.getNewWebsite());
                    Intent openLink = new Intent(Intent.ACTION_VIEW, homepage);
                    //to make sure that the user has something to open the urls sent
                    if (openLink.resolveActivity(getPackageManager()) != null) {
                        startActivity(openLink);
                    } else {
                        Toast.makeText(InfoActivity.this, getString(R.string.noAPP), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //click listener to make the user go back to the main activity when he clicks at the close icon
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = NavUtils.getParentActivityIntent(InfoActivity.this);
                NavUtils.navigateUpTo(InfoActivity.this, intent);
                startActivity(intent);
            }
        });

    }
}
