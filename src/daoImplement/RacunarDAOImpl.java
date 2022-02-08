package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil_HikariCP;
import dao.RacunarDAO;
import model.Konfiguracija;
import model.Racunar;

public class RacunarDAOImpl implements RacunarDAO {

	
	@Override
	public int count() throws SQLException {
		String query = "select count(*) from racunar";
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection() ;
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()){
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return -1;
			}
		}
	}

	
	@Override
	public boolean delete(Racunar entity) throws SQLException {
		return deleteById(entity.getIDR());
	}

	@Override
	public int deleteAll() throws SQLException {
		String query = "delete from racunar";
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			int rowsAfffected = preparedStatement.executeUpdate();
			return rowsAfffected;
		}
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		String query = "delete from racunar where idr=?";
		
		try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		try(Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			return existsByIdTransactional(connection, id);
		}
	}
	private boolean existsByIdTransactional(Connection connection, Integer id) throws SQLException {
		String query = "select * from racunar where IDR=?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.isBeforeFirst();
			}
		}
	}

	@Override
	public Iterable<Racunar> findAll() throws SQLException {
		String query = "select IDR,NAZIVR from racunar";
		List<Racunar> racunarList = new ArrayList<Racunar>();
		Connection connection = ConnectionUtil_HikariCP.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				Racunar racunar = new Racunar(resultSet.getInt(1), resultSet.getString(2));
				racunarList.add(racunar);
			}

		}
		return racunarList;
	}

	@Override
	public Iterable<Racunar> findAllById(Iterable<Integer> ids) throws SQLException {
		List<Racunar> racunarList = new ArrayList<>();

		StringBuilder stringBuilder = new StringBuilder();

		String queryBegin = "select idr, nazivr from racunar where idr in(";
		stringBuilder.append(queryBegin);

		for (@SuppressWarnings("unused")
		Integer id : ids) {
			stringBuilder.append("?,");
		}

		stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
		stringBuilder.append(")");

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());) {

			int i = 0;
			for (Integer id : ids) {
				preparedStatement.setInt(++i, id);
			}

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					racunarList.add(new Racunar(resultSet.getInt(1), resultSet.getString(2)));
				}
			}
		}

		return racunarList;
	}

	@Override
	public Racunar findById(Integer id) throws SQLException {
		String query = "select idr, nazivr from racunar where idr = ?";
		Racunar racunar = null;

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setInt(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.isBeforeFirst()) {
					resultSet.next();

					racunar = new Racunar(resultSet.getInt(1), resultSet.getString(2));
				}
			}
		}

		return racunar;
	}

	@Override
	public boolean save(Racunar entity) throws SQLException {
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			return saveTransactional(connection, entity);
		}
	}

	@Override
	public int saveAll(Iterable<Racunar> entities) throws SQLException {
		int rowsSaved = 0;
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			connection.setAutoCommit(false); // transaction start

			for (Racunar entity : entities) {
				boolean success = saveTransactional(connection, entity); // changes are visible only to current connection
				if (success) rowsSaved++;
			}

			connection.commit(); // transaction ends successfully, changes are now visible to other connections as well
		}
		
		return rowsSaved;
	}
	
	private boolean saveTransactional(Connection connection, Racunar entity) throws SQLException {
		
		String insertCommand = "insert into racunar (nazivr, idr) values (?, ?)";
		String updateCommand = "update racunar set nazivr=? where idr=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				existsByIdTransactional(connection, entity.getIDR()) ? updateCommand : insertCommand)) {
			int i = 1;
			preparedStatement.setString(i++, entity.getNAZIVR());
			preparedStatement.setInt(i++, entity.getIDR());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}
	
	//ovo je pisano jer nzm da li iterable i list mogu nekako da se zamene
	
	public List<Racunar> findRacunarByKomponenta(Integer id) throws SQLException{
		String query = "select racunar.* from racunar, komponenta, konfiguracija where " +
				"komponenta.idk=konfiguracija.idk and racunar.idr=konfiguracija.idr and komponenta.idk=?";
		List<Racunar> racunarList = new ArrayList<Racunar>();
		
		try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				while(resultSet.next()) {
					Racunar racunar = new Racunar(resultSet.getInt(1), resultSet.getString(2));
					racunarList.add(racunar);
				}
			}
		}
		
		return racunarList;
	}

}
