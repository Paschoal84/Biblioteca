package biblioteca.app;

import java.util.List;
import java.util.Scanner;

import biblioteca.LivroService;
import biblioteca.model.Livro;

public class BibliotecarioApp {
	
	public boolean listarLivros() {
		LivroService livrosService = new LivroService();
		
		List<Livro> livros = livrosService.listarLivros();
		
		if(livros.isEmpty()) {
			System.out.println("Não há livros cadastrados!");
			return false;
		}
		System.out.println("Livros:");
		
		int contador = 1;
		for(Livro livro : livros) {
			System.out.println("Livro número: " + contador);
			System.out.println("ISBN: " + livro.getISBN());
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Ano de publiação: " + livro.getAnoPublicacao());
			System.out.println("Exemplares: " + livro.getExemplares());
			
			System.out.println("====================================");
			contador++;
		}
		return false;

	}
	
	public boolean cadastrarLivro() {
		
		Scanner scanner = new Scanner(System.in);
		
		LivroService livroService = new LivroService();
		
		System.out.println("=== Cadastro de Livro ===");
		System.out.println("ISBN: ");
		String isbn = scanner.nextLine();
		
		System.out.println("Título: ");
		String titulo = scanner.nextLine();
		
		System.out.println("Autor: ");
		String autor = scanner.nextLine();
		
		System.out.println("Editora: ");
		String editora = scanner.nextLine();
		
		System.out.println("Ano Publicação: ");
		int anoPublicacao = scanner.nextInt();
		
		System.out.println("Exemplares: ");
		int exemplares = scanner.nextInt();
		
		scanner.close();
		
		Livro livro = new Livro();
		/*livro.setISBN("123teste456");
		livro.setTitulo("Apredendo Java");
		livro.setAutor("Luis Fernando");
		livro.setEditora("Anhanguera");
		livro.setAnoPublicacao(2025);
		livro.setExemplares(10);
		
		LivroService livroService = new LivroService();
		boolean insert = livroService.cadastrarLivro(livro);*/
		
		livro.setISBN(isbn);
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setAnoPublicacao(anoPublicacao);
		livro.setExemplares(exemplares);
		
		boolean insert = livroService.cadastrarLivro(livro);
		
		if(insert) {
			System.out.println("Livro cadastrado com sucesso!");
			return true;
		} else {
			System.out.println("Erro ao cadastrar livro!");
			return false;
		}
	}
	
	public boolean listarLivro() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o ISBN do livro desejado: ");
		LivroService livrosService = new LivroService();
		
		String isbn = "Teste";
		Livro livro = livrosService.listarLivro(isbn);
		
		scanner.close();
		
		if(livro.getISBN() == null) {
			System.out.println("Livro não encontrado!!!");
			return false;
		}
		
		System.out.println("ISBN: " + livro.getISBN());
		System.out.println("Título: " + livro.getTitulo());
		System.out.println("Autor: " + livro.getAutor());
		System.out.println("Editora: " + livro.getEditora());
		System.out.println("Ano de publiação: " + livro.getAnoPublicacao());
		System.out.println("Exemplares: " + livro.getExemplares());
			
		System.out.println("====================================");
			
		return false;

	}
	
	public boolean editarLivro() {
		return false;
	}
	
	public boolean excluirLivro() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ISBN do livro que deseja excluir: ");
		String isbn = scanner.nextLine();
		
		scanner.close();
		
		LivroService livroService = new LivroService();
		
		Livro livro = livroService.listarLivro(isbn);
		
		if(livro.getISBN() == null) {
			System.out.println("Livro não encontrado para deletar!!!");
			return false;
		}
		
		boolean deleted = livroService.excluirLivro(isbn);
		
		if(deleted) {
			System.out.println("Livro deletado com sucesso!!!");
		} else {
			System.out.println("Erro ao deletar livro!!!!");
		}
		return false;
	}
}

