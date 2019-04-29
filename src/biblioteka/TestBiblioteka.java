package biblioteka;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TestBiblioteka {

	public static void main(String[] args) {
		Scanner skener = new Scanner(System.in);
		int odabir = -1;
		
		while(odabir!=0) {
			System.out.println("Dobrodo�li,"
					+ "\nZa kreiranje novog ra�una, pritisnite 1!"
					+ "\nZa unos nove knjige, pritisnite 2! "
					+ "\nZa podizanje knjige, pritisnite 3! "
					+ "\nZa pregled posu�enih knjiga, pritisnite 4! "
					+ "\nZa pregled raspolo�ivih knjiga, pritisnite 5! "
					+ "\nZa izlaz iz programa pritisnite 0");
			odabir = skener.nextInt();
			switch(odabir) {
			case 1:
				System.out.println("Unesite broj racuna: ");
				int brojRacuna = skener.nextInt();
				ValidacijaRacuna brRa = new ValidacijaRacuna(brojRacuna);
				if(brRa.postojiRacun(brojRacuna) || brRa.negativanBroj(brojRacuna)) {
					System.out.println("Ra�un ve� postoji ili ste unijeli negativan broj, unesite ponovo: ");
					brojRacuna = skener.nextInt();
				}
				
				System.out.println("Unesite Va�e ime: ");
				String ime = skener.next();	
				
				Racun racun = new Racun(brojRacuna, ime, 0);
				System.out.println("Uspje�no ste kreirali ra�un!");
				break;
				
			case 2:
				System.out.println("Unesite ID knjige: ");
				int brojKnjige = skener.nextInt();
				ValidacijaKnjiga brKnj = new ValidacijaKnjiga(brojKnjige);
				if(brKnj.postojeciID(brojKnjige)|| brKnj.negativanID(brojKnjige)) {
					System.out.println("Taj ID ve� postoji, ili ste unijeli negativan ID, unesite ponovo:");
					brojKnjige = skener.nextInt();
				}
				System.out.println("Unesite naziv knjige:");
				skener.nextLine();
				String naziv = skener.nextLine();
				
				Knjiga knjiga = new Knjiga(brojKnjige,naziv,false);
				System.out.println("Uspje�no ste unijeli knjigu!");
				System.out.println();
				break;
				
			case 3:
				System.out.println("Unesite broj ra�una: ");
				int brRacuna = skener.nextInt();
				ValidacijaPodizanja brR = new ValidacijaPodizanja();
				if (brR.nepostojeciRacun(Racun.racuni.get(brRacuna))|| brR.viseOdTriKnjige(Racun.racuni.get(brRacuna))) {
					System.out.println("Ra�un je nepostoje�i ili ra�un ima vi�e od 3 knjige u zajmu. Unesite ponovo");
					brRacuna = skener.nextInt();
				}
				
				System.out.println("Unesite broj knjige: ");
				int brKnjige = skener.nextInt();
				ValidacijaPodizanja brK = new ValidacijaPodizanja();
				if(brK.nepostojecaKnjiga(Knjiga.knjige.get(brKnjige)) || brK.knjigaVecIzdata(Knjiga.knjige.get(brKnjige))) {
					System.out.println("Birali ste nepostoje�u knjigu, ili je knjiga ve� izdata, unesite ponovo! ");
					brKnjige = skener.nextInt();
				}
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date datum = new Date();
				PodizanjeKnjige podizanje = new PodizanjeKnjige(Racun.racuni.get(brRacuna),Knjiga.knjige.get(brKnjige), datum);
				podizanje.posudjivanje(Racun.racuni.get(brRacuna), Knjiga.knjige.get(brKnjige));
				System.out.println("Uspje�no ste posudili knjigu!");
				System.out.println();
				break;
				
			case 4:
				PodizanjeKnjige.ispisIznajmljenihKnjiga();
				System.out.println();
				break;
			case 5:
		
				Knjiga.raspoloziveKnjige();
				System.out.println();
				break;
			}
		}
		skener.close();
	}

}
