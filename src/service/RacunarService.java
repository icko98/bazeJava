package service;

import java.sql.SQLException;

import dao.RacunarDAO;
import daoImplement.RacunarDAOImpl;

public class RacunarService {
	
	private static final RacunarDAO racunardao = new RacunarDAOImpl();
	
	public static int count() throws SQLException{
		return racunardao.count();
	}

	public RacunarService() {
		// TODO Auto-generated constructor stub
	}

}
