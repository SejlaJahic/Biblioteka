package biblioteka;

import java.util.ArrayList;

public class Racun {

	protected int brojRacuna;
	protected String ime;
	protected int brojPosKnjiga;

	private int brojac = 0;
	public static ArrayList<Racun> racuni = new ArrayList<>();

	public Racun() {

	}

	public Racun(int brojRacuna, String ime, int brojPosKnjiga) {
		this.brojRacuna = brojRacuna;
		this.ime = ime;
		this.brojPosKnjiga = brojPosKnjiga;
		
		racuni.add(brojac,this);
		brojac++;
	}

	public Racun(int brojRacuna) {
		
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getBrojPosKnjiga() {
		return brojPosKnjiga;
	}

	public void setBrojPosKnjiga(int brojPosKnjiga) {
		this.brojPosKnjiga = brojPosKnjiga;
	}

	@Override
	public String toString() {
		return "Racun [brojRacuna=" + brojRacuna + ", ime=" + ime + ", brojPosKnjiga=" + brojPosKnjiga + "]";
	}
	
	

}
