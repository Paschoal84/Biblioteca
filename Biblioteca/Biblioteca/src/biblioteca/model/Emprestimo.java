package biblioteca.model;

import java.time.LocalDateTime;

public class Emprestimo {
	
	private int id;
	private Usuario usuario;
	private Livro livro;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucaoPrevisto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDateTime getDataDevolucaoPrevist() {
		return dataDevolucaoPrevisto;
	}
	public void setDataDevolucaoPrevist(LocalDateTime dataDevolucaoPrevist) {
		this.dataDevolucaoPrevisto = dataDevolucaoPrevist;
	}
}