package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil_HikariCP;
import dao.KomponentaDAO;
import model.Komponenta;

public class KomponentaDAOImpl implements KomponentaDAO {

	public KomponentaDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Komponenta entity) throws SQLException {
		return deleteById(entity.getIDK());
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		String query = "delete from komponenta where idk=?";
		try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
					preparedStatement.setInt(1, id);
					int rowsAffected = preparedStatement.executeUpdate();
					return rowsAffected==1;
				}
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Komponenta> findAll() throws SQLException {
		String query = "select * from komponenta";
		List<Komponenta> kompList = new ArrayList<Komponenta>();
		Connection connection = ConnectionUtil_HikariCP.getConnection();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while(resultSet.next()) {
				Komponenta komp = new Komponenta(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6));
				kompList.add(komp);
			}
		}
		return kompList;
		}

	@Override
	public Iterable<Komponenta> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Komponenta findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Komponenta entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Komponenta> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
