package de.neusta.srp;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import de.neusta.srp.exceptions.GruppeGeschlossenException;

public class GruppenerstellerTest {

	private Gruppenersteller testObject;

	@Before
	public void setup() {
		testObject = new Gruppenersteller("hinz", "kunz");
	}

	@Test
	public void gruppenErstellerHatEineGruppe() throws Exception {
		assertTrue(testObject.getGruppe() != null);
	}

	@Test
	public void erzeugeGruppenid() {
		assertTrue("94db9356f8b48d5a77a6c6297eb59d76".equalsIgnoreCase(testObject.getGruppenId()));
	}

	@Test
	public void gruppenErstellerKannPersonenInGruppeAufnehmen() throws Exception {
		EingeladenePerson personMock = Mockito.mock(EingeladenePerson.class);
		testObject.fuegePersonZuGruppe(personMock);
		assertTrue(testObject.getGruppe().contains(personMock));
	}

	@Test(expected = GruppeGeschlossenException.class)
	public void gruppenErstellerKannGruppeSchließen() throws Exception {
		testObject.schliesseGruppe();
		testObject.fuegePersonZuGruppe(new EingeladenePerson("asd", "bras"));
	}

	@Test
	public void gruppenErstellerKannBestellungPraesentieren() throws Exception {
		EingeladenePerson personMockA = Mockito.mock(EingeladenePerson.class);
		Mockito.when(personMockA.getEssen()).thenReturn("Baguette");
		EingeladenePerson personMockB = Mockito.mock(EingeladenePerson.class);
		Mockito.when(personMockB.getEssen()).thenReturn("Pizza");
		testObject.fuegePersonZuGruppe(personMockA);
		testObject.fuegePersonZuGruppe(personMockB);
		Bestellzettel result = testObject.erzeugeBestellZettel();
		Mockito.verify(personMockA).getEssen();
		Mockito.verify(personMockB).getEssen();
		assertTrue(result.getGerichte().contains("Baguette"));
		assertTrue(result.getGerichte().contains("Pizza"));

	}

}
