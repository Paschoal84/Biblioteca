package biblioteca.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	private String url = "jdbc:mysql://localhost:3306/biblioteca";
	private String user = "root";
	private String password = "";
	private Connection connection;

	public Database() {
	    connect();
	    }

	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar ao banco de dados", e);
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Conexão com o banco encerrada");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
    public void executeDML(String query) {
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeDQL(String query) {
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}