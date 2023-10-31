package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    private final String host = "mysql-30400d26-murilofcorso-c0a6.aivencloud.com";
    private final String port = "27270";
    private final String user = "avnadmin";
    private final String password = "AVNS_ZY4dNyp8wlS11-4oxKt";
    private final String db = "defaultdb";
    
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