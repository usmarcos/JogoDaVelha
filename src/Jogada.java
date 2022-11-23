import java.util.Scanner;

public class Jogada {
    static private final String SEPARADOR = "\n------------------";
    static private final String MARCACAO = "Jogador 1 será o X \nJogador 2 será o O";
    static private final String MELHOR_DE_TRES = "INICIANDO MELHOR DE TRES";
    static private final String PRIMEIRA_RODADA = "PRIMEIRA RODADA";
    static private final String SEGUNDA_RODADA = "SEGUNDA RODADA";
    static private final String TERCEIRA_RODADA = "TERCEIRA RODADA";
    static private final String JOGADA_JOGADOR_UM = "• Jogador 1 é sua vez";
    static private final String JOGADA_JOGADOR_DOIS = "• Jogador 2 é sua vez";
    static private final String POSICAO_LINHA = "Informe a linha: ";
    static private final String POSICAO_COLUNA = "Informe a coluna: ";
    static private final String MENSAGEM_ERRO = "Jogada inválida, informe a linha e coluna de 0 a 3, combinando os valores para formar a jogada.\n";
    static private final String POSICAO_PREENCHIDA = "Esta posição já está preenchida, informe uma nova jogada. \n";
    private char[][] posicao = new char[3][3];
    private String[] historicoGanhador = new String[20];
    private int linha, coluna, velha;
    private boolean continuar, fimJogo = false, continuaJogo = true;
    private char controle, vencedor;


    private char getJogadaJogadorUm() {
        System.out.println(SEPARADOR);
        System.out.println(JOGADA_JOGADOR_UM);
        do {
            continuar = false;
            System.out.print(POSICAO_LINHA);
            linha = new Scanner(System.in).nextInt();
            System.out.print(POSICAO_COLUNA);
            coluna = new Scanner(System.in).nextInt();
            if (linha < 0 || linha >= 3 && coluna < 0 || coluna >= 3) {
                System.out.println(MENSAGEM_ERRO);
                continuar = true;
                //quando for verdadeiro passa ou comparar usando == true
            } else if (validaPosicaoPreenchida(linha, coluna)) {
                System.out.println(POSICAO_PREENCHIDA);
                continuar = true;
            }
        } while (continuar);
        posicao[linha][coluna] = 'X';
        return posicao[linha][coluna];
    }

    private char getJogadaJogadorDois() {
        System.out.println(SEPARADOR);
        System.out.println(JOGADA_JOGADOR_DOIS);
        do {
            continuar = false;
            System.out.print(POSICAO_LINHA);
            linha = new Scanner(System.in).nextInt();
            System.out.print(POSICAO_COLUNA);
            coluna = new Scanner(System.in).nextInt();
            if (linha < 0 || linha >= 3 && coluna < 0 || coluna >= 3) {
                System.out.println(MENSAGEM_ERRO);
                continuar = true;
                //quando for verdadeiro passa ou comparar usando == true
            } else if (validaPosicaoPreenchida(linha, coluna)) {
                System.out.println(POSICAO_PREENCHIDA);
                continuar = true;
            }
        } while (continuar);
        posicao[linha][coluna] = 'O';
        return posicao[linha][coluna];
    }

    private void jogada(char controle) {
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

    private boolean validaPosicaoPreenchida(int posicaoLinha, int posicaoColuna) {
        boolean existe = false;
        if (posicao[posicaoLinha][posicaoColuna] == 'X' || posicao[posicaoLinha][posicaoColuna] == 'O') {
            existe = true;
        }
        return existe;
    }

    private void verificarLinha() {
        for (int linha = 0; linha < 3; linha++) {
            if (posicao[linha][0] == 'X' && posicao[linha][1] == 'X' && posicao[linha][2] == 'X') vencedor = 'X';
            else if (posicao[linha][0] == 'O' && posicao[linha][1] == 'O' && posicao[linha][2] == 'O') vencedor = 'O';
        }
    }

    private void verificarColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (posicao[0][coluna] == 'X' && posicao[1][coluna] == 'X' && posicao[2][coluna] == 'X') vencedor = 'X';
            else if (posicao[0][coluna] == 'O' && posicao[1][coluna] == 'O' && posicao[2][coluna] == 'O')
                vencedor = 'O';
        }
    }

    private void verificariagonais() {
        if (posicao[0][0] == 'X' && posicao[1][1] == 'X' && posicao[2][2] == 'X') vencedor = 'X';
        else if (posicao[0][0] == 'O' && posicao[1][1] == 'O' && posicao[2][2] == 'O') vencedor = 'O';
        else if (posicao[0][2] == 'X' && posicao[1][1] == 'X' && posicao[2][0] == 'X') vencedor = 'X';
        else if (posicao[0][2] == 'O' && posicao[1][1] == 'O' && posicao[2][0] == 'O') vencedor = 'O';
    }

    private boolean verificarGanhador() {
        verificarLinha();
        verificarColunas();
        verificariagonais();
        if (vencedor == 'X' || vencedor == 'O') fimJogo = true;
        return fimJogo;
    }

    private void reset() {
        //reset matriz com valores
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                posicao[linha][coluna] = ' ';
            }
        }
        //reset das linhas, colunas e contador da velha.
        linha = 0;
        coluna = 0;
        velha = 0;
        //reset dos controladores
        continuar = false;
        fimJogo = false;
        continuaJogo = true;
        //reset das tomadas de descisão
        controle = ' ';
        vencedor = ' ';
    }

    public void jogo() {
        System.out.println(MARCACAO);
        do {
            if (velha == 9) continuaJogo = false;
                //se for falso passa ou pode ser usado verificarGanhador()==false;
            else if (!verificarGanhador()) {
                controle = getJogadaJogadorUm();
                jogada(controle);
                velha++;
            } else continuaJogo = false;
            if (velha == 9) continuaJogo = false;
                //se for falso passa ou pode ser usado verificarGanhador()==false;
            else if (!verificarGanhador()) {
                controle = getJogadaJogadorDois();
                jogada(controle);
                velha++;
            } else continuaJogo = false;
        } while (continuaJogo);
        if (velha == 9) System.out.println("\nVELHA, não há vencedores. Inicie uma nova partida.");
        if (vencedor == 'X') {
            System.out.println("\nO jogador 1 venceu (X)");
        } else if (vencedor == 'O') {
            System.out.println("\nO jogador 2 venceu (O)");
        }
        reset();
        new Menu().menu();
    }

    private void placar() {
        int vencedorX = 0, vecedorO = 0, empate = 0;
        if (vencedor == 'X') vencedorX++;
        else if (vencedor == 'O') vencedorX++;
        else if (velha == 9) empate++;
    }

    /**
     * Melhor de três
     */

    private void setPlacar() {
        String historico;
        historico = vencedor == 'X' ? "Jogador 1" : vencedor == 'O' ? "Jogador 2" : "VELHA";

        for (int i = 0; i < historicoGanhador.length; i++) {
            if (historicoGanhador[i] == null) {
                historicoGanhador[i] = historico;
                break;
            }
        }
    }

    public void melhorDeTres() {
        System.out.println(MARCACAO);
        System.out.println(MELHOR_DE_TRES);
        int melhorDeTres = 0;
        do {
            if (velha == 9) continuaJogo = false;
                //se for falso passa ou pode ser usado verificarGanhador()==false;
            else if (!verificarGanhador()) {
                controle = getJogadaJogadorUm();
                jogada(controle);
                velha++;
            } else {
                if (vencedor == 'X') ;

            }
            if (velha == 9) continuaJogo = false;
                //se for falso passa ou pode ser usado verificarGanhador()==false;
            else if (!verificarGanhador()) {
                controle = getJogadaJogadorDois();
                jogada(controle);
                velha++;
            } else continuaJogo = false;

            if (vencedor == 'X' || vencedor == 'O' || velha == 9) melhorDeTres++;
        } while (melhorDeTres == 3);


        if (velha == 9) System.out.println("\nVELHA, não há vencedores. Inicie uma nova partida.");
        if (vencedor == 'X') {
            System.out.println("\nO jogador 1 venceu (X)");
        } else if (vencedor == 'O') {
            System.out.println("\nO jogador 2 venceu (O)");
        }
        reset();
        new Menu().menu();
    }

}
//Exemplo para dar velha: 00 01 02 10 11 12 21 20 22
//Exemplo ganhar horizontalmente : 10 20 11 21 12
//Exemplo ganhar verticalmente : 01 02 11 12 21
//Exemplo ganhar diagonal : 20 21 11 22 02