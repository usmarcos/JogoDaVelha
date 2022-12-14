package metodos;

import menu.Menu;

import java.util.Scanner;

public class Jogo extends Jogada {
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
        if (velha == 9) System.out.println(SEM_VENCEDORES);
        if (vencedor == 'X') {
            System.out.println(VENCEDOR_X);
        } else if (vencedor == 'O') {
            System.out.println(VENCEDOR_O);
        }
        reset();
        new Menu().menu();
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

            if (velha == 9) System.out.println(SEM_VENCEDORES);
            if (vencedor == 'X') {
                System.out.println(VENCEDOR_X);
            } else if (vencedor == 'O') {
                System.out.println(VENCEDOR_O);
            }
            setPlacar();
            //na segunda rodada verifica se o jogo j?? terminou, tendo duas vit??rias
            if (melhorDeTres == 2 && verificaSegundaRodada()) {
                break;
            }
            melhorDeTres++;
            reset();
        } while (melhorDeTres != 4);
        System.out.println(SEPARADOR);
        System.out.println(RESULTADO);
        imprimePlacar();
        getPlacar(melhorDeTres);
        reset();
        new Menu().menu();
    }

    public void quantidadePartidas() {
        boolean continuar;
        System.out.println(MARCACAO);
        System.out.println(QUANTIDADE_DE_PARTIDAS);
        int rodada = 0, rodadas;
        //valida se op????o inserida ?? v??lida
        do {
            continuar = false;
            System.out.print(PERGUNTA_QUANTIDADE_PARTIDAS);
            rodadas = new Scanner(System.in).nextInt();
            if (rodadas <= 1 || rodadas > 100) {
                System.out.println(QUANTIDADE_PARTIDAS_INVALIDO);
                continuar = true;
            }
        } while (continuar);
        //criando essa vari??vel para armazenar o n??mero de rodadas original para gerar o placar corretamente
        rodada = rodadas;
        do {
            //for para ir exibindo a quantidade de rodadas
            for (int i = 1; i <= rodadas; i++) {
                System.out.printf(RODADA, i);
                do {
                    //se j?? tiverem 9 jogadas da velha e termina o jogo
                    if (velha == 9) continuaJogo = false;
                        //se for falso passa ou pode ser usado verificarGanhador()==false;
                    else if (!verificarGanhador()) {
                        controle = getJogadaJogadorUm();
                        jogada(controle);
                        velha++;
                    } else continuaJogo = false;
                    //se j?? tiverem 9 jogadas da velha e termina o jogo
                    if (velha == 9) continuaJogo = false;
                        //se for falso passa ou pode ser usado verificarGanhador()==false;
                    else if (!verificarGanhador()) {
                        controle = getJogadaJogadorDois();
                        jogada(controle);
                        velha++;
                    } else continuaJogo = false;
                } while (continuaJogo);
                //impress??o na tela
                if (velha == 9) {
                    System.out.println(SEM_VENCEDORES);
                } else if (vencedor == 'X') {
                    System.out.println(VENCEDOR_X);
                } else if (vencedor == 'O') {
                    System.out.println(VENCEDOR_O);
                }
                setPlacar();
                rodadas--;
                reset();
            }
        } while (rodadas != 0);
        System.out.println(SEPARADOR);
        System.out.println(RESULTADO);
        imprimePlacar();
        //passando o n??mero de rodadas iniciada pelo usu??rio
        getPlacar(rodada);
        reset();
        new Menu().menu();
    }
}
