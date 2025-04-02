package biblioteca.model;

import java.time.LocalDateTime;

public class Reserva {
	
	public int id;
	public Usuario usuario;
	public Livro livro;
	public LocalDateTime dataReserva;
	public LocalDateTime expiraEm;
	
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
	public LocalDateTime getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}
	public LocalDateTime getExpiraEm() {
		return expiraEm;
	}
	public void setExpiraEm(LocalDateTime expiraEm) {
		this.expiraEm = expiraEm;
	}
}
