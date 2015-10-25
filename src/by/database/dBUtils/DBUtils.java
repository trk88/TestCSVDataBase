package by.database.dBUtils;

import java.sql.*;

public class DBUtils {
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }

        }catch (SQLException e){
            System.out.println("Can't close resources");
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, PreparedStatement preparedStatement) {
        close(connection, preparedStatement, null);
    }

}
