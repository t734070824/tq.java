package _old.factory.github.abstractfactory;

/**
 * 
 * OrcArmy
 *
 */
public class OrcArmy implements Army {

  static final String DESCRIPTION = "This is the Orc Army!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}