package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    private final String host = "localhost";
    private final String port = "3306";
    private final String user = "root";
    private final String password = "1234";
    private final String db = "db_booklinx";
    
    public Connection conectar() throws Exception {
        //String de conexão
        //String s = "jdbc:mysql://" + host + ":" + port + "/" + db;
        String s = String.format(
            "jdbc:mysql://%s:%s/%s",
            host, port, db
        );
        
        Connection c = DriverManager.getConnection(
                s, 
                user, 
                password
        );
        return c;
    }    
}