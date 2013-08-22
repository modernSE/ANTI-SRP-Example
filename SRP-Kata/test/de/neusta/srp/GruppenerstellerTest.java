package de.neusta.srp;

import static org.testng.AssertJUnit.assertTrue;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.neusta.srp.exceptions.GruppeGeschlossenException;

public class GruppenerstellerTest {

  private Gruppenersteller testObject;

  @BeforeMethod
  public void setup() {
    testObject = new Gruppenersteller("hinz","kunz");
  }

  @Test
  public void gruppenErstellerHatEineGruppe() throws Exception {
    assertTrue(testObject.getGruppe() != null);
  }
  
  @Test
  public void erzeugeGruppenid(){
    assertTrue("94db9356f8b48d5a77a6c6297eb59d76".equalsIgnoreCase(testObject.getGruppenId()));
  }
 
  
  @Test
  public void gruppenErstellerKannPersonenInGruppeAufnehmen() throws Exception {
    IPerson personMock = Mockito.mock(IPerson.class);
    testObject.addPersonZuGruppe(personMock);
    assertTrue(testObject.getGruppe().contains(personMock));
  }

  @Test (expectedExceptions=GruppeGeschlossenException.class)
  public void gruppenErstellerKannGruppeSchließen() throws Exception{
    testObject.schließeGruppe();
    testObject.addPersonZuGruppe(new EingeladenePerson("asd","bras"));
  }
}
