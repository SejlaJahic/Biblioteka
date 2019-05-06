package biblioteka;

import java.util.Date;
import java.util.Scanner;

public class TestBiblioteka {

	public static void main(String[] args) {
		Scanner skener = new Scanner(System.in);
		int odabir = -1;

		while (odabir != 0) {
			System.out.println("Dobrodo�li," + "\nZa kreiranje novog ra�una, pritisnite 1!"
					+ "\nZa unos nove knjige, pritisnite 2! " + "\nZa podizanje knjige, pritisnite 3! "
					+ "\nZa pregled posu�enih knjiga, pritisnite 4! "
					+ "\nZa pregled raspolo�ivih knjiga, pritisnite 5! " + "\nZa izlaz iz programa pritisnite 0");
			odabir = skener.nextInt();
			switch (odabir) {
			case 1:
				int brojRacuna = Racun.brojac;
				System.out.println("Unesite Va�e ime: ");
				String ime = skener.next();
				Racun racun = new Racun(brojRacuna, ime, 0);
				System.out.println("Uspje�no ste kreirali ra�un! Sa sljede�im ID-om:" + brojRacuna);
				System.out.println("I ostalim parametrima: \n" + racun);
				System.out.println();
				break;

			case 2:
				int brojKnjige = Knjiga.brojac;
				System.out.println("Unesite naziv knjige:");
				skener.nextLine();
				String naziv = skener.nextLine();

				Knjiga knjiga = new Knjiga(brojKnjige, naziv, false);
				System.out.println("Uspje�no ste unijeli knjigu! Sa sljede�im ID-om:" + brojKnjige);
				System.out.println("I ostalim parametrima: \n" + knjiga);
				System.out.println();
				break;

			case 3:
				boolean nastavI = true;
				int brRacuna = 0;
				
				do {
				try {
					System.out.println("Unesite broj ra�una: ");
					brRacuna = skener.nextInt();
					ValidacijaPodizanja brR = new ValidacijaPodizanja();
					if (brR.nepostojeciRacun(Racun.racuni.get(brRacuna))
							|| brR.viseOdTriKnjige(Racun.racuni.get(brRacuna))) {
						System.out
								.println("Ra�un je nepostoje�i ili ra�un ima vi�e od 3 knjige u zajmu. Unesite ponovo");
						brRacuna = skener.nextInt();
					}
					nastavI = false;
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("Unijeli ste nepostoje�u vrijednost!");
				}
				}while(nastavI);
			
				boolean nastavi = true;
				int brKnjige =0;
				do {
				try {
					System.out.println("Unesite broj knjige: ");
					brKnjige = skener.nextInt();
					ValidacijaPodizanja brK = new ValidacijaPodizanja();
					
					if (brK.nepostojecaKnjiga(Knjiga.knjige.get(brKnjige))
							|| brK.knjigaVecIzdata(Knjiga.knjige.get(brKnjige))) {
						System.out.println("Birali ste nepostoje�u knjigu, ili je knjiga ve� izdata, unesite ponovo! ");
						brKnjige = skener.nextInt();
					}
					
					nastavi = false;
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("Unijeli ste nepostoje�u vrijednost!");
				}
				}while(nastavi);
				Date datum = new Date();
				PodizanjeKnjige podizanje = new PodizanjeKnjige(Racun.racuni.get(brRacuna), Knjiga.knjige.get(brKnjige),
						datum);
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
