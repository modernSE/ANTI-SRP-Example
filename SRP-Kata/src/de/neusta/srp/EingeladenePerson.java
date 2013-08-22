package de.neusta.srp;

public class EingeladenePerson implements IPerson {

  private String gruppenId;
  private String vorName;
  private String nachname;
  private String essen;

  private EingeladenePerson() {

  }

  public EingeladenePerson(String vorName, String nachName) {
    this.vorName = vorName;
    this.nachname = nachName;
  }

  @Override
  public String getVorName() {
    return this.vorName;
  }

  @Override
  public String getName() {
    return this.nachname;
  }

  @Override
  public void speicherePerson() {
    
  }

  public String getGruppenMitgliedschaft() {
    return gruppenId;
  }

  @Override
  public void setVorName(String vorName) {
    this.vorName = vorName;
  }

  @Override
  public void setName(String name) {
    this.nachname = name;
  }

  @Override
  public void waehleEssen(String essen) {
    this.essen = essen;
  }

  @Override
  public String getEssen() {
    return this.essen;
  }

  public void setzeGruppenMitgliedschaft(String gruppenId) {
    this.gruppenId = gruppenId;
  }

}
