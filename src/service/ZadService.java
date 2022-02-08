package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AkcijaDAO;
import dao.KomponentaDAO;
import dao.KonfiguracijaDAO;
import dao.RacunarDAO;
import daoImplement.AkcijaDAOImpl;
import daoImplement.KomponentaDAOImpl;
import daoImplement.KonfiguracijaDAOImpl;
import daoImplement.RacunarDAOImpl;
import dto.Zad1dto;
import dto.Zad4dto;
import model.Komponenta;
import model.Racunar;

public class ZadService {
	private static final AkcijaDAO akcijaDAO = new AkcijaDAOImpl();
	private static final KonfiguracijaDAO konfiguracijaDAO = new KonfiguracijaDAOImpl();
	private static final RacunarDAO racunarDAO = new RacunarDAOImpl();
	private static final KomponentaDAO komponentaDAO = new KomponentaDAOImpl();
	

	public ZadService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Zad1dto> getZad1dto() throws SQLException{
		List<Zad1dto> ret = new ArrayList<Zad1dto>();
		for(Racunar r: racunarDAO.findAll()) {
			Zad1dto dto = new Zad1dto();
			dto.setRacunar(r);
			dto.setKonfiguracije(konfiguracijaDAO.findKonfiguracijaByRacunar(r.getIDR()));
			ret.add(dto);
		}
		return ret;
	}
	public boolean deleteKomponent(int id) throws SQLException{
		return komponentaDAO.deleteById(id);
	}
	
	public boolean deleteKonfig(int id) throws SQLException{
		return konfiguracijaDAO.deleteById(id);
	}
	public List<Zad4dto> getZad4dto() throws SQLException{
		List<Zad4dto> ret = new ArrayList<Zad4dto>();
		for(Komponenta k: komponentaDAO.findAll()) {
			Zad4dto dto = new Zad4dto();
			dto.setKomponenta(k);
			dto.setKonfiguracije(konfiguracijaDAO.findKonfiguracijaByKomponenta(k.getIDK()));
			// OVDE SET RACUANRE
			dto.setRacunari(racunarDAO.findRacunarByKomponenta(k.getIDK()));
			dto.setAkcija(akcijaDAO.findById(k.getAKC()));
			ret.add(dto);
		}
		return ret;
	}

}
