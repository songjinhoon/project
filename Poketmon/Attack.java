package Project01;

import java.util.Scanner;

public class Attack {

	private static int inputNumber;
	private static int skillnumber;
	private static int poketmonselect;
	private static int mypoketmonnumber;

	public static synchronized void attack(int youpoketmonnumber, Myif myif) {
		PoketmonList.setPoketmonList();
		Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
		Attackready.youAttackready(youpoketmonnumber);
		Scanner s = new Scanner(System.in);
		System.out.println("��!!! ���Ͱ� ��Ÿ����");
		while (true) {
			System.out.println("����������������������������������������������������");
			System.out.println("  1.�����ϱ�          2.��������        ");
			System.out.println("����������������������������������������������������");
			inputNumber = s.nextInt();
			if (inputNumber != 1 && inputNumber != 2) {
				System.out.println("�ٽ� �Է����ּ���.");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				continue;
			}
			if (inputNumber == 2) {
				break;
			}
			if (inputNumber == 1) {
				System.out.println("\n���ϸ��� �����ϼ���.");
				MyPoketmon.myPoketmonlist();
				poketmonselect = s.nextInt();
				mypoketmonnumber = poketmonselect - 1;
				Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
				if (mypoketmon.getpHP2() <= 0) {
					System.out.println("ü���� �����մϴ�. �ٸ� ���ϸ��� �����ϼ���.");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				} else {
					System.out.println("\n��ų�� �����ϼ���.");
					mypoketmon.skillMenu();
					skillnumber = s.nextInt();
					if (skillnumber != 1 && skillnumber != 2 && skillnumber != 3) {
						System.out.println("�ٽ� �Է����ּ���.");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
						continue;
					}
					if (skillnumber == 1) {
						if (mypoketmon.getpMP2() < mypoketmon.getSkillMp1()) {
							System.out.println("�����������մϴ�.");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
							}
						} else {
							Attackready.myskillAttack1(youpoketmonnumber, mypoketmonnumber);
							int randomskill = (int) (Math.random() * 3 + 1);
							if (randomskill == 1) {
								Attackready.youskillAttack1(youpoketmonnumber, mypoketmonnumber);
							}
							if (randomskill == 2) {
								Attackready.youskillAttack2(youpoketmonnumber, mypoketmonnumber);
							}
							if (randomskill == 3) {
								Attackready.youskillAttack3(youpoketmonnumber, mypoketmonnumber);
							}
						}
					}
					if (skillnumber == 2) {
						if (mypoketmon.getpMP2() < mypoketmon.getSkillMp2()) {
							System.out.println("�����������մϴ�.");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
							}
						} else {
							Attackready.myskillAttack2(youpoketmonnumber, mypoketmonnumber);

							int randomskill = (int) (Math.random() * 3 + 1);
							if (randomskill == 1) {
								Attackready.youskillAttack1(youpoketmonnumber, mypoketmonnumber);
							}
							if (randomskill == 2) {
								Attackready.youskillAttack2(youpoketmonnumber, mypoketmonnumber);
							}
							if (randomskill == 3) {
								Attackready.youskillAttack3(youpoketmonnumber, mypoketmonnumber);
							}
						}
					}
					if (skillnumber == 3) {
						if (mypoketmon.getpMP2() < mypoketmon.getSkillMp3()) {
							System.out.println("�����������մϴ�.");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
							}
						} else {
							Attackready.myskillAttack3(youpoketmonnumber, mypoketmonnumber);

							int randomskill3 = (int) (Math.random() * 3 + 1);
							if (randomskill3 == 1) {
								Attackready.youskillAttack1(youpoketmonnumber, mypoketmonnumber);

							}
							if (randomskill3 == 2) {
								Attackready.youskillAttack2(youpoketmonnumber, mypoketmonnumber);

							}
							if (randomskill3 == 3) {
								Attackready.youskillAttack3(youpoketmonnumber, mypoketmonnumber);
							}
						}
					}
					if (mypoketmon.getpHP2() <= 0 || youpoketmon.getpHP2() <= 0) {
						if (mypoketmon.getpHP2() <= 0) {
							Attackready.youAttackready(youpoketmonnumber);
							System.out.println("�� ���ϸ��� �׾����ϴ�. �ٸ� ���ϸ��� �����ϼ���.");
							mypoketmon.setpHP2(0);
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
							}
							continue;
						} else if (youpoketmon.getpHP2() <= 0) {
							System.out.println();
							Attackready.myAttackready(mypoketmonnumber);
							int money = (int) (Math.random() * 100) + 1;
							myif.setMoney(myif.getMoney() + money);
							MyPoketmon.setMyPoketmon(youpoketmonnumber);
							System.out.println("        ��������������        ");
							System.out.println("    ����������������������    ");
							System.out.println("   ������������������������   ");
							System.out.println("  ��������������������������  ");
							System.out.println(" ���������������������������� ");
							System.out.println(" �����������       ����������� ");
							System.out.println(" ������������� �� ������������� ");
							System.out.println(" ��        ��       ��        �� ");
							System.out.println(" ��         ��������         �� ");
							System.out.println("  ��                       ��  ");
							System.out.println("   ��                     ��   ");
							System.out.println("    ��                  ��     ");
							System.out.println("       ����������������       ");
							System.out.println("���ϸ��� ��ҽ��ϴ�.");
							System.out.println(money + " ��� ȹ��!!!");
							youpoketmon.setpHP2(youpoketmon.getpHP1());
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
							}
							break;
						}
					}
					Main.blank();
					Attackready.youAttackready(youpoketmonnumber);
					Attackready.myAttackready(mypoketmonnumber);
					continue;
				}
			}
		}
	}
}