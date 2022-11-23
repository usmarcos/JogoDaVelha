package menu;

import metodos.Jogada;
import texto.Tabuleiro;

import java.util.Scanner;

public class Menu {
    public void menu() {
        int opcao;
        boolean continuar;
        System.out.println("\nIniciar jogo");
        do {
            continuar = false;
            System.out.println("1 - Novo jogo");
            System.out.println("2 - Melhor de três");
            System.out.println("3 - Instruções de jogo");
            System.out.println("4 - Posições");
            System.out.println("5 - Sair");
            opcao = new Scanner(System.in).nextInt();
            if (opcao <= 0 || opcao > 4) {
                System.out.println("Opção inválida. Escolha uma das opções.");
                continuar = true;
            }
        } while (continuar);
        switch (opcao) {
            case 1:
                System.out.println("Iniciando novo jogo.");
                new Jogada().jogo();
                break;
                case 2:
                System.out.println("Iniciando novo jogo de melhor de três");
                System.out.println("Esse modo de jogo consiste em 3 rodadas que defeniram um vencedor ou empate.\n");
                new Jogada().melhorDeTres();
                break;
            case 3:
                new Tabuleiro().montaTabulerioExemplo();
                break;
            case 4:
                new Tabuleiro().posicoes();
                break;
            case 5:
                System.out.println("Finalizando jogo.");
                System.exit(1);
                break;
        }
    }
}