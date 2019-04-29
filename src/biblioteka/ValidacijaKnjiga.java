package biblioteka;

public class ValidacijaKnjiga extends Knjiga {

	public ValidacijaKnjiga(int brojKnjige) {
		super(brojKnjige);
	}
	
	public boolean postojeciID(int brojKnjige) {
		for(int i=0; i<Knjiga.knjige.size();i++) {
			if(Knjiga.knjige.get(i).brojKnjige == brojKnjige) {
				return true;
			}
		}
		return false;
	}
	
	public boolean negativanID(int brojKnjige) {
		if(brojKnjige<0) {
			return true;
		}
		return false;
	}
}
