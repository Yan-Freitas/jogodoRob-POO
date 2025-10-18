package trabalhoPOO2NoTerminal;

public class Robô {
	
	private int posicaoX;
	private int posicaoY;
	private int pontuacao;
	
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public Robô(int x, int y,int pontuacao){
		setPosicaoX(x);
		setPosicaoY(y);
		setPontuacao(pontuacao);
	}
	public Robô(){
		setPosicaoX(0);
		setPosicaoY(0);
		setPontuacao(0);
	}
	
	public Robô mover(String escolha, int x, int y, Robô robô){
		switch(escolha){
		case "up":
			try{
				if(robô.getPosicaoY()+1>y/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoY(robô.getPosicaoY()+1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
			break;
		case "down":
			try {
				if(robô.getPosicaoY()-1<-y/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoY(robô.getPosicaoY()-1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
			break;
		case "right":
			try{
				if(robô.getPosicaoX()+1>x/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoX(robô.getPosicaoX()+1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
			break;
		case "left":
			try{
				if(robô.getPosicaoX()-1<-x/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoX(robô.getPosicaoX()-1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
		}
		return robô;
	}
	public Robô mover(int escolha, int x, int y, Robô robô){
		switch(escolha){
		case 1:
			try{
				if(robô.getPosicaoY()+1>y/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoY(robô.getPosicaoY()+1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
			break;
		case 2:
			try {
				if(robô.getPosicaoY()-1<-y/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoY(robô.getPosicaoY()-1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
			break;
		case 3:
			try{
				if(robô.getPosicaoX()+1>x/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoX(robô.getPosicaoX()+1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
			break;
		case 4:
			try{
				if(robô.getPosicaoX()-1<-x/2){
					throw new ArithmeticException("Movimento inválido");
				}
				else {
					robô.setPosicaoX(robô.getPosicaoX()-1);
				}
			}
			catch(ArithmeticException e){
				System.err.println(e.getLocalizedMessage());
				return robô;
			}
		}

	return robô;
	}
	public int[] moverTracker(String escolha, int x, int y, int[] robôPosicaoTracker){
		switch(escolha){
			case "up":
				if(robôPosicaoTracker[1]-1<0){
				}
				else {
					robôPosicaoTracker[1]--;
				}
			break;
			case "down":
				if(robôPosicaoTracker[1]+1>y-1){
				}
				else {
					robôPosicaoTracker[1]++;
				}
			break;
			case "right":
				if(robôPosicaoTracker[0]+1>x-1){
				}
				else{
					robôPosicaoTracker[0]++;
				}
			break;
			case "left":
				if(robôPosicaoTracker[0]-1<0){
				}
				else{
					robôPosicaoTracker[0]--;
				}
		}
		return robôPosicaoTracker;
	}

	public int[] moverTracker(int escolha, int x, int y, int[] robôPosicaoTracker){
		switch(escolha){
			case 1:
				if(robôPosicaoTracker[1]-1<0){
				}
				else {
					robôPosicaoTracker[1]--;
				}
			break;
			case 2:
				if(robôPosicaoTracker[1]+1>y-1){
				}
				else {
					robôPosicaoTracker[1]++;
				}
			break;
			case 3:
				if(robôPosicaoTracker[0]+1>x-1){
				}
				else{
					robôPosicaoTracker[0]++;
				}
			break;
			case 4:
				if(robôPosicaoTracker[0]-1<0){
				}
				else{
					robôPosicaoTracker[0]--;
				}
		}
		return robôPosicaoTracker;
	}
	
	
}