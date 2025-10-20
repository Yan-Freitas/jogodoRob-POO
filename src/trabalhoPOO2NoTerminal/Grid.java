package trabalhoPOO2NoTerminal;

import java.util.ArrayList;

public class Grid {
    public void mostrarGrid(Robo robo, Alimento comida){
        for(int i=4;i>=0;i--){
            for(int j=0;j<5;j++){
                if(robo.getPosicaoX()==j && robo.getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("R", robo.getCor()) + "|");
                }else if(comida.getPosicaoX()==j && comida.getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("C", Texto.VERMELHO) + "|");
                }else{
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }

    public void mostrarGrid(Robo[] robo, Alimento comida){
        for(int i=4;i>=0;i--){
            for(int j=0;j<5;j++){
                if(robo[0].getPosicaoX()==j && robo[0].getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("R", robo[0].getCor()) + "|");
                }else if(robo[1].getPosicaoX()==j && robo[1].getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("R", robo[1].getCor()) + "|");
                }else if(comida.getPosicaoX()==j && comida.getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("C", Texto.VERMELHO) + "|");
                }else{
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }

    public void mostrarGrid(Robo[] robo, Alimento comida, ArrayList<Obstaculo> obstaculos){
        for(int i=4;i>=0;i--){
            for(int j=0;j<5;j++){
                Obstaculo obstaculo = null;
                for (Obstaculo obs : obstaculos) {
                    if (obs.getPosicaoX() == j && obs.getPosicaoY() == i) {
                        obstaculo = obs;
                    }
                }

                if(robo[0].getPosicaoX()==j && robo[0].getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("R", robo[0].getCor()) + "|");
                }else if(robo[1].getPosicaoX()==j && robo[1].getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("R", robo[1].getCor()) + "|");
                }else if(comida.getPosicaoX()==j && comida.getPosicaoY()==i){
                    System.out.print(Texto.textoColorido("C", Texto.VERMELHO) + "|");
                }else if (obstaculo != null){
                    System.out.printf("%s|", obstaculo.getId() == 1 ? "S" : "B");
                }else{
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }

    
}