package main;

import java.util.Scanner;

import objeto.Biblioteca;
import objeto.Livro;

public class Main {
	private static Scanner sc = new Scanner(System.in);;
	private static Biblioteca bib = new Biblioteca();;
	
	public static void main(String[] args) {

		while (true){
			menu();
			String op = sc.next();
			
			if(op.equalsIgnoreCase("1")) {
				preencheLivro();
			}else if(op.equalsIgnoreCase("2")) {
				achaCodigo(op);
			}else if(op.equalsIgnoreCase("3")) {
				achaCodigo(op);
			}else if(op.equalsIgnoreCase("4")) {
				bib.listaLivros();
			}else if(op.equalsIgnoreCase("5")) {
				System.out.println("->->->->-> Saindo.. <-<-<-<-<-");
				break;
			}else {
				System.out.println("->->->->-> OPÇÃO INVÁLIDA! <-<-<-<-<-");
			}
		}
	}
	
	private static void achaCodigo(String op) {
		System.out.print("Digite o código do livro ->> ");
		String cod = sc.next();
		if(op.equalsIgnoreCase("2")) {
			bib.buscasLivro(cod);
		}else if(op.equalsIgnoreCase("3")) {
			bib.removeLivro(cod);
		}
	}
	
	private static void menu() {
		System.out.println("->->->->-> MENU <-<-<-<-<-");
		System.out.println("1 ->> Inserir Livro");
		System.out.println("2 ->> Buscar Livro");
		System.out.println("3 ->> Remover Livro");
		System.out.println("4 ->> Listar Livro");
		System.out.println("5 ->> Sair");
		System.out.print("Escolha uma opção ->> ");
	}
	
	private static void preencheLivro() {
		Livro livro = new Livro();
		System.out.print("Digite o titulo do livro ->> ");
		livro.setTitulo(sc.next());
		System.out.print("Digite o autor do livro ->> ");
		livro.setAutor(sc.next());
		System.out.print("Digite o ano do livro ->> ");
		livro.setAnoPublicacao(sc.next());
		bib.insereLivro(livro);
	}
}
