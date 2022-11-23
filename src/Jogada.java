import java.util.Scanner;

public class Jogada {
    static private final String SEPARADOR = "\n------------------";
    static private final String MARCACAO = "Jogador 1 será o X \nJogador 2 será o O";
    static private final String JOGADA_JOGADOR_UM = "• Jogador 1 é sua vez";
    static private final String JOGADA_JOGADOR_DOIS = "• Jogador 2 é sua vez";
    static private final String POSICAO_LINHA = "Informe a linha: ";
    static private final String POSICAO_COLUNA = "Informe a coluna: ";
    static private final String MENSAGEM_ERRO = "Jogada inválida, informe a linha e coluna de 0 a 3, combinando os valores para formar a jogada.";
    static private final String POSICAO_PREENCHIDA = "Esta posição já está preenchida, informe uma nova jogada. \n";
    private static char[][] posicao = new char[3][3];
    private int linha, coluna;
    private boolean continuar, fimJogo = false, continuaJogo = true;
    private char controle, vencedor;

    public char getJogadaJogadorUm() {
        System.out.println(SEPARADOR);
        System.out.println(JOGADA_JOGADOR_UM);
        do {
            continuar = false;
            System.out.print(POSICAO_LINHA);
            linha = new Scanner(System.in).nextInt();
            System.out.print(POSICAO_COLUNA);
            coluna = new Scanner(System.in).nextInt();
            //valida se já está preenchido
            if (validaPosicaoPreenchida(linha, coluna) == true) {
                System.out.println(POSICAO_PREENCHIDA);
                continuar = true;
            }
            if (linha < 0 || linha >= 3 && coluna < 0 || coluna >= 3) {
                System.out.println(MENSAGEM_ERRO);
                continuar = true;
            }
        } while (continuar);
        posicao[linha][coluna] = 'X';
        return posicao[linha][coluna];
    }

    public char getJogadaJogadorDois() {
        System.out.println(SEPARADOR);
        System.out.println(JOGADA_JOGADOR_DOIS);
        do {
            continuar = false;
            System.out.print(POSICAO_LINHA);
            linha = new Scanner(System.in).nextInt();
            System.out.print(POSICAO_COLUNA);
            coluna = new Scanner(System.in).nextInt();
            if (validaPosicaoPreenchida(linha, coluna) == true) {
                System.out.println(POSICAO_PREENCHIDA);
                continuar = true;
            }
            if (linha < 0 || linha >= 3 && coluna < 0 || coluna >= 3) {
                System.out.println(MENSAGEM_ERRO);
                continuar = true;
            }
        } while (continuar);
        posicao[linha][coluna] = 'O';
        return posicao[linha][coluna];
    }

    public void jogada(char controle) {
        //montando jogada
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (posicao[linha][coluna] == 'X') {
                    System.out.print(" X ");
                } else if (posicao[linha][coluna] == 'O') {
                    System.out.print(" O ");
                } else if (posicao[linha][coluna] == controle) {
                    System.out.println(controle);
                } else {
                    System.out.print("   ");
                }
                if (coluna != 2) System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean validaPosicaoPreenchida(int posicaoLinha, int posicaoColuna) {
        boolean existe = false;
        if (posicao[posicaoLinha][posicaoColuna] == 'X' || posicao[posicaoLinha][posicaoColuna] == 'O') {
            existe = true;
        }
        return existe;
    }

    public char verificarLinha() {
        for (int linha = 0; linha < 3; linha++) {
            if (posicao[linha][0] == 'X' && posicao[linha][1] == 'X' && posicao[linha][2] == 'X') vencedor = 'X';
            else if (posicao[linha][0] == 'O' && posicao[linha][1] == 'O' && posicao[linha][2] == 'O') vencedor = 'O';
        }
        return vencedor;
    }

    public char verificarColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (posicao[0][coluna] == 'X' && posicao[1][coluna] == 'X' && posicao[2][coluna] == 'X') vencedor = 'X';
            else if (posicao[0][coluna] == 'O' && posicao[1][coluna] == 'O' && posicao[2][coluna] == 'O')
                vencedor = 'O';
        }
        return vencedor;
    }
    public char verificariagonais() {
        if (posicao[0][0] == 'X' && posicao[1][1] == 'X' && posicao[2][2] == 'X') vencedor = 'X';
        else if (posicao[0][0] == 'O' && posicao[1][1] == 'O' && posicao[2][2] == 'O') vencedor = 'O';
        else if (posicao[0][2] == 'X' && posicao[1][1] == 'X' && posicao[2][0] == 'X') vencedor = 'X';
        else if (posicao[0][2] == 'O' && posicao[1][1] == 'O' && posicao[2][0] == 'O') vencedor = 'O';
        return vencedor;
    }

    public boolean verificarGanhador() {
        verificarLinha();
        verificarColunas();
        verificariagonais();
        if (vencedor == 'X' || vencedor == 'O') fimJogo = true;
        return fimJogo;
    }

    public void jogo() {
        System.out.println(MARCACAO);
        do {
            if (verificarGanhador() == false) {
                controle = getJogadaJogadorUm();
                jogada(controle);
            } else continuaJogo = false;
            if (verificarGanhador() == false) {
                controle = getJogadaJogadorDois();
                jogada(controle);
            } else continuaJogo = false;

        } while (continuaJogo);
        if (vencedor == 'X') {
            System.out.println("O jogador 1 venceu (X)");
        } else System.out.println("O jogador 2 venceu (O)");
        new Menu().menu();
    }
}