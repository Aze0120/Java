package A920.utils;

import java.sql.*;

public class Daopr {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public boolean update(String sql, Object[] objs) {
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            int row = preparedStatement.executeUpdate();
            return row > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
