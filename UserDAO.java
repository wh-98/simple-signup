import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO{
	DButil db;
	public boolean findUser(String userName, String userPassword) {
		db=new DButil();
        Connection connection=DButil.getConnection();
        try
        {
            Statement sql=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//获取执行sql的对象
            ResultSet resultSet=sql.executeQuery("select * from dbo.UserInfo where UserId='"+userName+"' and UserPwd='"+userPassword+"'");
             
            resultSet.last();
            if(resultSet.getRow()<1) return false;//未找到
            else return true;
            
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
		}
}
