package de.neusta.srp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import de.neusta.srp.exceptions.GruppeGeschlossenException;

public class Gruppenersteller implements IPerson {

  private List<IPerson> essenGruppe = new ArrayList<IPerson>();
  private boolean gruppeGeschlossen = false;
  private String vorName;
  private String nachname;

  private Gruppenersteller(){
    
  }
  

  public Gruppenersteller(String vorName, String nachName){
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


  public List<IPerson> getGruppe() {
    return essenGruppe;
  }

  public void addPersonZuGruppe(IPerson neuePerson) throws GruppeGeschlossenException {
    if(this.gruppeGeschlossen){
      throw new GruppeGeschlossenException();
    }
    essenGruppe.add(neuePerson);
  }

  public void schließeGruppe() {
    this.gruppeGeschlossen = true;
    
  }

  @Override
  public void speichereEssen() {
    
  }

  @Override
  public void setVorName(String vorName) {
    this.vorName = vorName;
  }

  @Override
  public void setName(String name) {
    this.nachname = name;
  }


  public String getGruppenId() {
    return this.erzeugeGruppenId(vorName.concat(nachname));
  }

  private String erzeugeGruppenId(String text) {
    StringBuilder result = new StringBuilder();
    byte[] digest;
    try {
      digest = MessageDigest.getInstance("MD5").digest(text.getBytes());
    for (byte element : digest) {
      String teil = Integer.toHexString(element & 0xff);
      if (teil.length() == 1) {
        result.append("0");
      }
      result.append(teil);
    }
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return result.toString();
  }
  
}
