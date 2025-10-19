package trabalhoPOO2NoTerminal;

public class Bomba extends Obstaculo{
    public Bomba(int id, int indiceX, int indiceY)throws ForaDoLimiteGridException{
        super(id, indiceX, indiceY);
    }

    @Override
    public void bater(Robo robo) {
        robo.setAtivo(false);
    }
}
