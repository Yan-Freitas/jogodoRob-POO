package trabalhoPOO2NoTerminal;

public abstract class Obstaculo{
    private int id;
    private int posicaoX;
    private int posicaoY;

    public Obstaculo(int id, int indiceX, int indiceY) throws ForaDoLimiteGridException{
        this.id=id;
        if (indiceX <= 4 && indiceY <= 4) {
         this.posicaoX = indiceX;
         this.posicaoY = indiceY;
      } else {
         throw new ForaDoLimiteGridException();
      }
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getPosicaoX() {
      return this.posicaoX;
   }

   public void setPosicaoX(int var1) {
      this.posicaoX = var1;
   }

   public int getPosicaoY() {
      return this.posicaoY;
   }

   public void setPosicaoY(int var1) {
      this.posicaoY = var1;
   }

    public abstract void bater(Robo robo);
}