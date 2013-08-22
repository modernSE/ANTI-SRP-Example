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
    Gruppenersteller gruppenErsteller = new Gruppenersteller("ein", "zwei");
    gruppenErsteller.fuegePersonZuGruppe(testObject);
    assertTrue("5fdc1badf4d99f7df75d56d6d9a0beab".equalsIgnoreCase(testObject.getGruppenMitgliedschaft()));
  }
  
  @Test
  public void personFuegtEssenHinzu() throws Exception {
    testObject.waehleEssen("Baguette");
    assertTrue("Baguette".equalsIgnoreCase(testObject.getEssen()));
  }
  
}
