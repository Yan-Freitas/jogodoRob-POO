package trabalhoPOO2NoTerminal;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		boolean jogoAtivo = true;
		Scanner scanner = new Scanner(System.in);
		int opcao;
        do{
            System.out.println("---Menu Inicial---");
            System.out.println("1) Robô Controlado pelo Usuário");
			System.out.println("2) Robôs Automáticos");
			System.out.println("3) Robô Inteligente e Robô Burro");
            System.out.println("4) Robôs e Obstáculos");
            System.out.println("5) Sair");
            do{
                System.out.print("Digite uma opção válida: ");
                opcao=scanner.nextInt();
            }while(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4 && opcao!=5);
            if(opcao==1){
                Robo robo;
                int cor;
                System.out.println("---Cor do Robô---");
                System.out.println("1) Azul");
                System.out.println("2) Vermelho");
                System.out.println("3) Verde");
                System.out.println("4) Rosa");
                do{
                    System.out.print("Digite uma opção válida: ");
                    cor=scanner.nextInt();
                }while(cor!=1 && cor!=2 && cor!=3 && cor!=4);
                if(cor==1){
                    robo=new Robo("AZUL");
                }else if(cor==2){
                    robo=new Robo("VERMELHO");
                }else if(cor==3){
                    robo=new Robo("VERDE");
                }else{
                    robo=new Robo("ROSA");
                }
                System.out.println("---Posição do Alimento---");
                int x,y;
                boolean valido=false;
                Alimento comida=null;
                do{
                    try{
                        System.out.print("Indice x: ");
                        x=scanner.nextInt();
                        System.out.print("Indice y: ");
                        y=scanner.nextInt();
                        comida=new Alimento(x, y);
                        valido=true;
                    }catch(ForaDoLimiteGridException e){
                        System.out.println(e.getMessage());
                        System.out.println("Tente Novamente");
                    }
                }while(!valido);
                int movimento;
                Grid grid=new Grid();
                grid.mostrarGrid(robo, comida);
                do{
                    System.out.println("---Movimento do Robô---");
                    System.out.println("1) Up");
                    System.out.println("2) Down");
                    System.out.println("3) Right");
                    System.out.println("4) Left");
                    valido=false;
                    do{
                        do{
                            System.out.print("Digite uma opção válida: ");
                            movimento=scanner.nextInt();
                        }while(movimento!=1 && movimento!=2 && movimento!=3 && movimento!=4);
                        try{
                            robo.mover(movimento);
                            robo.setPontuacao(robo.getPontuacao()+1);
                            valido=true;
                        } catch (MovimentoInvalidoException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Tente Novamente");
                        } catch (ForaDoLimiteGridException e){
                            System.out.println(e.getMessage());
                            System.out.println("Tente Novamente");
                        }
                    }while(!valido);
                    grid.mostrarGrid(robo, comida);
                }while(!robo.encontrarAlimento(comida));
                System.out.println("Robô encontrou a comida!");
                System.out.println("Pontuação Jogador: "+robo.getPontuacao());
				System.out.println("Posição Jogador: "+"("+robo.getPosicaoX()+","+robo.getPosicaoY()+")");
				System.out.println("Escolha a direção que quer ir ou escreva cancelar para acabar.");
            }else if(opcao==2){
				Robo robo1=new Robo("Azul");
				Robo robo2=new Robo("Vermelho");
				Robo[] robos={robo1, robo2};
				System.out.println("---Posição do Alimento---");
                int x,y;
                boolean valido=false;
                Alimento comida=null;
                do{
                    try{
                        System.out.print("Indice x: ");
                        x=scanner.nextInt();
                        System.out.print("Indice y: ");
                        y=scanner.nextInt();
                        comida=new Alimento(x, y);
                        valido=true;
                    }catch(ForaDoLimiteGridException e){
                        System.out.println(e.getMessage());
                        System.out.println("Tente Novamente");
                    }
                }while(!valido);
                Grid grid=new Grid();
				grid.mostrarGrid(robos, comida);
				String continuar;
				do{
					try{
						robo1.mover();
						robo2.mover();
					}catch(MovimentoInvalidoException e){
						System.out.println(e.getMessage());
                        System.out.println("Tente Novamente");
					}catch(ForaDoLimiteGridException e){
						System.out.println(e.getMessage());
                        System.out.println("Tente Novamente");
					}
					grid.mostrarGrid(robos, comida);
					System.out.println("Aperte ENTER para continuar: ");
					continuar=scanner.nextLine();
				}while(!robo1.encontrarAlimento(comida) && !robo2.encontrarAlimento(comida));
				System.out.println("Robô encontrou a comida!");
                System.out.println("---Robô 1---");
                System.out.println("Pontuação Jogador: "+robo1.getPontuacao());
                System.out.println("Movimentos Válidos: "+robo1.getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robo1.getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robo1.getPosicaoX()+","+robo1.getPosicaoY()+")");
                System.out.println("---Robô 2---");
				System.out.println("Pontuação Jogador: "+robo2.getPontuacao());
                System.out.println("Movimentos Válidos: "+robo2.getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robo2.getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robo2.getPosicaoX()+","+robo2.getPosicaoY()+")");
				System.out.println("Escolha a direção que quer ir ou escreva cancelar para acabar.");
			}else if(opcao==3){
				Robo roboBurro=new Robo("Azul");
				RoboInteligente roboInteligente=new RoboInteligente("Vermelho");
				Robo[] robos={roboBurro, roboInteligente};
				System.out.println("---Posição do Alimento---");
                int x,y;
                boolean valido=false;
                Alimento comida=null;
                do{
                    try{
                        System.out.print("Indice x: ");
                        x=scanner.nextInt();
                        System.out.print("Indice y: ");
                        y=scanner.nextInt();
                        comida=new Alimento(x, y);
                        valido=true;
                    }catch(ForaDoLimiteGridException e){
                        System.out.println(e.getMessage());
                        System.out.println("Tente Novamente");
                    }
                }while(!valido);
                Grid grid=new Grid();
                grid.mostrarGrid(robos, comida);
			}else if(opcao==4){

            }else{
                jogoAtivo=false;
            }
        }while(jogoAtivo);
        scanner.close();
	}
}

