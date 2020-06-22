package src;
class TransitCalculator {

	int numberOfRides;	
	double numberOfDays;
	double[] prices = {2.75, 33.00, 127.00};


	
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
	
	
	public static void main(String[] args){
		TransitCalculator testPerson = new TransitCalculator(20, 19);
		System.out.println(testPerson.unlimited7Price());
	}
}
