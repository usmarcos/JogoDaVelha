package metodos;

import java.util.Scanner;
public class Jogada extends Mensagens {
    private char[][] posicao = new char[3][3];
    private String[] historicoGanhador = new String[3];
    int linha, coluna, velha;
    boolean continuar, fimJogo = false, continuaJogo = true;
    char controle, vencedor;

    protected char getJogadaJogadorUm() {
        System.out.println(SEPARADOR);
        System.out.println(JOGADA_JOGADOR_UM);
        do {
            continuar = false;
            System.out.print(POSICAO_LINHA);
            linha = new Scanner(System.in).nextInt();
            System.out.print(POSICAO_COLUNA);
            coluna = new Scanner(System.in).nextInt();
            if ((linha < 0 || linha >= 3) || (coluna < 0 || coluna >= 3)) {
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

    protected char getJogadaJogadorDois() {
        System.out.println(SEPARADOR);
        System.out.println(JOGADA_JOGADOR_DOIS);
        do {
            continuar = false;
            System.out.print(POSICAO_LINHA);
            linha = new Scanner(System.in).nextInt();
            System.out.print(POSICAO_COLUNA);
            coluna = new Scanner(System.in).nextInt();
            if ((linha < 0 || linha >= 3) || (coluna < 0 || coluna >= 3)) {
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

    protected void jogada(char controle) {
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

    protected boolean verificarGanhador() {
        verificarLinha();
        verificarColunas();
        verificariagonais();
        if (vencedor == 'X' || vencedor == 'O') fimJogo = true;
        return fimJogo;
    }

    protected void reset() {
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

    /**
     * Melhor de três
     */
    protected void setPlacar() {
        String historico;
        historico = vencedor == 'X' ? "Jogador 1" : vencedor == 'O' ? "Jogador 2" : "VELHA";
        for (int i = 0; i < historicoGanhador.length; i++) {
            if (historicoGanhador[i] == null) {
                historicoGanhador[i] = historico;
                break;
            }
        }
    }

    protected void getPlacar() {
        int jogadorUm = 0, jogadorDois = 0, velha = 0;
        //por conta da exceção de quando compara com null
        try {
            for (int i = 0; i < historicoGanhador.length; i++) {
                if (historicoGanhador[i].equals("Jogador 1")) jogadorUm++;
                else if (historicoGanhador[i].equals("Jogador 2")) jogadorDois++;
                else if (historicoGanhador[i].equals("VELHA")) velha++;
            }
        } catch (NullPointerException e) {
        }
        System.out.println(SEPARADOR);
        System.out.printf(PONTOS_JOGADOR_UM, jogadorUm);
        System.out.printf(PONTOS_JOGADOR_DOIS, jogadorDois);
        if (velha != 0) System.out.printf(VELHA, velha);
        else if (velha == 3) System.out.println(SEM_VENCEDORES);
        System.out.println(SEPARADOR);
        if (jogadorUm == 3 || jogadorUm == 2) System.out.println(VENCEDOR_UM);
        else if (velha == 2 && jogadorUm == 1) System.out.println(VENCEDOR_UM);
        if (jogadorDois == 3 || jogadorDois == 2) System.out.println(VENCEDOR_DOIS);
        else if (velha == 2 && jogadorDois == 1) System.out.println(VENCEDOR_DOIS);
        if (velha == 3 && jogadorUm == 1) System.out.println(NAO_HOUVERAM_VENCEDORES);
        else if (velha == 3 && jogadorDois == 1) System.out.println(NAO_HOUVERAM_VENCEDORES);
    }

    protected void imprimePlacar() {
        for (int i = 0; i < historicoGanhador.length; i++) {
            if (historicoGanhador[i] != null) System.out.println((i + 1) + "ª Rodada - " + historicoGanhador[i]);
        }
    }

    public boolean verificaSegundaRodada() {
        int jogadorUm = 0, jogadorDois = 0;
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


}
//Exemplo para dar velha: 00 01 02 10 11 12 21 20 22
//Exemplo ganhar horizontalmente : 10 20 11 21 12
//Exemplo ganhar verticalmente : 01 02 11 12 21
//Exemplo ganhar diagonal : 20 21 11 22 02
//[0,0] | [0,1] | [0,2]
//[1,0] | [1,1] | [1,2]
//[2,0] | [2,1] | [2,2]