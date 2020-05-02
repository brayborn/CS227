package src;
/**
 * Class to represent smart robots.  Smart robots will not collide with
 * rubble or other robots (however, other robots can collide with smart
 * robots.
 */
public class SmartRobot extends Robot {

  /**
   * Stringifies a smart robot
   *
   * @return The stringified robot
   */
  @Override
  public String toString()
  {
    return "S";
  }

  /**
   * Constructs a new smart robot at position (x, y)
   *
   * @param x The x position of the robot
   * @param y The y position of the robot
   */
  public SmartRobot(int x, int y)
  {
    super(x, y);
  }

  /**
   * TODO: Smart robots move toward the PC is at least one dimension, both if
   * possible, but only if there exists a move which doesn't result in a
   * collision.  A smart robot will never collide with obstrutions or other
   * robots.  It can get stuck behind an obstruction (or, optionally, you can
   * implement some more intelligent pathfinding around obsructions, but that
   * is harder to code, and make an already very hard game harder, as well).
   *
   * @param t The tableau
   * @return The new position
   */
  public Pair moveTo(Tableau t) {

	  //new positions to go to
	  int newX = 0;
	  int newY = 0;
	  
	  //gets the coordinates of the player
	  int playerX = t.getPC().getX();
	  int playerY = t.getPC().getY();
	  
	  //determine which way to move, checking if space is occupied
	  if(playerX > getX()) {
		  if(t.getCell(getX() + 1, getY()) == null) {
		  newX = getX() + 1;
		  }
	  }else if(playerX < getX()) {
		  if(t.getCell(getX() - 1, getY()) == null) {
		  newX = getX() - 1;
		  }
	  }else {
		  newX = getX();
	  }
	  if(playerY > getY()) {
		  if(t.getCell(getX(),  getY() + 1) == null) {
		  newY = getY() + 1;
		  }
	  }else if(playerY < getY()) {
		  if(t.getCell(getX(),  getY() - 1) == null) {
		  newY = getY() - 1;
		  }
	  }else {
		  newY = getY();
	  }
	  
	  t.moveCharacter(getX(), getY(), newX, newY);
	  Pair goTo = new Pair(newX, newY);
	  
	  return goTo;
  }
}
