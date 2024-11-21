package fft.src.main.java;
import java.util.ArrayList;

public class Category {
    private final String CAT_NAME;
    private final int PT_MULTIPLIER;
    private ArrayList<Category> categories;

    public Category(String nameIn){
        CAT_NAME = nameIn;
        PT_MULTIPLIER = 1;
        categories.add(this);
    }

    public Category(String nameIn, int ptIn){
        CAT_NAME = nameIn;
        PT_MULTIPLIER = ptIn;
    }

    public String getCat(){
        return CAT_NAME;
    }

    public int getX(){
        return PT_MULTIPLIER;
    }

}
