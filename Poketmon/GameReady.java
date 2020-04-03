package Project01;

import java.util.Scanner;

public class GameReady extends GameLoading {
	private static String startCharacter;
	private static String startPoketmon;
	private static int inputNumber;
	private static String checkName = null;
	
	public static void gameLogo(){
		System.out.println("                                          XXXXXXXXX              XX      XXX     XX  XX                  ");
		System.out.println("                                       XXXXXXXXXXXXXX        XXX  XXXX  XXXXXXX  XXX  XX        XXXX     ");
        System.out.println("                                       XXXXXXXX   XXX        XXXXXXXXX XXX  XX   XXX XXX   XXXX XXXX XXX ");
        System.out.println("                                          XXXXX   XXX  XXXXXX XXXXX   XXXXXX     XXXXXXX XXXXXXX XXXXXXX ");
        System.out.println("                                           XXXXXXXXX XXX X XX XXXXXXXX XXXXXXXXX XX XX X XX    XX XXXXXX ");
        System.out.println("                                           XXXXXXXXX XXX  XXX XXX XXXX  XXXXXXX  XX XX X XXXXXX XXXXXXX  ");
        System.out.println("                                             XXXXX   XXXXXXXX XXX    XXX=XX      XX     X XXXXX XX XXXX  ");
        System.out.println("                                             XXXXX    XXXXX   XX       XXX                     XXX XXXX  ");
        System.out.println("                                              XXXX                                                 XXX   ");
        System.out.println("                                               XXXX                                                XXX   ");
	}
	
	public static void gameLoading(){
		try{
			for(int i=0; i<30; i++){ System.out.println(); }
			GameLoading.loading1();
			Thread.sleep(500);
			for(int i=0; i<47; i++){ System.out.println(); }
			GameLoading.loading2();
			Thread.sleep(500);
			for(int i=0; i<47; i++){ System.out.println(); }
			GameLoading.loading3();
			Thread.sleep(500);
			for(int i=0; i<47; i++){ System.out.println(); }
			GameLoading.loading4();
			Thread.sleep(500);
			for(int i=0; i<47; i++){ System.out.println(); }
			GameLoading.loading5();
			Thread.sleep(500);
			for(int i=0; i<47; i++){ System.out.println(); }
			GameLoading.loading6();
			Thread.sleep(500);
			for(int i=0; i<47; i++){ System.out.println(); }
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public static void setStartCharacter(){
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("ĳ���͸� �������ּ���.\n1. ����\t2. �̽���\t3. ����\t4. �λ�\t5. ����: ");
			inputNumber = s.nextInt();
			if(inputNumber == 1){ checkName = "����"; }
			if(inputNumber == 2){ checkName = "�̽���"; }
			if(inputNumber == 3){ checkName = "����"; }
			if(inputNumber == 4){ checkName = "�λ�"; }
			if(inputNumber == 5){ checkName = "����"; }
			System.out.print("\n����� �̸��� " + checkName + "! �����ʴϱ�?(1: yes 2: no) : ");
			inputNumber = s.nextInt();
			if(inputNumber == 1){
				startCharacter = checkName;
				break; 
			}
		}
	}
	
	public static void setStartPoketmon(){
		try {
			System.out.println("\n\n\n�ȳ� �� ���ڻ����!");
			Thread.sleep(3000);
			System.out.println("���ϸ�� �Բ� ���ϸ� ���忡�� ��ƺ��� ������?");
			Thread.sleep(3000);
			System.out.println(startCharacter + "! �ʰ� ������ ���� ���ϸ��� ��󺸷�!");
			Thread.sleep(3000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		while(true){
			System.out.print("1. ���̸�          2. ������          3. �̻��ؾ�          4. ��ī��: ");
			Scanner s = new Scanner(System.in);
			inputNumber = s.nextInt();
			if(inputNumber == 1){ checkName = "���̸�"; }
			if(inputNumber == 2){ checkName = "������"; }
			if(inputNumber == 3){ checkName = "�̻��ؾ�"; }
			if(inputNumber == 4){ checkName = "��ī��"; }
			System.out.println("�� " + checkName + "(��)�� �������! �� ���ϸ����� ������ �ϰڴ�?");
			System.out.print("1. Yes      2. No : ");
			inputNumber = s.nextInt();
			if(inputNumber == 1){
				startPoketmon = checkName;
				break;
			}
			System.out.println("�ٽ� �ѹ� ��󺸷�!");
		}
	}
	
	public static void gameReadyFinish(){
		try {
			System.out.println("\n\n\n"+ startCharacter + "! �غ�� �Ǿ���?");
			Thread.sleep(2000);
			System.out.println("�ް� ������ ������ ���ϸ��� ���迡!\nLet's Go!");
			Thread.sleep(2000);
			System.out.println("�׷� ������ �ٽ� ������!");
			Thread.sleep(2000);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public static String getStartPoketmon(){
		return startPoketmon;
	}
	
	public static String getStartCharacter(){
		return startCharacter;
	}
}
