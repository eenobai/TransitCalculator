package src;

import java.util.Arrays;


class TransitCalculator {

	int numberOfRides;	
	double numberOfDays;
	double[] pricesNY = {2.75, 33.00, 127.00};
	String[] pricesNames = {"Pay per day", "7 day unlim", "30 day unlim"};
	double[] pricesV = {2.30, 27.00, 110.00};
	String region;

	
	public TransitCalculator(int myRides, double myDays, String myRegions) {
		numberOfRides = myRides;
		numberOfDays = myDays;
		region = myRegions;
	}
	
	public double unlimited7Price() {
		double priceOfOneRide = 0;
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
		
		if(region == "NY") {
			priceOfOneRide = numberOf7DayPasses * pricesNY[1] / numberOfRides;
		}else if(region == "V") {
			priceOfOneRide = numberOf7DayPasses * pricesV[1] / numberOfRides;
		}
		
		
		return priceOfOneRide;
	}
		
	public double[] getRidePrice() {
		
		double[] priceList;
		
		priceList = new double[3];
		
		priceList[0] = pricesNY[0];
		priceList[1] = pricesNY[2] / numberOfRides;
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
		if(region == "NY" || region == "V") {
       return "You've selected "+ region + " region. " + "You should get " + pricesNames[0] + " for " + priceList[0] + " per ride.";
       } else { return "Specified region doesnt exist";}  
	}
	

	
	
	public static void main(String[] args){
		TransitCalculator testPerson = new TransitCalculator(40, 19, "V");
		TransitCalculator testPerson2 = new TransitCalculator(69, 24, "NY");
		System.out.println(testPerson.unlimited7Price());
		System.out.println(Arrays.toString(testPerson.getRidePrice()));
		System.out.println(testPerson.bestChoice());
		System.out.println(testPerson2.bestChoice());
		
	}
}
