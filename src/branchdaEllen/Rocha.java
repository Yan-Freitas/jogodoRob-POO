package branchdaEllen;

public class Rocha extends Obstaculo{
    public Rocha(int id, int indiceX, int indiceY)throws ForaDoLimiteGridException{
        super(id, indiceX, indiceY);
    }
    
    public void bater(Robo robo){
        robo.setPosicaoX(robo.getPosicaoAnteriorX());
        robo.setPosicaoY(robo.getPosicaoAnteriorY());
    }
}