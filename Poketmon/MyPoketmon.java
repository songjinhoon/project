package Project01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyPoketmon {
	private static List<Poketmon> poketmon = new ArrayList<>();
	private Scanner s = new Scanner(System.in);
	
	public MyPoketmon(String string){
		for(int i=0; i<PoketmonList.poketmonListCount(); i++){
			Poketmon poketmon = PoketmonList.getPoketmon(i);
			if(poketmon.getpName().equals(string)){
				this.poketmon.add(poketmon);
				break;
			}
		}
	}
	
	public static Poketmon getMyPoketmon(int number){
		Poketmon returnPoketmon = poketmon.get(number);
		return returnPoketmon;
	}
	
	public static void setMyPoketmon(int poketmonnumber){
		poketmon.add(PoketmonList.getPoketmon(poketmonnumber));
	}
	
	public void myPoketmonPrint(){
		Main.blank();
		System.out.println("▶▶MyPoketmon\n");
		for(int i=0; i<poketmon.size(); i++){
			System.out.printf("[%2d] %5s\tHP:%d/%d\tMP:%d/%d\n",i+1 ,poketmon.get(i).getpName(), poketmon.get(i).getpHP1(), poketmon.get(i).getpHP2(), poketmon.get(i).getpMP1(), poketmon.get(i).getpMP2());
		}
		System.out.print("\n1. 돌아가기: ");
		int input = s.nextInt();
	}

	public static void myPoketmonlist(){
		System.out.println("-------------------내 포켓몬-------------------");
		for(int i=0; i<poketmon.size(); i++){
			System.out.printf("[%2d] %5s\tHP:%d/%d\tMP:%d/%d\n",i+1 ,poketmon.get(i).getpName(), poketmon.get(i).getpHP1(), poketmon.get(i).getpHP2(), poketmon.get(i).getpMP1(), poketmon.get(i).getpMP2());
		}
	}
	
	public static int getMyPoketmonCount(){
		return poketmon.size();
	}
	
	public static String tostring() {
	      String msg = "";
	      for (int i = 0; i < poketmon.size(); i++) {
	         msg += poketmon.get(i).getpName() + " ";
	      }
	      return msg;
   }
}
