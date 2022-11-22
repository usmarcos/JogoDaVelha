import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Jogada {
    static private final String SEPARADOR = "\n------------------";
    static private final String MARCACAO = "Jogador 1 será o X \nJogador 2 será o O";
    static private final String JOGADA_JOGADOR_UM = "• Jogador 1 é sua vez";
    static private final String JOGADA_JOGADOR_DOIS = "• Jogador 2 é sua vez";
    static private final String POSICAO_LINHA = "Informe a linha: ";
    static private final String POSICAO_COLUNA = "Informe a coluna: ";
    static private final String MENSAGEM_ERRO = "Jogada inválida, informe a linha e coluna de 0 a 3, combinando os valores para formar a jogada.";
    static private final String POSICAO_PREENCHIDA = "Esta posição já está preenchida, informe uma nova jogada";
    private static char[][] posicao = new char[3][3];
    private int linha, coluna;
    private boolean continuar;
    private char controle = ' ';
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
        posicao[coluna][linha] = 'X';
        return posicao[coluna][linha];
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
                    System.out.print("X");
                } else if (posicao[linha][coluna] == 'O') {
                    System.out.print("O");
                } else if (posicao[linha][coluna] == controle) {
                    System.out.println(controle);
                } else {
                    System.out.print(" ");
                }
                if (coluna != 2) System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean validaPosicaoPreenchida(int posicaoLinha, int posicaoColuna) {
        boolean existe = false;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                    if (posicao[posicaoLinha][posicaoColuna] == 'X' || posicao[posicaoLinha][posicaoColuna] == 'O' ) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public void pontos(){
        /**
         * verificar ganhador e fazer com que o jogo siga até o fim
         */
    }
    public void jogo() {
        System.out.println(MARCACAO);
        controle = getJogadaJogadorUm();
        jogada(controle);
        controle = getJogadaJogadorDois();
        jogada(controle);

    }
}

