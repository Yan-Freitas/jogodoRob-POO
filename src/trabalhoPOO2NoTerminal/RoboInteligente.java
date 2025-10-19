package trabalhoPOO2NoTerminal;

import java.util.ArrayList;
import java.util.Random;

public class RoboInteligente extends Robo{
	private ArrayList<Integer> movimentosAnteriores = new ArrayList<>();

	public RoboInteligente(String cor, int indiceX, int indiceY, int movimentosValidos, int movimentosInvalidos, int pontuacao){
		super(cor, indiceX, indiceY, movimentosValidos, movimentosInvalidos,  pontuacao);
	}
	public RoboInteligente(String cor){
		super(cor);
	}
	public int gerarAção(){
		Random random = new Random();
		return random.nextInt(4)+1;
	}
	public void mover() throws MovimentoInvalidoException, ForaDoLimiteGridException{
		int escolha;
		do{
			escolha=gerarAção();
		}while(movimentosAnteriores.contains(escolha));
		int x=getPosicaoX();
		int y=getPosicaoY();
		switch(escolha){
		case 1:
			y++;
			break;
		case 2:
			y--;
			break;
		case 3:
			x++;
			break;
		case 4:
			x--;
			break;
		}
		if(x<0 || y<0){
			movimentosAnteriores.add(escolha);
			setMovimentosInvalidos(getMovimentosInvalidos()+1);
            throw new MovimentoInvalidoException();
        }
        if(x>4 || y>4){
			movimentosAnteriores.add(escolha);
			setMovimentosInvalidos(getMovimentosInvalidos()+1);
            throw new ForaDoLimiteGridException();
        }
		setPosicaoAnteriorX(getPosicaoX());
		setPosicaoAnteriorY(getPosicaoY());
        setPosicaoX(x);
        setPosicaoY(y);
		setMovimentosValidos(getMovimentosValidos()+1);
		movimentosAnteriores.clear();
	}
}
