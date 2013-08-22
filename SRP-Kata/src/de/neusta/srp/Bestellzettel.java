package de.neusta.srp;

import java.util.ArrayList;
import java.util.List;

public class Bestellzettel {
  private List<String> alleGerichte = new ArrayList<String>();

  public List<String> getGerichte() {
    return alleGerichte;
  }

  public void fuegeGerichtHinzu(String essen) {
    alleGerichte.add(essen);
  }
}
