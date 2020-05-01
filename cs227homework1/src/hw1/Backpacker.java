package cs227homework1;

public class Backpacker {
	
	/**
	 * the constant multiplier for gaining money from home
	 * the parents give this many euros per postcard received
	 */
	public static final int SYMPATHY_FACTOR = 30;
	
	/**
	 * money the backpacker currently has
	 */
	public int money;
	
	/**
	 * the number of postcards the backpacker has sent home
	 * multiplied by the SYMPATHY_FACTOR to get money from parents
	 */
	public int postcardsSent = 0;
	
	/**
	 * the current city the backpacker is in
	 */
	public City currCity;
	
	/**
	 * a log of cities visited and how long the backpacker was there
	 * formatted as City(nights spent)
	 */
	public String journal;
	
	/**
	 * the nights the backpacker is spending in the current city
	 */
	public int nights;
	
	/**
	 * the number of nights the backpacker is spending in the train station
	 * if the backpacker cannot afford to stay in a hostel for the entire visit to the city, the remaining nights are spent in the train station
	 */
	public int nightsStation;
	
	/**
	 * the number of nights the backpacker is spending in a hostel
	 * the backpacker will only spend nights in a hostel if they can afford to
	 */
	public int nightsHostel;
	
	
	/**
	 * a backpacker that visits different cities for a given amount of time
	 * @param initialFunds the money the backpacker starts the trip with
	 * @param initialCity the city the backpacker starts the trip in
	 */
	public Backpacker(int initialFunds, City initialCity) {
		money = initialFunds;
		currCity = initialCity;
		journal = currCity.getCityName() + "(start)";
	}

	/**
	 * Gets the city that the backpacker is currently in
	 * @return the City object of the city that the backpacker is currently in
	 */
	public City getCurrentCityName() {
		return currCity;
	}

	/**
	 * Gets the name of the city that the backpacker is currently in
	 * @return the name of the current city
	 */
	public String getCurrentCity(){
		return currCity.getCityName();
	}
	
	/**
	 * Gets the current amount of money the backpacker has
	 * @return current amount of money
	 */
	public int getCurrentMoney() {
		return money;
	}
	/**
	 * returns the journal containing a log of cities and nights spent in them
	 * @return city(nights spent)
	 */
	public String getJournal() {
		return journal;
	}
	
	/**
	 * determines if the backpacker is able to send a postcard
	 * @return true if unable to send a postcard
	 */
	public boolean isSOL() {
		if(money < currCity.postcardCost()){
		return true;
		} else{
		return false;
		}
	}

	/**
	 * backpacker can only stay in a hostel if they can afford to, excess nights in town are spent at the train station
	 * @return nights in the train station
	 */
	public int getNightsInStation() {
		nightsStation += (nights - nightsHostel);
		return nightsStation;
	}
	
	/**
	 * backpacker goes to a different city for a specified number of nights
	 * spends as many nights in a hostel as their money will allow
	 * updates the journal to include the stay in the city as well as the days spent this time
	 * @param c the city being visited
	 * @param numNights the number of nights in the city
	 */
	public void visit(City c, int numNights) {
		currCity = c;
		nights = numNights;
		nightsHostel = (Math.min(currCity.nightsStay(money), nights));
		money = money - (Math.min(currCity.nightsStay(money), nights) * currCity.hostelCost());
		journal = journal.concat(", " + currCity.getCityName() + "(" + nights + ")");
	}
	
	/**
	 * sends a postcard home to gain sympathy from parents to get money in the future
	 * only sends postcards the backpacker can afford
	 * @param howMany number of postcards attempting to be sent
	 */
	public void sendPostcardsHome(int howMany) {
		int thisSend;
		thisSend = Math.min(howMany, money / currCity.postcardCost());
		postcardsSent += thisSend;
		money -= thisSend * currCity.postcardCost();
	}
	
	/**
	 * calls home to get money directly proportional to the number of postcards they have sent
	 */
	public void callHomeForMoney() {
		money += postcardsSent * SYMPATHY_FACTOR;
		postcardsSent = 0;
	}

}
