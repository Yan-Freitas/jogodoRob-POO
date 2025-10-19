package trabalhoPOO2NoTerminal;

public class Grid {
    public void mostrarGrid(Robo robo, Alimento comida){
        for(int i=4;i>=0;i--){
            for(int j=0;j<5;j++){
                if(robo.getPosicaoX()==j && robo.getPosicaoY()==i){
                    System.out.print("R|");
                }else if(comida.getPosicaoX()==j && comida.getPosicaoY()==i){
                    System.out.print("C|");
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
                    System.out.print("R1|");
                }else if(robo[1].getPosicaoX()==j && robo[1].getPosicaoY()==i){
                    System.out.print("R2|");
                }else if(comida.getPosicaoX()==j && comida.getPosicaoY()==i){
                    System.out.print("C|");
                }else{
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }
}
