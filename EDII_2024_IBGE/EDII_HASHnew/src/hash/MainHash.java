package hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class MainHash {
	
	@SuppressWarnings("unchecked")
	private static LinkedList<String> tabela[] = new LinkedList[26];
	public static Scanner s = new Scanner(System.in);
	public static int i[] = new int [1];
	
	public static void main(String[] args) {
		gerarNomes(50);
		String opcao = "";
		do {
			opcao = menu();
			
			if(opcao.equalsIgnoreCase("1")) {
				System.out.print("Digite a palavra a ser procurada --->> ");
				busca((String) s.next());
			}
			if ((!opcao.equalsIgnoreCase("1")) && (!opcao.equalsIgnoreCase("2"))){
				System.out.println("--------------------------");
				System.out.println("Opção inválida!");
				System.out.println("--------------------------");
			}
		}while(!opcao.equalsIgnoreCase("2"));
	}
	
	public static int hash(String valor) {
		return ((int) (valor.toLowerCase().charAt(0)) + 7) % 26;
	}
	
	public static void adiciona(String valor) {
		int hash = hash(valor);
		if(tabela[hash] == null) {
			tabela[hash] = new LinkedList<String>();
		}
		tabela[hash].add(valor);
	}
	
	public static void imprimir() {
		i[0] = 0;
		Arrays.stream(tabela).forEach(lista -> {
			System.out.println( (i[0]++) + " Total: " + (lista == null ? 0 : lista.size()) + " --> " + lista);
		});
	}
	
	public static void gerarNomes(int qtdPalavras) {
		Random r = new Random();
		for(int i = 0; i < qtdPalavras; i++) {
			int qtdLetras = r.nextInt(3,9);
			String palavra = "";
			for(int j = 0; j < qtdLetras; j++) {
				char letra = (char) (r.nextInt(97, 123));
				palavra += letra;
			}
			adiciona(palavra);
		}
//		imprimir();
	}
	
	public static String menu() {
		System.out.println("***MENU***");
		System.out.println("1 - Buscar");
		System.out.println("2 - Sair");
		System.out.print("Digite a opção -->> ");
		return s.next();
	}
	
	public static void busca(String palavra) {
		LinkedList<String> lista = tabela[hash(palavra)];
		System.out.println(lista.contains(palavra) 
				? "A palavra existe na lista!" 
				: "Não encontrado esse registro!");
	}
}
