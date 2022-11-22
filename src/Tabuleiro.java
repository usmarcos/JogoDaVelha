public class Tabuleiro {
    public void montaTabulerioExemplo() {
        System.out.println("\nNo modo básico do jogo, participam duas pessoas, que jogam alternadamente, preenchendo cada um dos espaços vazios. " +
                "\nCada participante poderá usar um símbolo (X ou O). " +
                "\nVence o jogador que conseguir formar primeiro uma linha com três símbolos iguais, seja ela na horizontal, vertical ou diagonal.");
        System.out.println("Horizontal:");
        System.out.println("X | X | X \nX | O | X \nO | X | O");
        System.out.println("\nVertical:");
        System.out.println("O | X | O \nX | X | O \nO | X | O");
        System.out.println("\nDiagonal:");
        System.out.println("X | O | O \nX | X | O \nO | X | X");
        new Menu().menu();
    }

    public void posicoes() {
        System.out.println("A matriz é composta das seguintes posições");
        System.out.println("[0,0] | [0,1] | [0,2] \n[1,0] | [1,1] | [1,2] \n[2,0] | [2,1] | [2,2]");
        new Menu().menu();
    }
}

