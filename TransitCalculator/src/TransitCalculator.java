package src;

import java.util.Arrays;


class TransitCalculator {

	int numberOfRides;	
	double numberOfDays;
	double[] prices = {2.75, 33.00, 127.00};
	String[] pricesNames = {"Pay per day", "7 day unlim", "30 day unlim"};


	
	public TransitCalculator(int myRides, double myDays) {
		numberOfRides = myRides;
		numberOfDays = myDays;
	}
	
	public double unlimited7Price() {
		int numberOf7DayPasses = 1;
		double modula = numberOfDays % 7;
		double divis = numberOfDays / 7;
		
		if(modula != 0 && divis != 1 && numberOfDays / 7 > 1 && numberOfDays / 7 < 2) {
			numberOf7DayPasses = 2;
		}else if(modula != 0 && divis != 2 && numberOfDays / 7 >2 && numberOfDays / 7 < 3){
			numberOf7DayPasses = 3;			
		}else if(modula != 0 && divis != 3 && numberOfDays / 7 >3 && numberOfDays / 7 < 4){
			numberOf7DayPasses = 4;			
		}else if(modula != 0 && divis != 4 && numberOfDays / 7 >4 && numberOfDays / 7 < 5){
			numberOf7DayPasses = 5;			
		}else if(modula == 0 && divis == 1){
			numberOf7DayPasses = 1;			
		}else if(modula == 0 && divis == 2){
			numberOf7DayPasses = 2;			
		}else if(modula == 0 && divis == 3){
			numberOf7DayPasses = 3;			
		}else if(modula == 0 && divis == 4){
			numberOf7DayPasses = 4;			
		}else if(modula == 0 && divis == 5){
			numberOf7DayPasses = 5;			
		}
		double priceOfOneRide = numberOf7DayPasses * prices[1] / numberOfRides;
		return priceOfOneRide;
	}
		
	public double[] getRidePrice() {
		
		double[] priceList;
		
		priceList = new double[3];
		
		priceList[0] = prices[0];
		priceList[1] = prices[2] / numberOfRides;
		priceList[2] = unlimited7Price();
		
		System.out.println(priceList);
		
		return priceList;
		
	}
		
		
	
	public String bestChoice() {
		double[] priceList = getRidePrice();
		
		for (int i = 0; i < 3; i++)   
        {  
            for (int j = i + 1; j < 3; j++)   
            {  
                if (priceList[i] > priceList[j])   
                {  
                    double temp = priceList[i];
                    String tempo = pricesNames[i];
                    priceList[i] = priceList[j];  
                    pricesNames[i] = pricesNames[j];
                    priceList[j] = temp; 
                    pricesNames[j] = tempo;
                }  
            }  
        }  
       return "You should get " + pricesNames[0] + " for " + priceList[0] + " per ride.";  
	}
	

	
	
	public static void main(String[] args){
		TransitCalculator testPerson = new TransitCalculator(5, 19);
		System.out.println(testPerson.unlimited7Price());
		System.out.println(Arrays.toString(testPerson.getRidePrice()));
		System.out.println(testPerson.bestChoice());
		
	}
}
