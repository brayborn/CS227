package cs227homework1;

public class City {
	
	/**
	 * the multiplier to get the cost of a postcard in a given city
	 * postcards cost a night in a hostel times POSTCARD_COST
	 */
	public static final double POSTCARD_COST = 0.05;
	
	/**
	 * the name of the current city
	 */
	public String cityName;
	
	/**
	 * the cost of a night in a hostel in the current city
	 */
	public int hostelCost;
	
	/**
	 * the cost of a postcard in the current city
	 */
	public int cityPostcard;
	
	/**
	 * the number of nights spent in a hostel
	 * any nights in a city that the backpacker cannot afford a hostel are spent at the train station
	 */
	public int hostelNights;
	
	/**
	 * the nights the backpacker is spending in a hostel
	 * @param givenCityName the city the backpacker is spending the night in a hostel in
	 * @param givenHostelCost the cost per night for a hostel in the current city
	 */
	
	/**
	 * a city that the backpacker can visit
	 * @param givenCityName the name of the city 
	 * @param givenHostelCost the cost for a night in a hostel in the city
	 */
	public City(String givenCityName, int givenHostelCost) {
		cityName = givenCityName;
		hostelCost = givenHostelCost;
	}
	
	/**
	 * method to get the name of the current city
	 * @return the name of the city
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * method to get the cost of a night in a hostel in the current city
	 * @return the cost of a night in a hostel
	 */
	public int hostelCost() {
		return hostelCost;
	}
	
	/**
	 * method to calculate the cost of a postcard in the current city
	 * cost is a night in the hostel times the percentage POSTCARD_COST
	 * @return the cost of a postcard from the current city
	 */
	public int postcardCost() {
		
		cityPostcard = (int) Math.round(hostelCost * POSTCARD_COST);
		return cityPostcard;
	}
	
	/**
	 * method to determine the number of nights in a hostel the backpacker can afford
	 * @param moneyAvailable the money the backpacker currently has
	 * @return the number of nights in a hostel the backpacker can afford
	 */
	public int nightsStay(int moneyAvailable) {
		hostelNights = (int) (moneyAvailable / hostelCost);
		return hostelNights;
	}

	/**
	 * method to calculate the number of postcards the backpacker can send with the money they have
	 * @param moneyAvailable the current amount of money the backpacker has
	 * @return the number of postcards the backpacker can afford to send
	 */
	public int numPostcards(int moneyAvailable) {
		return (int) (moneyAvailable / cityPostcard);
	}
	
}
