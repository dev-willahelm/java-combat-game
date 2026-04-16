import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String tipoJogador = "Herói";
        int vidaDoJogador = 100;
        int ataqueHeroi = 30;
        int poção = 5;
        int menu;

        String[] inimigos = {"Goblin","Orc","Dragão"};
        int[] vidaInimigo = {80, 110, 150};
        int[] ataqueInimigo = {15, 20, 30};

        int inimigoAtual = 0;

        System.out.println("HP: " + vidaDoJogador + " \nVS \n" + inimigos[inimigoAtual] + " HP : " + vidaInimigo[inimigoAtual]);

        do{

            System.out.println("1 - Atacar" + "\n2 - Curar");

            menu = scanner.nextInt();

            switch(menu){
                case 1:
                    System.out.println("-------------------------");
                    vidaInimigo[inimigoAtual] -= ataqueHeroi;
                    System.out.println("Você atacou! HP Inimigo: " + vidaInimigo[inimigoAtual]);
                    break;
                case 2:{
                    if (poção > 0){
                        poção--;
                        vidaDoJogador = Math.min(vidaDoJogador +45, 100);
                        System.out.println("Você se curou! 45+ HP em:" + vidaDoJogador);
                    }else{
                        poção = 0;
                        System.out.println("Você está sem poções!");
                    }
                    break;
                }
                default:{
                    System.out.println("Opção invalida.");
                }
            }
            System.out.println("-------------------------");
            if (vidaInimigo[inimigoAtual] > 0){
                vidaDoJogador -= ataqueInimigo[inimigoAtual];
                System.out.println("Você foi atacado! Seu HP: " + vidaDoJogador);
                System.out.println("-------------------------");
            }if (vidaInimigo[inimigoAtual] <= 0){
                System.out.println(inimigos[inimigoAtual]+ " Derrotado! - Seu HP: " + vidaDoJogador);
                inimigoAtual++;
                poção++;
                System.out.println("Você encontrou uma poção nos espólios da luta. Total: " + poção + " poções.");
                if (inimigoAtual < inimigos.length){
                    System.out.println("-------------------------");
                    System.out.println("Um " + inimigos[inimigoAtual] + " apareceu no caminho! HP " + inimigos[inimigoAtual] + ": " + vidaInimigo[inimigoAtual]);
                }
            }
        }while (vidaDoJogador > 0 && inimigoAtual < inimigos.length);
        if (vidaDoJogador > 0){
            System.out.println("Você venceu! Derrotou o Dragão primordial e trouxe paz para a humanidade!");
        }else{
            System.out.println("Você perdeu! Não há mais esperança...\n" + inimigos[inimigoAtual] + " HP: " + vidaInimigo[inimigoAtual]);
        }
    }
}