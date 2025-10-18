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
	public static void main(String args[]){
		
		int tamanhoY = 7;
		int tamanhoX = 11;
		int[] robôPosicaoTracker = {tamanhoX/2,tamanhoY/2};
		int[] robôIntPosicaoTracker = {tamanhoX/2,tamanhoY/2};
		int[] comidaPosicaoTracker = new int[2];
		comidaPosicaoTracker = setarPosicaoComida(tamanhoX,tamanhoY,robôPosicaoTracker);
		boolean jogoAtivo = true;
		Scanner scanner = new Scanner(System.in);
		Robô robô = new Robô();
		RobôInteligente robôInt = new RobôInteligente();
		
		while(jogoAtivo == true) {
			for(int y = 0;y<tamanhoY;y++) {
				for(int x = 0;x<tamanhoX;x++){
					if(x == robôPosicaoTracker[0] && y == robôPosicaoTracker[1]){
						System.out.print("#");
					}
					else if(x == comidaPosicaoTracker[0] && y == comidaPosicaoTracker[1]){
						System.out.print("O");
					}
					else if(x == robôIntPosicaoTracker[0] && y == robôIntPosicaoTracker[1]){
						System.out.print("%");
					}
					else {
						System.out.print("-");
					}
				}
				System.out.println(" ");
			}
			
			System.out.println("Pontuação Jogador: "+robô.getPontuacao());
			System.out.println("Posição Jogador: "+"("+robô.getPosicaoX()+","+robô.getPosicaoY()+")");
			System.out.println("Pontuação Robô: "+robôInt.getPontuacao());
			System.out.println("Posição Robô: "+"("+robôInt.getPosicaoX()+","+robôInt.getPosicaoY()+")");
			System.out.println("Escolha a direção que quer ir ou escreva cancelar para acabar.");
			
			String entrada = scanner.nextLine();
			try {
				int escolha = Integer.parseInt(entrada);
				robô = robô.mover(escolha,tamanhoX,tamanhoY,robô);
				robôPosicaoTracker = robô.moverTracker(escolha,tamanhoX,tamanhoY,robôPosicaoTracker);
			}
			catch(NumberFormatException e){
				robô = robô.mover(entrada,tamanhoX,tamanhoY,robô);
				robôPosicaoTracker = robô.moverTracker(entrada,tamanhoX,tamanhoY,robôPosicaoTracker);
			}
			
			int escolhaInt = robôInt.gerarAção();
			System.out.println(escolhaInt);
			robôInt.mover(tamanhoX, tamanhoY, escolhaInt, robôInt);
			robôIntPosicaoTracker = robôInt.moverTrackerInt(escolhaInt, tamanhoX, tamanhoY, robôIntPosicaoTracker);
			
			if(comidaPosicaoTracker[0]==robôPosicaoTracker[0]&&comidaPosicaoTracker[1]==robôPosicaoTracker[1]){
				comidaPosicaoTracker = setarPosicaoComida(tamanhoX,tamanhoY,robôPosicaoTracker);
				robô.setPontuacao(robô.getPontuacao()+1);
			}
			else if(comidaPosicaoTracker[0]==robôIntPosicaoTracker[0]&&comidaPosicaoTracker[1]==robôIntPosicaoTracker[1]){
				comidaPosicaoTracker = setarPosicaoComida(tamanhoX,tamanhoY,robôPosicaoTracker);
				robôInt.setPontuacao(robôInt.getPontuacao()+1);
			}
			
		}
	}
}
