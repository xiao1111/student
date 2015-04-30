package util.test.factory;

import util.test.dao.adminDAO;
import util.test.dao.userDAO;
import util.test.dao.impl.adminDAOImpl;
import util.test.dao.impl.userDAOImpl;
import util.test.dao.buycarDAO;
import util.test.dao.impl.buycarDAOImpl;


public class DAOFactory {
	public static adminDAO getAdminDAOImpl()
	{
		return new adminDAOImpl();
	}
	
	public static userDAO getMessageDAOInstance()
	{
		return new userDAOImpl();
	}
	public static buycarDAO getBuycarDAOImpl()
	{
		return new buycarDAOImpl();
	}
}
