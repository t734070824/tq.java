package _old.factory.github.abstractfactory;
/**
 * 
 * OrcCastle
 *
 */
public class OrcCastle implements Castle {

  static final String DESCRIPTION = "This is the Orc castle!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
