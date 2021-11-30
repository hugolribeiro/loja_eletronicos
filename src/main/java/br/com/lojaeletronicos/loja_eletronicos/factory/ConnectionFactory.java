package br.com.lojaeletronicos.loja_eletronicos.factory;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static Connection getConexao() throws SQLException {
        Connection conexao = DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=GMT&createDatabaseIfNotExist=true",
                        "root", "12$Padrao");
        return conexao;
    }
}
