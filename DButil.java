import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DButil{
	/**
	 * 驱动
	 */
	 public static String driver =
	"com.microsoft.jdbc.sqlserver.SQLServerDriver";
	/**
	 * 连接字符串
	 */
	public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=dbtest";

	/**
	 * 用户名
	 */
	public static String user = "sa";
	/**
	 * 密码
	 */
	public static String password = "123";
	static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			Logger.getLogger(DButil.class.getName()).log(Level.SEVERE, null,ex);
			return null;
		}
	}
}