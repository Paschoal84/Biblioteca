package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import biblioteca.infraestructure.Database;
import biblioteca.model.Livro;

public class LivroService {

	public boolean cadastrarLivro(Livro livro) {
		String sql = "INSERT INTO livro" 
				+ "(ISBN, Titulo, Autor, Editora, AnoPublicacao, Status, Exemplares)"
				+ "VALUES" + "(?, ?, ?, ?, ?, ?, ? )";
		
		try {
			Database db = new Database();
			Connection conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, livro.getISBN());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutor());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5, livro.getAnoPublicacao());
			stmt.setString(6, "Disponivel");
			stmt.setInt(7, livro.getExemplares());
			
			int linhasAfetadas = stmt.executeUpdate();
			
			if(linhasAfetadas > 0) {
				return true;
			}
			
			return false;
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Livro> listarLivros(){
		List<Livro> livros = new ArrayList<>();
		
		String sql = "SELECT * FROM livro";
		
		try {
			Database db = new Database();
			Connection conn = db.getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Livro livro = new Livro();
				livro.setISBN(rs.getString("ISBN"));
				livro.setTitulo(rs.getString("Titulo"));
				livro.setAutor(rs.getString("Autor"));
				livro.setEditora(rs.getString("Editora"));
				livro.setAnoPublicacao(rs.getInt("AnoPublicacao"));
				livro.setExemplares(rs.getInt("Exemplares"));
				
				livros.add(livro);			}
			
			return livros;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return livros;		
		}
	}
	
	public Livro listarLivro(String isbn){
		
		Livro livro = new Livro();
				
		String sql = "SELECT * FROM livro WHERE ISBN = ?";
		
		try {
			Database db = new Database();
			Connection conn = db.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, isbn);
			
			ResultSet rs = stmt.executeQuery();
					
			while(rs.next()) {
				
				livro.setISBN(rs.getString("ISBN"));
				livro.setTitulo(rs.getString("Titulo"));
				livro.setAutor(rs.getString("Autor"));
				livro.setEditora(rs.getString("Editora"));
				livro.setAnoPublicacao(rs.getInt("AnoPublicacao"));
				livro.setExemplares(rs.getInt("Exemplares"));
				
			}
			
			return livro;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return livro;		
		}
	}
	
	public boolean excluirLivro(String isbn) {
		
		String sql = "DELETE FROM livro WHERE ISBN = ?";
		
		try {
			Database db = new Database();
			Connection conn = db.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, sql);
			
			int rowsAffected = stmt.executeUpdate();
			
			return rowsAffected > 0;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
