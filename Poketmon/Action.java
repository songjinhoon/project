package Project01;

import java.util.Scanner;

public class Action {
	public static Scanner s = new Scanner(System.in);
	int b =50;
	int a = b;
	public static char mainAction(){
		// 미니맵에서 선택하는 액션 선택 기능
		System.out.print("[w:↑, a:←, s:↓, d:→][Menu:0][Exit:q]: ");
		char input = s.next().charAt(0);
		return input;
	}
	
	public static int subAction(){
		// 메뉴에서 선택하는 액션 기능
		System.out.println("■■■■  Menu  ■■■■");
		System.out.println("1. Hostpital    ");
		System.out.println("2. MyPoketmon   ");
		System.out.println("3. MyIf         ");
		System.out.println("4. PoketmonList ");
		System.out.println("5. UserList       ");
		System.out.println("6. Return     ");
		System.out.print("\n▶▶   SelectNumber: ");
		int input = s.nextInt();
		return input;
	}
	
	public static int poketmonListMainAction(){
		System.out.println("▶▶PoketmonList\n");
		PoketmonList.poketmonListPrint();
		System.out.print("\n1. 포켓몬 자세히보기          2. 돌아가기: ");
		int input = s.nextInt();
		return input;
	}
	
	public static void poketmonListSubAction(){
		System.out.print("포켓몬 번호 입력: ");
		int input = s.nextInt()-1;
		Poketmon poketmon = PoketmonList.getPoketmon(input);
		PoketmonList.poektmonInfoListPrint(poketmon);
		System.out.print("\n1. 돌아가기: ");
		input = s.nextInt();
	}
	
}
