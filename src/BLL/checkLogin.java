package BLL;

import UTILS.MyConnection;
import java.sql.*;

public class checkLogin {
    public static Connection conn = null;
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    public static String testConnect()
    {
        try
        {
            conn = MyConnection.getConnection();
            return "Kết nối cơ sở dữ liệu thành công";
        }
        catch(Exception e)
        {
            return "Kết nối cơ sở dữ liệu thất bại";
        }
    }
        public static ResultSet cLog(String user, String pass)
        {
            String sql="SELECT * FROM admin where username=? and password=?";
            try
            {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            return rs =  pst.executeQuery();
            }
            catch(Exception e)
            {
                return rs = null;
            }
            
        }
}