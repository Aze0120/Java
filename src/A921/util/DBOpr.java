package A921.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOpr {
    static Connection conn = null;
    static PreparedStatement pre = null;


    public static int update(String sql, Object[] objects) {

        try {
            conn = JdbcUtils.getConnection();
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                pre.setObject(i + 1, objects[i]);
            }
            return pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, pre, conn);
        }
    }

}
