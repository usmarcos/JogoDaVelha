import java.util.Scanner;

public class Jogada {
    static private final String SEPARADOR = "\n------------------";
    static private final String MARCACAO = "Jogador 1 será o X \nJogador 2 será o O";
    static private final String MELHOR_DE_TRES = "\nINICIANDO MELHOR DE TRES";
    static private final String PRIMEIRA_RODADA = "\nPRIMEIRA RODADA";
    static private final String SEGUNDA_RODADA = "\nSEGUNDA RODADA";
    static private final String TERCEIRA_RODADA = "\nTERCEIRA RODADA";
    static private final String JOGADA_JOGADOR_UM = "• Jogador 1 é sua vez";
    static private final String JOGADA_JOGADOR_DOIS = "• Jogador 2 é sua vez";
    static private final String POSICAO_LINHA = "Informe a linha: ";
    static private final String POSICAO_COLUNA = "Informe a coluna: ";
    static private final String MENSAGEM_ERRO = "Jogada inválida, informe a linha e coluna de 0 a 3, combinando os valores para formar a jogada.\n";
    static private final String POSICAO_PREENCHIDA = "Esta posição já está preenchida, informe uma nova jogada. \n";
    private char[][] posicao = new char[3][3];
    private String[] historicoGanhador = new String[3];
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

    private void getPlacar() {
        int jogadorUm = 0, jogadorDois = 0, velha = 0;
        //por conta da exceção de quando compara com null
        try {
            for (int i = 0; i < historicoGanhador.length; i++) {
                if (historicoGanhador[i].equals("Jogador 1")) jogadorUm++;
                else if (historicoGanhador[i].equals("Jogador 2")) jogadorDois++;
                else if (historicoGanhador[i].equals("VELHA")) velha++;
            }
        } catch (NullPointerException e) {}
        System.out.println(SEPARADOR);
        System.out.println("O jogador 1 fez " + jogadorUm + " pontos.");
        System.out.println("O jogador 2 fez " + jogadorDois + " pontos.");
        if (velha != 0)System.out.println("Houveram " + velha + " empates (velha).");
        else System.out.println("Não houveram empates (velha)");
        System.out.println(SEPARADOR);
        if (jogadorUm == 3 || jogadorUm == 2) System.out.println("O vencedor foi o jogador 1!");
        else if (velha == 2 && jogadorUm == 1) System.out.println("O vencedor foi o jogador 1!");
        if (jogadorDois == 3 || jogadorDois == 2) System.out.println("O vencedor foi o jogador 2!");
        else if (velha == 2 && jogadorDois == 1) System.out.println("O vencedor foi o jogador 2!");
        if (velha == 3) System.out.println("Não houve vencedores");
    }

    private void imprimePlacar() {
        for (int i = 0; i < historicoGanhador.length; i++) {
            if (historicoGanhador[i] != null) System.out.println((i + 1) + "ª Rodada - " + historicoGanhador[i]);
        }
    }

    public boolean verificaSegundaRodada() {
        int jogadorUm = 0, jogadorDois = 0, velha = 0;
        boolean fim = false;
        //por conta da exceção de quando compara com null
        try {
            for (int i = 0; i < historicoGanhador.length; i++) {
                if (historicoGanhador[i].equals("Jogador 1")) jogadorUm++;
                else if (historicoGanhador[i].equals("Jogador 2") && historicoGanhador[i] != null) jogadorDois++;
            }
        } catch (NullPointerException e) {
        }
        if (jogadorUm == 2) fim = true;
        else if (jogadorDois == 2) fim = true;
        return fim;
    }

    public void melhorDeTres() {
        System.out.println(MARCACAO);
        System.out.println(MELHOR_DE_TRES);
        int melhorDeTres = 1;
        do {
            switch (melhorDeTres) {
                case 1:
                    System.out.println(PRIMEIRA_RODADA);
                    break;
                case 2:
                    System.out.println(SEGUNDA_RODADA);
                    break;
                case 3:
                    System.out.println(TERCEIRA_RODADA);
                    break;
            }
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

            if (velha == 9) System.out.println("\nVELHA.");
            if (vencedor == 'X') {
                System.out.println("\nO jogador 1 venceu (X)");
            } else if (vencedor == 'O') {
                System.out.println("\nO jogador 2 venceu (O)");
            }
            setPlacar();
            //na segunda rodada verifica se o jogo já terminou, tendo duas vitórias
            if (melhorDeTres == 2 && verificaSegundaRodada()) {
                break;
            }
            melhorDeTres++;
            reset();
        } while (melhorDeTres != 4);
        System.out.println(SEPARADOR);
        System.out.println("\nRESULTADO");
        imprimePlacar();
        getPlacar();
        reset();
        new Menu().menu();
    }

}
//Exemplo para dar velha: 00 01 02 10 11 12 21 20 22
//Exemplo ganhar horizontalmente : 10 20 11 21 12
//Exemplo ganhar verticalmente : 01 02 11 12 21
//Exemplo ganhar diagonal : 20 21 11 22 02
//[0,0] | [0,1] | [0,2]
//[1,0] | [1,1] | [1,2]
//[2,0] | [2,1] | [2,2]