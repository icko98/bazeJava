package dao;

import java.sql.SQLException;
import java.util.List;

import model.Konfiguracija;

public interface KonfiguracijaDAO extends CRUDDao<Konfiguracija, Integer> {

	public List<Konfiguracija> findKonfiguracijaByRacunar(Integer idRacunar) throws SQLException;

	public List<Konfiguracija> findKonfiguracijaByKomponenta(Integer id) throws SQLException;
}
