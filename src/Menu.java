import java.util.Scanner;

public class Menu {
    public void menu() {
        int opcao;
        boolean continuar;
        System.out.println("\nIniciar jogo");
        do {
            continuar = false;
            System.out.println("1 - Novo jogo");
            System.out.println("2 - Instruções de jogo");
            System.out.println("3 - Posições");
            System.out.println("4 - Sair");
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
                new Tabuleiro().montaTabulerioExemplo();
                break;
            case 3:
                new Tabuleiro().posicoes();
                break;
            case 4:
                System.out.println("Finalizando jogo.");
                System.exit(1);
                break;
        }
    }
}
