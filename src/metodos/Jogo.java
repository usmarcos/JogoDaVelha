package metodos;

import menu.Menu;

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
            //na segunda rodada verifica se o jogo já terminou, tendo duas vitórias
            if (melhorDeTres == 2 && verificaSegundaRodada()) {
                break;
            }
            melhorDeTres++;
            reset();
        } while (melhorDeTres != 4);
        System.out.println(SEPARADOR);
        System.out.println(RESULTADO);
        imprimePlacar();
        getPlacar();
        reset();
        new Menu().menu();
    }
}
