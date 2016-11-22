package de.neusta.srp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import de.neusta.srp.exceptions.GruppeGeschlossenException;

public class Gruppenersteller implements IPerson {

	private String essen;
	private List<IPerson> essenGruppe = new ArrayList<IPerson>();
	private boolean gruppeGeschlossen = false;
	private String vorName;
	private String nachname;

	private Gruppenersteller() {

	}

	public Gruppenersteller(String vorName, String nachName) {
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

	public void fuegePersonZuGruppe(EingeladenePerson neuePerson) throws GruppeGeschlossenException {
		if (this.gruppeGeschlossen) {
			throw new GruppeGeschlossenException();
		}
		essenGruppe.add(neuePerson);
		neuePerson.setzeGruppenMitgliedschaft(this.getGruppenId());
	}

	public void schliesseGruppe() {
		this.gruppeGeschlossen = true;

	}

	@Override
	public void speicherePerson() {

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
			e.printStackTrace();
		}
		return result.toString();
	}

	@Override
	public String getEssen() {
		return this.essen;
	}

	@Override
	public void waehleEssen(String essen) {
		this.essen = essen;
	}

	public Bestellzettel erzeugeBestellZettel() {
		Bestellzettel result = new Bestellzettel();
		for (IPerson esser : essenGruppe) {
			result.fuegeGerichtHinzu(esser.getEssen());
		}
		return result;
	}

}
