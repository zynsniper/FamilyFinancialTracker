package team14.fft;

import java.util.ArrayList;
public class Vendor {
    private final String VENDOR_NAME;
    private final Category CATEGORY;
    private ArrayList<Vendor> vendors;

    //Contributing authors: R Legere
    public Vendor(String nameIn, Category catIn){
        VENDOR_NAME = nameIn;
        CATEGORY = catIn;
        vendors.add(this);
    }


	//Contributing authors: R Legere
    public String getVendor(){
        return VENDOR_NAME;
    }

    //Contributing authors: R Legere
    public Category getCat(){
        return CATEGORY;
    }
}
