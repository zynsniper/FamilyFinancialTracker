package team14.fft;

import java.util.ArrayList;
public class Vendor {
    private final String VENDOR_NAME;
    private final Category CATEGORY;
    private ArrayList<Vendor> vendors;

    public Vendor(String nameIn, Category catIn){
        VENDOR_NAME = nameIn;
        CATEGORY = catIn;
        vendors.add(this);
    }

    public String getVendor(){
        return VENDOR_NAME;
    }

    public Category getCat(){
        return CATEGORY;
    }
}
