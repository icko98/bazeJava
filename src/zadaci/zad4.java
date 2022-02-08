package zadaci;

import java.sql.SQLException;
import java.util.List;

import dto.Zad4dto;
import model.Akcija;
import model.Konfiguracija;
import model.Racunar;
import service.ZadService;

public class zad4 {
	private static final ZadService zadService = new ZadService();
	
	
	public void zadCETIRI() {
		try {
			List<Zad4dto> dtos = zadService.getZad4dto();
			if(!dtos.isEmpty()) {
				for(Zad4dto dto:dtos) {
					System.out.println(dto.getKomponenta());
					System.out.println("Broj racunara: " + dto.brojRac());
					List<Racunar> racunari = dto.getRacunari();
					List<Konfiguracija> konfig = dto.getKonfiguracije();
					int akcija = 0;
					
					for(Racunar r:racunari) {
						System.out.println(r.toString());
						for(Konfiguracija k:konfig) {
							if(r.getIDR()==k.getIDR()) {
								System.out.println("Broj komponenti za ovaj racunar: "+ k.getKOMADA());
								
								if(dto.getAkcija()!=null) {
									akcija = dto.getAkcija().getPOPUST();
								} else {
									akcija=0;
								}
								
								double cena = dto.getKomponenta().getCENA();
								cena = cena * ((100-akcija)/100.0) * k.getKOMADA() ;
								System.out.println("Cena za komponente: " + cena);
							}
						}
					}
					System.out.println("---------------------------");
					
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public zad4() {
		// TODO Auto-generated constructor stub
	}

}
