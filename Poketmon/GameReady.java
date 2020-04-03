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
			System.out.print("캐릭터를 선택해주세요.\n1. 지우\t2. 이슬이\t3. 웅이\t4. 로사\t5. 로이: ");
			inputNumber = s.nextInt();
			if(inputNumber == 1){ checkName = "지우"; }
			if(inputNumber == 2){ checkName = "이슬이"; }
			if(inputNumber == 3){ checkName = "웅이"; }
			if(inputNumber == 4){ checkName = "로사"; }
			if(inputNumber == 5){ checkName = "로이"; }
			System.out.print("\n당신의 이름은 " + checkName + "! 맞으십니까?(1: yes 2: no) : ");
			inputNumber = s.nextInt();
			if(inputNumber == 1){
				startCharacter = checkName;
				break; 
			}
		}
	}
	
	public static void setStartPoketmon(){
		try {
			System.out.println("\n\n\n안녕 난 오박사란다!");
			Thread.sleep(3000);
			System.out.println("포켓몬과 함께 포켓몬 월드에서 살아보지 않을래?");
			Thread.sleep(3000);
			System.out.println(startCharacter + "! 너가 가지고 싶은 포켓몬을 골라보렴!");
			Thread.sleep(3000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		while(true){
			System.out.print("1. 파이리          2. 꼬북이          3. 이상해씨          4. 피카츄: ");
			Scanner s = new Scanner(System.in);
			inputNumber = s.nextInt();
			if(inputNumber == 1){ checkName = "파이리"; }
			if(inputNumber == 2){ checkName = "꼬북이"; }
			if(inputNumber == 3){ checkName = "이상해씨"; }
			if(inputNumber == 4){ checkName = "피카츄"; }
			System.out.println("오 " + checkName + "(을)를 골랐구나! 이 포켓몬으로 선택을 하겠니?");
			System.out.print("1. Yes      2. No : ");
			inputNumber = s.nextInt();
			if(inputNumber == 1){
				startPoketmon = checkName;
				break;
			}
			System.out.println("다시 한번 골라보렴!");
		}
	}
	
	public static void gameReadyFinish(){
		try {
			System.out.println("\n\n\n"+ startCharacter + "! 준비는 되었니?");
			Thread.sleep(2000);
			System.out.println("꿈과 모험이 가득한 포켓몬스터 세계에!\nLet's Go!");
			Thread.sleep(2000);
			System.out.println("그럼 다음에 다시 만나자!");
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
