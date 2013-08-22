package de.neusta.srp;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EingeladenePersonTest {

  private EingeladenePerson testObject;

  @BeforeMethod
  public void setup() {
    testObject = new EingeladenePerson("hurz","schaaf");
  }

  @Test
  public void personIstGruppenMitglied() throws Exception {
    assertTrue(testObject.getGruppenMitGliedSchaft() != null);
  }
  
}
