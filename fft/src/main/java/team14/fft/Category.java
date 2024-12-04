package team14.fft;
import java.util.ArrayList;

public class Category {
    private final String CAT_NAME;
    private final int PT_MULTIPLIER;
    private static ArrayList<Category> categories;
    
    //Contributing authors: R Legere
    public Category(String nameIn){
    	if(categories == null) {categories = new ArrayList<Category>();}
        CAT_NAME = nameIn;
        PT_MULTIPLIER = 1;
        categories.add(this);
    }
    //Contributing authors: R Legere
    public Category(String nameIn, int ptIn){
        CAT_NAME = nameIn;
        PT_MULTIPLIER = ptIn;
    }
    //Contributing authors: R Legere
    public String toString(){
        return CAT_NAME;
    }
    //Contributing authors: R Legere
    public int getX(){
        return PT_MULTIPLIER;
    }
    
    public static ArrayList<Category> getCats(){
    	return categories;
    }

}
