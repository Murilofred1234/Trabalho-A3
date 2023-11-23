package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private final Properties properties;
    
    private String host;
    private String port;
    private String user;
    private String password;
    private String db;
    
    
    public ConnectionFactory(Properties p) {
        this.properties = p;
        
        host = properties.getProperty("DB_HOST");
        port = properties.getProperty("DB_PORT");
        user = properties.getProperty("DB_USER");
        password = properties.getProperty("DB_PASSWORD");
        db = properties.getProperty("DB_NAME");
    }
    
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