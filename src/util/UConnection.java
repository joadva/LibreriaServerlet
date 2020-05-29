package util;




import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class UConnection {
	
	
		private static Connection con = null;
		
		public static Connection getConnection()
		{
			try
			{
				if (con == null)
				{
					ResourceBundle rb = ResourceBundle.getBundle("util.jdbc");
					String driver = rb.getString("driver");
					String url = rb.getString("url");
					String usr = rb.getString("usr");
					String pwd = rb.getString("pwd");
					Class.forName(driver);
					con = DriverManager.getConnection(url,usr,pwd);
				}
				return con;
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException("Error al crear la conexi�n",ex);
			}
		}
		static class MiShDwnHook extends Thread
		{
			//justo antes de finalizar el programa la JVM invocara
			// a este metodo donde podemos cerrar la conexi�n
			public void run()
			{
				try
				{
					Connection con = UConnection.getConnection();
					con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					throw new RuntimeException(ex);
				}
			}
		}

}
