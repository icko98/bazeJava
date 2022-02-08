package dao;

import java.sql.SQLException;
import java.util.List;

import model.Racunar;

public interface RacunarDAO extends CRUDDao<Racunar, Integer> {

	int count() throws SQLException;

	boolean delete(Racunar entity) throws SQLException;

	int deleteAll() throws SQLException;

	boolean deleteById(Integer id) throws SQLException;

	boolean existsById(Integer id) throws SQLException;

	Iterable<Racunar> findAllById(Iterable<Integer> ids) throws SQLException;

	Iterable<Racunar> findAll() throws SQLException;

	Racunar findById(Integer id) throws SQLException;

	boolean save(Racunar entity) throws SQLException;

	int saveAll(Iterable<Racunar> entities) throws SQLException;
	
	List<Racunar> findRacunarByKomponenta(Integer id) throws SQLException;

}
