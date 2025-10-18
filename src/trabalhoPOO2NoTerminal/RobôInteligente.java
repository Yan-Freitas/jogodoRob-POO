package trabalhoPOO2NoTerminal;

import java.util.Random;

public class RobôInteligente extends Robô{
	
	public RobôInteligente(int x, int y,int pontuacao){
		super.setPosicaoX(x);
		super.setPosicaoY(y);
		super.setPontuacao(pontuacao);
	}
	public RobôInteligente(){
		super.setPosicaoX(0);
		super.setPosicaoY(0);
		super.setPontuacao(0);
	}
	public int gerarAção(){
		Random random = new Random();
		return random.nextInt(4)+1;
	}
	public RobôInteligente mover(int x, int y,int escolha, RobôInteligente robô){
		switch(escolha){
		case 1:
			if(robô.getPosicaoY()+1>y/2){
				robô.setPosicaoY(robô.getPosicaoY()-1);
			}
			else {
				robô.setPosicaoY(robô.getPosicaoY()+1);
			}
			break;
		case 2:
			if(robô.getPosicaoY()-1<-y/2){
				robô.setPosicaoY(robô.getPosicaoY()+1);
			}
			else {
				robô.setPosicaoY(robô.getPosicaoY()-1);
			}
			break;
		case 3:
			if(robô.getPosicaoX()+1>x/2){
				robô.setPosicaoX(robô.getPosicaoX()-1);
			}
			else {
				robô.setPosicaoX(robô.getPosicaoX()+1);
			}
		
			break;
		case 4:
			if(robô.getPosicaoX()-1<-x/2){
				robô.setPosicaoX(robô.getPosicaoX()+1);
			}
			else {
				robô.setPosicaoX(robô.getPosicaoX()-1);
			}
		}
	return robô;
	}
	public int[] moverTrackerInt(int escolha, int x, int y, int[] robôPosicaoTracker){
		switch(escolha){
			case 1:
				if(robôPosicaoTracker[1]-1<0){
					robôPosicaoTracker[1]++;
				}
				else {
					robôPosicaoTracker[1]--;
				}
			break;
			case 2:
				if(robôPosicaoTracker[1]+1>y-1){
					robôPosicaoTracker[1]--;
				}
				else {
					robôPosicaoTracker[1]++;
				}
			break;
			case 3:
				if(robôPosicaoTracker[0]+1>x-1){
					robôPosicaoTracker[0]--;
				}
				else{
					robôPosicaoTracker[0]++;
				}
			break;
			case 4:
				if(robôPosicaoTracker[0]-1<0){
					robôPosicaoTracker[0]++;
				}
				else{
					robôPosicaoTracker[0]--;
				}
		}
		return robôPosicaoTracker;
	}
	
}
