package trabalhoPOO2NoTerminal;

public class Alimento {
	   private int posicaoX;
	   private int posicaoY;

	   public Alimento(int var1, int var2) throws ForaDoLimiteGridException {
	      if (var1 <= 4 && var2 <= 4 && var1 >=0 && var2 >= 0) {
	         this.posicaoX = var1;
	         this.posicaoY = var2;
	      } else {
	         throw new ForaDoLimiteGridException();
	      }
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
	}