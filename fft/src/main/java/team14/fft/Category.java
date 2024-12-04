package team14.fft;

import java.util.ArrayList;

public class Category {
    private String catName;
    private final double PT_MULTIPLIER;
    private static ArrayList<Category> categories;
    
    //Contributing authors: R Legere
    public Category(String nameIn){
    	catName = nameIn;
        PT_MULTIPLIER = 1;
        categories = new ArrayList<>();
    	categories.add(new Category("Grocery", 0.3));
    	categories.add(new Category("Gas", 0.2));
    	categories.add(new Category("Dining", 0.5));
    	categories.add(new Category("Recurring", 0.4));
    	categories.add(new Category("Other", 0.1));
    }
    
    //Contributing authors: R Legere, CS Cheang
    public Category(String nameIn, double ptIn){
    	catName = nameIn;
        PT_MULTIPLIER = ptIn;
    }

    //Contributing authors: R Legere, CS Cheang
    public String getCategory(){
        return catName;
    }
    
    //Contributing authors: R Legere
    public double getX(){
        return PT_MULTIPLIER;
    }
  
    //Contributing authors: R Legere, CS Cheang
    public static Category findCategory(String name) {
        for (Category cat : categories) {
            if (cat.getCategory().equalsIgnoreCase(name)) {
                return cat;
            }
        }
        return new Category("Unassigned Category");
    }
    
   //Contributing authors: R Legere, CS Cheang
   @Override
   public String toString() {
	   return catName;
   }
}
