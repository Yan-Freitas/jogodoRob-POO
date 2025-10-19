package branchdaEllen;

import java.util.Random;

public class Robo {
	private String cor;
	private int posicaoX;
	private int posicaoY;
	private int posicaoAnteriorX;
	private int posicaoAnteriorY;
	private int movimentosValidos;
	private int movimentosInvalidos;
	private boolean ativo=true;
	private int pontuacao;

	public Robo(String cor, int indiceX, int indiceY, int movimentosValidos, int movimentosInvalidos, int pontuacao){
		this.cor=cor;
		this.posicaoX=indiceX;
		this.posicaoY=indiceY;
		this.movimentosValidos=movimentosValidos;
		this.movimentosInvalidos=movimentosInvalidos;
		this.pontuacao=pontuacao;
	}

	public Robo(String cor){
		this.cor=cor;
		this.posicaoX=0;
		this.posicaoY=0;
		this.movimentosValidos=0;
		this.movimentosInvalidos=0;
		this.pontuacao=0;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

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

	public int getPosicaoAnteriorX() {
		return posicaoAnteriorX;
	}

	public void setPosicaoAnteriorX(int posicaoX) {
		this.posicaoAnteriorX = posicaoX;
	}

	public int getPosicaoAnteriorY() {
		return posicaoAnteriorY;
	}

	public void setPosicaoAnteriorY(int posicaoY) {
		this.posicaoAnteriorY = posicaoY;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getMovimentosValidos() {
		return movimentosValidos;
	}
	public void setMovimentosValidos(int movimentosValidos) {
		this.movimentosValidos = movimentosValidos;
	}

	public int getMovimentosInvalidos() {
		return movimentosInvalidos;
	}
	public void setMovimentosInvalidos(int movimentosInvalidos) {
		this.movimentosInvalidos = movimentosInvalidos;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int gerarAção(){
		Random random = new Random();
		return random.nextInt(4)+1;
	}
	
	public void mover(String escolha) throws MovimentoInvalidoException, ForaDoLimiteGridException{
		int x=posicaoX;
        int y=posicaoY;
        if(escolha.toUpperCase()=="UP"){
            y++;
        }else if(escolha.toUpperCase()=="DOWN"){
            y--;
        }else if(escolha.toUpperCase()=="RIGHT"){
            x++;
        }else if(escolha.toUpperCase()=="LEFT"){
            x--;
        }else{
            x=-1;
        }
        if(x<0 || y<0){
			movimentosInvalidos++;
            throw new MovimentoInvalidoException();
        }
        if(x>4 || y>4){
			movimentosInvalidos++;
            throw new ForaDoLimiteGridException();
        }
		posicaoAnteriorX=posicaoX;
		posicaoAnteriorY=posicaoY;
        posicaoX=x;
        posicaoY=y;
		movimentosValidos++;
	}

	public void mover(int escolha) throws MovimentoInvalidoException, ForaDoLimiteGridException{
		int x=posicaoX;
        int y=posicaoY;
        if(escolha==1){
            y++;
        }else if(escolha==2){
            y--;
        }else if(escolha==3){
            x++;
        }else if(escolha==4){
            x--;
        }else{
            x=-1;
        }
        if(x<0 || y<0){
			movimentosInvalidos++;
            throw new MovimentoInvalidoException();
        }
        if(x>4 || y>4){
			movimentosInvalidos++;
            throw new ForaDoLimiteGridException();
        }
		posicaoAnteriorX=posicaoX;
		posicaoAnteriorY=posicaoY;
        posicaoX=x;
        posicaoY=y;
		movimentosValidos++;
	}

	public void mover() throws MovimentoInvalidoException, ForaDoLimiteGridException{
		int escolha=gerarAção();
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
			setMovimentosInvalidos(getMovimentosInvalidos()+1);
            throw new MovimentoInvalidoException();
        }
        if(x>4 || y>4){
			setMovimentosInvalidos(getMovimentosInvalidos()+1);
            throw new ForaDoLimiteGridException();
        }
		posicaoAnteriorX=posicaoX;
		posicaoAnteriorY=posicaoY;
        setPosicaoX(x);
        setPosicaoY(y);
		setMovimentosValidos(getMovimentosValidos()+1);
	}

	public boolean encontrarAlimento(Alimento comida){
        if(comida.getPosicaoX()==posicaoX && comida.getPosicaoY()==posicaoY){
            return true;
        }else{
            return false;
        }
    }
}