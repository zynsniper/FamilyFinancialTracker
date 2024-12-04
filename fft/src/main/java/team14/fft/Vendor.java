package team14.fft;

import java.util.ArrayList;
public class Vendor {
    private String name;
    private Category cat;
    private static ArrayList<Vendor> vendors;

    //Contributing authors: R Legere, O Darrah
    public Vendor(String nameIn, Category catIn){
    	if(vendors == null) {vendors = new ArrayList<Vendor>();}
        name = nameIn;
        cat = catIn;
        vendors.add(this);
    }
    
    public Vendor(String venIn) {
    	if(vendors == null) {vendors = new ArrayList<Vendor>();}
        name = venIn;
        vendors.add(this);
    }

	//Contributing authors: R Legere
    public String getVendor(){
        return name;
    }
    
    //Contributing authors: R Legere
    public void addCategory(Category cat) {
    	this.cat = cat;
    }

    //Contributing authors: R Legere
    public Category getCat(){
    	return cat;
    }
    
    public String toString() {
    	return name;
    }
    
    //Contributing authors: R Legere
    public static Vendor addVendor(String vendorIn) {
    	if(vendors == null) {
    		vendors = new ArrayList<Vendor>();
    		Vendor vendor = new Vendor(vendorIn);
    		return vendor;
    	}
    	else {
    		for(int i=0; i<vendors.size(); i++) {
    			if(vendors.get(i).getVendor() == vendorIn) {return vendors.get(i);}
    		}
    		Vendor vendor = new Vendor(vendorIn);
    		return vendor;
    	}
    }
    
    public static ArrayList<Vendor> getVendors(){
    	return vendors;
    }

    
    
}
