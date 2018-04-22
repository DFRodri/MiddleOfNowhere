package com.example.android.middleofnowhere.CustomClass;

/**
 * Custom Class to create the custom Object Credits that hold two elements
 * @Param creditName - name of the website
 * @Param creditURL - url of the website
 **/
public class Credits {

    private final String newCreditName;
    private final String newCreditURL;

    //constructor needed to create the custom Object
    public Credits(String creditName, String creditURL) {
        newCreditName = creditName;
        newCreditURL = creditURL;
    }

    //get methods to retrieve their values
    public String getNewCreditName() {
        return newCreditName;
    }

    public String getNewCreditURL() {
        return newCreditURL;
    }

}
