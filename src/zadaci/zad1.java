package zadaci;

import java.sql.SQLException;
import java.util.List;

import dto.Zad1dto;
import model.Konfiguracija;
import service.ZadService;

public class zad1 {

	private static final ZadService zadService = new ZadService();
	public void zadJEDAN() {
		try {
			List<Zad1dto> dtos = zadService.getZad1dto();
			if(!dtos.isEmpty()) {
				for(Zad1dto dto:dtos) {
					//System.out.println(dto.getKonfiguracije());
					System.out.println("---------------------------");
					
					if(!dto.getKonfiguracije().isEmpty()) {
						//System.out.println("\t\t" + Konfiguracija.toString());
						for(Konfiguracija konfiguracija : dto.getKonfiguracije()) {
							System.out.println("\t\t" + konfiguracija);
						}
					} else {
						System.out.println("\t\tNEMA KONFIG");
					}
					System.out.println("\t\t -------------------------");
					System.out.println();
				}
			} else {
				System.out.println("\t\tNEMA KONFIG");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void zadDVA(int id) {
		try{
			zadService.deleteKonfig(id);
			zadService.deleteKomponent(id);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
