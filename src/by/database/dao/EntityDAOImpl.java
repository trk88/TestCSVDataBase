package by.database.dao;


import by.database.dBUtils.DBUtils;
import by.database.pool.ConnectionPool;
import by.entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntityDAOImpl implements EntityDAO{
    static String  sortValue = "name";
    private static final String QUERY_SHOW_ENTITIES = "SELECT * FROM entities";
    private static final String QUERY_ADD_ENTITIES = "INSERT INTO entities (name, surname,login,email,phonenumber) values(?,?,?,?,?)";

    @Override
    public void addEntity(Entity entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(QUERY_ADD_ENTITIES);

            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2,entity.getSurname());
            preparedStatement.setString(3,entity.getLogin());
            preparedStatement.setString(4,entity.getEmail());
            preparedStatement.setInt(5, entity.getPhonenumber());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(connection, preparedStatement);
        }


    }

    @Override
    public List<Entity> showEntities(String sortValue) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement statement = null;
        List<Entity> entities = null;
        ResultSet resultSet = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM entities ORDER BY "+sortValue);
             
            entities = initEntities(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,statement,resultSet);
        }

        return entities;
    }


    private List<Entity> initEntities(ResultSet resultSet) throws SQLException {
        List<Entity> entities = new ArrayList<Entity>();
        while(resultSet.next()){
            Entity entity = new Entity();

            entity.setName(resultSet.getString("name"));
            entity.setSurname(resultSet.getString("surname"));
            entity.setLogin(resultSet.getString("login"));
            entity.setEmail(resultSet.getString("email"));
            entity.setPhonenumber(resultSet.getInt("phonenumber"));

            entities.add(entity);
        }
        return entities;
    }
}
