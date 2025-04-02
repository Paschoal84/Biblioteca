package biblioteca;

import java.sql.Connection;
import java.util.Scanner;

import biblioteca.app.BibliotecarioApp;
import biblioteca.infraestructure.Database;


public class Biblioteca {

	public static void main(String[] args) {
		
		Database db = new Database();
		
		Connection conn = db.getConnection();
		
		if(conn != null) {
			System.out.println("Conexão efetuada com sucesso!");
		}
		
		else {
			System.out.println("Conexão não estabelecida!");
		}
			

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bem vindo ao sistema de biblioteca!");
		System.out.println("Selecione o tipo de usuario");
		System.out.println("1 - Aluno");
		System.out.println("2 - Professor");
		System.out.println("3 - Bibliotecario");
		System.out.println("9 - Sair");
		
		String input = scanner.nextLine();
		
		switch(input) {
		case ("1"):
			aluno();
			break;
			
		case ("2"):
			professor();
			break;
			
		case ("3"):
			bibliotecario();
			break;
			
		case ("9"):
			encerrar(db);
			break;
		default:
			System.out.println("Opção inválida");
		}
		scanner.close();
	}	

	public static void aluno() {
		System.out.println("Você selecionou aluno");
	}
	
	public static void professor() {
		System.out.println("Você selecionou professor");
	}
	
	public static void bibliotecario() {
		System.out.println("Você selecionou bibliotecario");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a opção desejada");
		System.out.println("1 - Listar livros");
		System.out.println("2 - Cadastrar livro");
		System.out.println("3 - Editar livro");
		System.out.println("4 - Excluir livro");
		System.out.println("5 - Listar livro");
		
		String input = scanner.nextLine();
		
		BibliotecarioApp bibliotecarioApp = new BibliotecarioApp();
		switch(input) {
			case("1"):
				bibliotecarioApp.listarLivros();
				break;
			case("2"):
				bibliotecarioApp.cadastrarLivro();
				break;
			case("3"):
				bibliotecarioApp.editarLivro();
				break;
			case("4"):
				bibliotecarioApp.excluirLivro();
				break;
			case("5"):
				bibliotecarioApp.listarLivro();
				break;
				
			default:
				System.out.println("Opção invalida");
		}
		
		scanner.close();
		
	}
	
	public static void encerrar(Database db) {
		db.closeConnection();
		System.out.println("Obrigado por utilizar o sistema");
		System.exit(0);
	}
 }
