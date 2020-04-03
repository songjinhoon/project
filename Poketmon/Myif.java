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
      System.out.println("▶▶MyIf\n");
      System.out.println("캐릭터 이름 : " + this.str + "      포켓몬 갯수: " + count);
      System.out.println("보유하고 있는 돈 : " + this.money);
      System.out.print("\n1. 돌아가기: ");
      int input = s.nextInt();
   }
   
}