package biblioteka;

import java.util.ArrayList;

public class Knjiga {

	protected int brojKnjige;
	protected String naziv;
	protected boolean posudjena;

	public static int brojac = 0;
	public static ArrayList<Knjiga> knjige = new ArrayList<>();

	public Knjiga() {

	}

	public Knjiga(int brojKnjige, String naziv, boolean posudjena) {
		this.brojKnjige = brojKnjige;
		this.naziv = naziv;
		this.posudjena = posudjena;

		knjige.add(brojac, this);
		brojac++;
	}

	public Knjiga(int brojKnjige) {

	}

	public int getBrojKnjige() {
		return brojKnjige;
	}

	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public boolean isPosudjena() {
		return posudjena;
	}

	public void setPosudjena(boolean posudjena) {
		this.posudjena = posudjena;
	}

	public static void raspoloziveKnjige() {
		if(Knjiga.knjige.isEmpty()) {
			System.out.println("Trenutno nema raspoloživih knjiga.");
		}
		else {
		System.out.println("Raspoložive knjige su: ");
		for (Knjiga e : knjige) {
			System.out.println(e);
		}
		}
	}

	@Override
	public String toString() {
		return "Knjiga [brojKnjige=" + brojKnjige + ", naziv=" + naziv + ", posudjena=" + posudjena + "]";
	}

}
