package main;

import java.util.Scanner;

import objeto.Biblioteca;
import objeto.Livro;
import objeto.Usuario;

public class Main {
	private static Scanner sc = new Scanner(System.in);;
	private static Biblioteca bib = new Biblioteca();;
	
	public static void main(String[] args) {

		while (true){
			menuPrincipal();
			String op = sc.next();
			if(op.equalsIgnoreCase("1")) {
				menuCrudUsuario();
				op = sc.next();
				while (true) {
					if(op.equalsIgnoreCase("1") 
							|| op.equalsIgnoreCase("4")) {
						
						preencheUsuario(new Usuario(), op);
						
					}else if(op.equalsIgnoreCase("2") 
							|| op.equalsIgnoreCase("3") 
							|| op.equalsIgnoreCase("5")) {
						
						achaCodigoUsuario(new Usuario(), op);
						
					}else if(op.equalsIgnoreCase("0")) {
						System.out.println("->->->->-> Voltando <-<-<-<-<-");
						break;
					}else {
						System.out.println("->->->->-> OPÇÃO INVÁLIDA! <-<-<-<-<-");
					}
					break;
				}
			}else if(op.equalsIgnoreCase("2")) {
				menuCrudLivro();
				op = sc.next();
				while (true) {
					if(op.equalsIgnoreCase("1") 
							|| op.equalsIgnoreCase("4")) {
						
						preencheLivro(new Livro(), op);
						
					}else if(op.equalsIgnoreCase("2") 
							|| op.equalsIgnoreCase("3") 
							|| op.equalsIgnoreCase("5")) {
						
						achaCodigoLivro(new Livro(), op);
						
					}else if(op.equalsIgnoreCase("0")) {
						System.out.println("->->->->-> Voltando <-<-<-<-<-");
					}else {
						System.out.println("->->->->-> OPÇÃO INVÁLIDA! <-<-<-<-<-");
					}
					break;
				}
			}else if(op.equalsIgnoreCase("3")) {
				System.out.println("->->->->-> Saindo.. <-<-<-<-<-");
				break;
			}else {
				System.out.println("->->->->-> OPÇÃO INVÁLIDA! <-<-<-<-<-");
			}
		}
	}
	
	private static void achaCodigoLivro(Livro livro, String op) {
		int cod = 0;
		try {
			if(!op.equalsIgnoreCase("5")) {
				System.out.print("Digite o código do livro ->> ");
				cod = sc.nextInt();
			}
		}catch (NumberFormatException n){
			System.out.print("Código inválido!");
			return;
		}
		livro.setIdlivro(cod);
		if(op.equalsIgnoreCase("2") || op.equalsIgnoreCase("5")) {
			bib.buscaLivro(livro);
		}else if(op.equalsIgnoreCase("3")) {
			bib.removeLivro(livro);
		}else if(op.equalsIgnoreCase("4")) {
			bib.alterarLivro(livro);
		}
	}
	
	private static void achaCodigoUsuario(Usuario usuario, String op) {
		int cod = 0;
		try {
			if(!op.equalsIgnoreCase("5")) {
				System.out.print("Digite o código do usuário ->> ");
				cod = sc.nextInt();
			}
		}catch (NumberFormatException n){
			System.out.print("Código inválido!");
			return;
		}
		usuario.setIdusuario(cod);
		if(op.equalsIgnoreCase("2") || op.equalsIgnoreCase("5")) {
			usuario.buscaUsuario(usuario);
		}else if(op.equalsIgnoreCase("3")) {
			usuario.removeUsuario(usuario);
		}else if(op.equalsIgnoreCase("4")) {
			usuario.alterarUsuario(usuario);
		}
	}
	
	private static void menuPrincipal() {
		System.out.println("->->->->-> MENU PRINCIPAL <-<-<-<-<-");
		System.out.println("1 ->> Acessar Usuários");
		System.out.println("2 ->> Acessar Biblioteca");
		System.out.println("3 ->> Sair");
		System.out.print("Escolha uma opção ->> ");
	}
	
	private static void menuCrudUsuario() {
		System.out.println("->->->->-> MENU DE USUÁRIO<-<-<-<-<-");
		System.out.println("1 ->> Inserir Usuário");
		System.out.println("2 ->> Buscar Usuário");
		System.out.println("3 ->> Remover Usuário");
		System.out.println("4 ->> Alterar Usuário");
		System.out.println("5 ->> Listar Usuários");
		System.out.println("0 ->> Voltar");
		System.out.print("Escolha uma opção ->> ");
	}
	
	private static void menuCrudLivro() {
		System.out.println("->->->->-> MENU DE LIVRO<-<-<-<-<-");
		System.out.println("1 ->> Inserir Livro");
		System.out.println("2 ->> Buscar Livro");
		System.out.println("3 ->> Remover Livro");
		System.out.println("4 ->> Alterar Livro");
		System.out.println("5 ->> Listar Livro");
		System.out.println("0 ->> Voltar");
		System.out.print("Escolha uma opção ->> ");
	}
	
	private static void preencheLivro(Livro livro, String op) {
			System.out.print("Digite o titulo do livro ->> ");
			livro.setTitulo(sc.next());
			System.out.print("Digite o autor do livro ->> ");
			livro.setAutor(sc.next());
			System.out.print("Digite o ano do livro ->> ");
			livro.setAnoPublicacao(sc.next());
		if(op.equalsIgnoreCase("4")) {
			achaCodigoLivro(livro, op);
		}else {
			bib.insereLivro(livro);
		}
	}
	
	private static void preencheUsuario(Usuario usuario, String op) {
		System.out.print("Digite o nome do usuário ->> ");
		usuario.setNome(sc.next());
		System.out.print("Digite o e-mail do usuário ->> ");
		usuario.setEmail(sc.next());
		
		if(op.equalsIgnoreCase("4")) {
			achaCodigoUsuario(usuario, op);
		}else {
			usuario.insereUsuario(usuario);
		}
	}
}
