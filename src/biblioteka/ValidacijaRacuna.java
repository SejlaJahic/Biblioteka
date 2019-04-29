package biblioteka;

public class ValidacijaRacuna extends Racun{

	
	public ValidacijaRacuna(int brojRacuna) {
		super(brojRacuna);
	}
	
	public boolean postojiRacun(int brojRacuna) {
		for(int i=0; i<Racun.racuni.size(); i++) {
			if(Racun.racuni.get(i).brojRacuna==brojRacuna) {
				return true;
			}
		}
		return false;
	}
	
	public boolean negativanBroj(int brojRacuna) {
		if(brojRacuna<0) {
			return true;
		}
		return false;
	}
}
