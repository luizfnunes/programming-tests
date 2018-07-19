package javalang.games.maiormenor;

import java.util.Random;
import java.util.Scanner;

public class MaiorMenor {
    /*
     * Attributes
    */
    private static double minBet;
    private static double maxBet;
    private static int maxValueDraw;
    private static int minValueDraw;
    private String name;
    private double money;
    private double bet;
    private double prize;
    private int[] drawNumbers = new int[2];
    private String awnser;
    Scanner scan = new Scanner(System.in);
    /*
     * Initializer block
     */
    static {
        MaiorMenor.minBet = 10;
        MaiorMenor.maxBet = 100;
        MaiorMenor.maxValueDraw = 10;
        MaiorMenor.minValueDraw = 1;
    }

    public MaiorMenor(double money) {
        this.money = money;
    }

    /*
     * Methods
     */
    private void removeMoney(double value){
        this.money -= value;
    }
    private void addMoney(double value){
        this.money -= value;
    }
    private void addPrize(double value){
        this.prize = value * 2;
    }
    private boolean setBet() {
        double valueBet;
        valueBet = scan.nextDouble();
        if (valueBet < MaiorMenor.minBet || valueBet > MaiorMenor.maxBet) {
            this.messageDrawInvalid();
            return false;
        }
        this.bet = valueBet;
        this.removeMoney(valueBet);
        this.addPrize(valueBet);
        return true;
    }

    private void setDrawNumbers() {
        Random rand = new Random();
        this.drawNumbers[0] = rand.nextInt(MaiorMenor.maxValueDraw) + MaiorMenor.minValueDraw;
        this.drawNumbers[1] = rand.nextInt(MaiorMenor.maxValueDraw) + MaiorMenor.minValueDraw;
    }
    private boolean verifyAwnser(){
        if (this.drawNumbers[1] > this.drawNumbers[0]){
            if (this.awnser.equals("maior")){
                return true;
            }
            return false;
        }
        if (this.awnser.equals("maior")) {
            return false;
        }
        return true;
    }
    private boolean setAwnser() {
        if (this.awnser.equals("maior") || this.awnser.equals("menor")) {
            this.awnser = awnser;
            return true;
        }
        this.messageAwnserInvalid();
        return false;
    }
    private void pause(){
        Scanner pause = new Scanner(System.in);
        System.out.println("Aperte ENTER para continuar...");
        pause.nextLine();
    }
    /*
     * Messages from game
    */
    private void messageInitial() {
        System.out.println("Como gostaria de ser chamado?");
        this.name = scan.nextLine();
    }
    private void messageWelcome() {
        System.out.println("###############################################");
        System.out.println("Olá " + this.name + ", Bem vindo ao jogo maior menor!");
        System.out.println("Voce tem " + this.money + " R$");
        System.out.println("###############################################");
    }
    private void messageMenu() {
        System.out.println("O que deseja fazer?");
        System.out.println("[1] - apostar");
        System.out.println("[2] - sair");
        System.out.println("-----------------------------------");
    }
    private void messageBetting() {
        System.out.println("-----------------------------------");
        System.out.println("Vamos apostar? voce tem :" + this.money + " R$");
        System.out.println("Apostas comecam em "+MaiorMenor.minBet+" e terminam em "+MaiorMenor.maxBet+"!");
        System.out.println("Quanto deseja apostar, " + this.name + "?");
    }
    private void messageBetFinish() {
        System.out.println("-----------------------------------");
        System.out.println("Voce apostou " + this.bet + " R$");
        System.out.println("A aposta vale " + this.prize + " R$");
    }
    private void messageDrawInvalid() {
        System.out.println("O valor apostado eh invalido, tente novamente!");
    }
    private void messageDoorPrize() {
        System.out.println("-----------------------------------");
        System.out.println("O numero sorteado eh " + this.drawNumbers[0]);
        System.out.println("O proximo numero sera maior ou menor?");
    }
    private void messageAwnserInvalid() {
        System.out.println("Sua resposta eh invalida, responda apenas com maior ou menor!");
    }
    private void messageResult() {
        System.out.println("-----------------------------------");
        System.out.println("O numero sorteado foi " + this.drawNumbers[1]);
        System.out.println("Voce apostou que o numero seria " + this.awnser);
    }
    private void messageResultWin() {
        System.out.println("####################################");
        System.out.println("Voce acertou! Parabens!");
        System.out.println("O premio de " + this.prize + " R$ eh seu!");
        System.out.println("####################################");
        this.addMoney(this.prize);
    }

    private void messageResultLoose() {
        System.out.println("####################################");
        System.out.println("Que pena, voce Errou!");
        System.out.println("Tente novamente!");
        System.out.println("####################################");
    }
    /*
     * Run Game
    */
    public void run() {
        int menu;
        boolean validBet, validAwnser, isRun = true;
        this.messageInitial();
        while (true) {
            this.messageWelcome();
            this.messageMenu();
            menu = scan.nextInt();
            if (menu == 2) break;
            if (menu != 1) continue;
            this.messageBetting();
            do {
                validBet = this.setBet();
            } while (!validBet);
            this.setDrawNumbers();
            this.messageBetFinish();
            this.messageDoorPrize();
            do {
                this.awnser = scan.next();
                validAwnser = this.setAwnser();
            } while (!validAwnser);
            this.messageResult();
            if( this.verifyAwnser()){
                this.messageResultWin();
                this.pause();
                continue;
            }
            this.messageResultLoose();
            this.pause();
        }
    }
}