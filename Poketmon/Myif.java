package Project01;

import java.util.Scanner;

public class Myif {
   int money =500;
   String str;
   Scanner s = new Scanner(System.in);

   Myif(String str){
      this.str = str;
   }
   public int getMoney() {
      return money;
   }

   public void setMoney(int money) {
	   if(money<=0){
		   this.money = 0;
	   }else{
		   this.money = money;
	   }
   }
   public void MyifMethod(int count){
      System.out.println("����MyIf\n");
      System.out.println("ĳ���� �̸� : " + this.str + "      ���ϸ� ����: " + count);
      System.out.println("�����ϰ� �ִ� �� : " + this.money);
      System.out.print("\n1. ���ư���: ");
      int input = s.nextInt();
   }
   
}