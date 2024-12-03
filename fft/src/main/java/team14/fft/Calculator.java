package team14.fft;

import java.util.ArrayList;

public class Calculator {
	
	//Contributing authors: R Legere
	public static double calcBalChange(ArrayList<Transaction> transactions) {
		double sum = 0;
		for(int i=0; i<transactions.size(); i++) {
			sum += transactions.get(i).getTotal();
		}
		return sum;
	}
	
	//Contributing authors: R Legere
	public static double calcCredits(ArrayList<Transaction> transactions) {
		double sum = 0;
		for(int i=0; i<transactions.size(); i++) {
			if(!transactions.get(i).isDebit()) {
				sum += transactions.get(i).getTotal();
			}
		}
		return sum;
	}
	
	//Contributing authors: R Legere
	public static double calcDebits(ArrayList<Transaction> transactions) {
		double sum = 0;
		for(int i=0; i<transactions.size(); i++) {
			if(transactions.get(i).isDebit()) {
				sum += transactions.get(i).getTotal();
			}
		}
		return Math.abs(sum);
	}
	
	//Contributing authors: R Legere
	public static int calcRewardPts(ArrayList<Transaction> transactions) {
		int pts = 0;
		for(int i=0; i<transactions.size(); i++) {
			pts+= transactions.get(i).calcRewardPt();
		}
		return pts;
	}
}
