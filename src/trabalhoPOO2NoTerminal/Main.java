package trabalhoPOO2NoTerminal;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static int[] setarPosicaoComida(int x, int y, int[] robôPosicaoTracker){
		boolean éIgual = true;
		int[] comidaPosicaoTracker = new int[2];
		Random random = new Random();
		while(éIgual == true){
			comidaPosicaoTracker[0] = random.nextInt(x);
			comidaPosicaoTracker[1] = random.nextInt(y);
			if(comidaPosicaoTracker[0]==robôPosicaoTracker[0]&&comidaPosicaoTracker[1]==robôPosicaoTracker[1]){
				System.out.print(robôPosicaoTracker[0]);
				continue;
			}
			else {
				éIgual=false;
			}
		}
		return comidaPosicaoTracker;
	}
	
	public static int[] moverRobô(String escolha, int x, int y, int[] robôPosicaoTracker){
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
	
	public static void main(String args[]){
		
		int tamanhoY = 7;
		int tamanhoX = 11;
		int[] robôPosicaoTracker = {tamanhoX/2,tamanhoY/2};
		int[] comidaPosicaoTracker = new int[2];
		comidaPosicaoTracker = setarPosicaoComida(tamanhoX,tamanhoY,robôPosicaoTracker);
		boolean jogoAtivo = true;
		Scanner scanner = new Scanner(System.in);
		Robô robô = new Robô();
		
		while(jogoAtivo == true) {
			String escolha = new String();
			for(int y = 0;y<tamanhoY;y++) {
				for(int x = 0;x<tamanhoX;x++){
					if(x == robôPosicaoTracker[0] && y == robôPosicaoTracker[1]){
						System.out.print("#");
					}
					else if(x == comidaPosicaoTracker[0] && y == comidaPosicaoTracker[1]){
						System.out.print("O");
					}
					else {
						System.out.print("-");
					}
				}
				System.out.println(" ");
			}
			System.out.println("Pontuação: "+robô.getPontuacao());
			System.out.println("Posição: "+"("+robô.getPosicaoX()+","+robô.getPosicaoY()+")");
			System.out.println("Escolha a direção que quer ir ou escreva cancelar para acabar.");
			escolha = scanner.next();
			robôPosicaoTracker = moverRobô(escolha,tamanhoX,tamanhoY,robôPosicaoTracker);
			robô = robô.mover(escolha,tamanhoX,tamanhoY,robô);
			if(comidaPosicaoTracker[0]==robôPosicaoTracker[0]&&comidaPosicaoTracker[1]==robôPosicaoTracker[1]){
				comidaPosicaoTracker = setarPosicaoComida(tamanhoX,tamanhoY,robôPosicaoTracker);
				robô.setPontuacao(robô.getPontuacao()+1);
			}
			else if(escolha.contentEquals("cancelar")){
				jogoAtivo = false;
			}
		}
	}
}
