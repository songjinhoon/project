package Project01;

import java.util.Scanner;

public class Action {
	public static Scanner s = new Scanner(System.in);
	int b =50;
	int a = b;
	public static char mainAction(){
		// �̴ϸʿ��� �����ϴ� �׼� ���� ���
		System.out.print("[w:��, a:��, s:��, d:��][Menu:0][Exit:q]: ");
		char input = s.next().charAt(0);
		return input;
	}
	
	public static int subAction(){
		// �޴����� �����ϴ� �׼� ���
		System.out.println("�����  Menu  �����");
		System.out.println("1. Hostpital    ");
		System.out.println("2. MyPoketmon   ");
		System.out.println("3. MyIf         ");
		System.out.println("4. PoketmonList ");
		System.out.println("5. UserList       ");
		System.out.println("6. Return     ");
		System.out.print("\n����   SelectNumber: ");
		int input = s.nextInt();
		return input;
	}
	
	public static int poketmonListMainAction(){
		System.out.println("����PoketmonList\n");
		PoketmonList.poketmonListPrint();
		System.out.print("\n1. ���ϸ� �ڼ�������          2. ���ư���: ");
		int input = s.nextInt();
		return input;
	}
	
	public static void poketmonListSubAction(){
		System.out.print("���ϸ� ��ȣ �Է�: ");
		int input = s.nextInt()-1;
		Poketmon poketmon = PoketmonList.getPoketmon(input);
		PoketmonList.poektmonInfoListPrint(poketmon);
		System.out.print("\n1. ���ư���: ");
		input = s.nextInt();
	}
	
}
