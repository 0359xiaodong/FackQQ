/**
 * Created by art on 1/20/15.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    private static final DBManager instance = new DBManager();

    private DBManager() {

    }

    public static DBManager getInstance(){
        return instance;
    }

    private Connection connection;

    protected void setoutConnection(Connection connection) {
        this.connection = connection;
    }

    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }


    protected void initDB() throws SQLException {
        getStatement().executeUpdate("create table person (qqID string, password string) if not EXISTS person");
        getStatement().executeUpdate("insert into person values('bangbangda', 'bangbangda')");
    }

    protected void insertDB(String qqid, String password) throws SQLException {
        getStatement().executeUpdate(String.format("insert into person values(%s, %s)", qqid, password));
    }

    protected boolean queryDB(String qqid, String password) throws SQLException {
        ResultSet rs = getStatement().executeQuery("select * from person");

        while (rs.next()) {
            // read the result set
            if (rs.getString("qqID").equals(qqid) && rs.getString("password").equals(password)) {
                return true;
            }
        }

        return false;
    }
}
