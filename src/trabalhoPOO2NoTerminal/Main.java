package trabalhoPOO2NoTerminal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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
                System.out.println("2) Amarelo");
                System.out.println("3) Verde");
                System.out.println("4) Roxo");
                do{
                    System.out.print("Digite uma opção válida: ");
                    cor=scanner.nextInt();
                }while(cor!=1 && cor!=2 && cor!=3 && cor!=4);
                if(cor==1){
                    robo=new Robo(Texto.AZUL);
                }else if(cor==2){
                    robo=new Robo(Texto.AMARELO);
                }else if(cor==3){
                    robo=new Robo(Texto.VERDE);
                }else{
                    robo=new Robo(Texto.ROXO);
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
				System.out.println("Posição Jogador: "+"("+robo.getPosicaoX()+","+robo.getPosicaoY()+")");
            }else if(opcao==2){
				Robo robo1=new Robo(Texto.AZUL);
				Robo robo2=new Robo(Texto.VERDE);
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
                scanner.nextLine();
				String continuar;
                System.out.println("Aperte ENTER para continuar: ");
                continuar=scanner.nextLine();
				do{
					for (int i = 0; i < 2; ++i) {
                        try{
                            robos[i].mover();
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
                        if (robos[i].encontrarAlimento(comida)) {
                            break;
                        }
                    }
				}while(!robo1.encontrarAlimento(comida) && !robo2.encontrarAlimento(comida));
				if(robo1.encontrarAlimento(comida)==true){
                    System.out.println("Robô 1 encontrou a comida!");
                }
                else {
                    System.out.println("Robô 2 encontrou a comida!");
                }
                System.out.println("---Robô 1---");
                System.out.println("Movimentos Válidos: "+robo1.getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robo1.getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robo1.getPosicaoX()+","+robo1.getPosicaoY()+")");
                System.out.println("---Robô 2---");
                System.out.println("Movimentos Válidos: "+robo2.getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robo2.getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robo2.getPosicaoX()+","+robo2.getPosicaoY()+")");
			}else if(opcao==3){
				Robo roboBurro=new Robo(Texto.AZUL);
				RoboInteligente roboInteligente=new RoboInteligente(Texto.VERDE);
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
                scanner.nextLine();
				String continuar;
                System.out.println("Aperte ENTER para continuar: ");
                continuar=scanner.nextLine();
                do{
					for (int i = 0; i < 2; ++i) {
                        if (!robos[i].getAtivo()) {
                            continue;
                        }
                        try{
                            robos[i].mover();
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
                        robos[i].encontrarAlimento(comida);

                    }
				}while(!robos[0].encontrarAlimento(comida) || !robos[1].encontrarAlimento(comida));
                System.out.println("Robôs encontraram a comida!");
                System.out.println("---Robô 1---");
                System.out.println("Movimentos Válidos: "+robos[0].getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robos[0].getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robos[0].getPosicaoX()+","+robos[0].getPosicaoY()+")");
                System.out.println("---Robô 2---");
                System.out.println("Movimentos Válidos: "+robos[1].getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robos[1].getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robos[1].getPosicaoX()+","+robos[1].getPosicaoY()+")");
			}else if(opcao==4){
                Robo roboBurro=new Robo(Texto.AZUL);
				RoboInteligente roboInteligente=new RoboInteligente(Texto.VERDE);
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

                System.out.print("Digite a quantidade de rochas(até 3): ");
                int qtdRochas = scanner.nextInt();
                while (qtdRochas < 1 || qtdRochas > 3) {
                    System.out.println("Valor inválido!");
                    System.out.print("Digite a quantidade de bombas(até 3): ");
                    qtdRochas = scanner.nextInt();
                }

                System.out.print("Digite a quantidade de bombas(até 3): ");
                int qtdBombas = scanner.nextInt();
                while (qtdBombas < 1 || qtdBombas > 3) {
                    System.out.println("Valor inválido!");
                    System.out.print("Digite a quantidade de bombas(até 3): ");
                    qtdBombas = scanner.nextInt();
                }
                
                for (int i = 0; i < qtdRochas; i++) {
                    valido=false;
                    Rocha rocha=null;
                    System.out.printf("---Posição da %d° Rocha---\n", i+1);
                    do{
                        try{
                            System.out.print("Indice x: ");
                            x=scanner.nextInt();
                            System.out.print("Indice y: ");
                            y=scanner.nextInt();
                            if (Obstaculo.procurarObstaculo(x, y) == null && (comida.getPosicaoX() != x || comida.getPosicaoY() != y) && (x != 0 || y != 0)) {
                                valido = true;
                                rocha=new Rocha(1, x, y);
                            } else {
                                System.out.println("Já existe algo nessa posição");
                                System.out.println("Tente Novamente");
                            }
                        }catch(ForaDoLimiteGridException e){
                            System.out.println(e.getMessage());
                            System.out.println("Tente Novamente");
                        }
                    }while(!valido);
                    grid.mostrarGrid(robos, comida, Obstaculo.getObstaculos());
                }
                for (int i = 0; i < qtdBombas; i++) {
                    valido=false;
                    Bomba bomba=null;
                    System.out.printf("---Posição da %d° bomba---\n", i+1);
                    do{
                        try{
                            System.out.print("Indice x: ");
                            x=scanner.nextInt();
                            System.out.print("Indice y: ");
                            y=scanner.nextInt();
                            if (Obstaculo.procurarObstaculo(x, y) == null && (comida.getPosicaoX() != x || comida.getPosicaoY() != y) && (x != 0 || y != 0)) {
                                valido = true;
                                bomba=new Bomba(2, x, y);
                            } else {
                                System.out.println("Já existe algo nessa posição");
                                System.out.println("Tente Novamente");
                            }
                        }catch(ForaDoLimiteGridException e){
                            System.out.println(e.getMessage());
                            System.out.println("Tente Novamente");
                        }
                    }while(!valido);
                    grid.mostrarGrid(robos, comida, Obstaculo.getObstaculos());
                }
                scanner.nextLine();
				String continuar;
                System.out.println("Aperte ENTER para continuar: ");
                continuar=scanner.nextLine();
                do{
                    for (int i = 0; i < 2; ++i) {
                        if (!robos[i].getAtivo()) {
                            continue;
                        }
                        try{
                            robos[i].mover();
                        }catch(MovimentoInvalidoException e){
                            System.out.println(e.getMessage());
                            System.out.println("Tente Novamente");
                        }catch(ForaDoLimiteGridException e){
                            System.out.println(e.getMessage());
                            System.out.println("Tente Novamente");
                        }
                        grid.mostrarGrid(robos, comida, Obstaculo.getObstaculos());
                        System.out.println("Aperte ENTER para continuar: ");
                        continuar=scanner.nextLine();
                        if (robos[i].encontrarAlimento(comida)) {
                            break;
                        }
                    }
				}while((!robos[0].encontrarAlimento(comida) && !robos[1].encontrarAlimento(comida)) && (robos[0].getAtivo() || robos[1].getAtivo()));
                if(robos[0].encontrarAlimento(comida)==true){
                    System.out.println("O robô 1 encontrou a comida!");
                }
                else if(robos[1].encontrarAlimento(comida)){
                    System.out.println("O robô 2 encontrou a comida!");
                }

                System.out.println("Acabou!");
                System.out.println("---Robô 1---");
                System.out.println("Movimentos Válidos: "+robos[0].getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robos[0].getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robos[0].getPosicaoX()+","+robos[0].getPosicaoY()+")");
                System.out.println("---Robô 2---");
                System.out.println("Movimentos Válidos: "+robos[1].getMovimentosValidos());
                System.out.println("Movimentos Inválidos: "+robos[1].getMovimentosInvalidos());
				System.out.println("Posição Jogador: "+"("+robos[1].getPosicaoX()+","+robos[1].getPosicaoY()+")");
            }else{
                jogoAtivo=false;
            }
        }while(jogoAtivo);
        scanner.close();
	}
}