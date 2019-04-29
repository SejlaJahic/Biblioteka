package biblioteka;

import java.util.ArrayList;
import java.util.Date;

public class PodizanjeKnjige {

	protected Racun racun;
	protected Knjiga knjiga;
	protected Date datum;
	
	private int brojac = 0;
	public static ArrayList<PodizanjeKnjige> iznajmljene = new ArrayList<>();
	int brojKnjige;
	
	public PodizanjeKnjige() {

	}

	public PodizanjeKnjige(Racun racun, Knjiga knjiga, Date datum) {
		this.datum = datum;
		this.knjiga = knjiga;
		this.racun = racun;
		iznajmljene.add(brojac,this);
		brojac++;
	}
	
	public  void posudjivanje(Racun racun, Knjiga knjiga) {
	knjiga.posudjena=true;
	Knjiga.knjige.remove(knjiga.brojKnjige);
	Racun.racuni.set(racun.brojPosKnjiga++, racun);
	}
	
	public PodizanjeKnjige(Racun racun) {
		
	}

	public PodizanjeKnjige(Knjiga knjiga) {
		
	}

	public void VracanjeKnjige(Racun racun, Knjiga knjiga, Date datum) {
		knjiga.posudjena=false;
		Knjiga.knjige.add(knjiga);
		iznajmljene.remove(knjiga.brojKnjige);
		Racun.racuni.set(racun.brojPosKnjiga--, racun);
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public static void ispisIznajmljenihKnjiga() {
		if(PodizanjeKnjige.iznajmljene.isEmpty()) {
			System.out.println("Trenutno nijedna knjiga nije iznajmljena!");
		}
		System.out.println("Sljedeæe knjige su iznajmljene: ");
		for(PodizanjeKnjige e : iznajmljene) {
			System.out.println(e);
		}
	}
	@Override
	public String toString() {
		return "PodizanjeKnjige [racun=" + racun + ", knjiga=" + knjiga + ", datum=" + datum + "]";
	}
	
	

}
