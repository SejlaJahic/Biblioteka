package biblioteka;


public class ValidacijaPodizanja {

	Racun racun;
	Knjiga knjiga;

	public ValidacijaPodizanja() {
		
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

	public boolean viseOdTriKnjige(Racun racun) {
		if (racun.brojPosKnjiga > 3) {
			return true;
		}
		return false;
	}

	public boolean knjigaVecIzdata(Knjiga knjiga) {
		if (knjiga.posudjena) {
			return true;
		}
		return false;
	}

	public boolean nepostojeciRacun(Racun racun) {
		for (int i = 0; i < Racun.racuni.size(); i++) {
			if (Racun.racuni.get(i).brojRacuna == racun.brojRacuna) {
				return false;
			}
		}
		return true;
	}

	public boolean nepostojecaKnjiga(Knjiga knjiga) {
		for (int i = 0; i < Knjiga.knjige.size(); i++) {
			if (Knjiga.knjige.get(i).brojKnjige == knjiga.brojKnjige) {
				return false;
			}

		}
		return true;
	}
}
