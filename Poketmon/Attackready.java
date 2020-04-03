package Project01;

import java.util.Scanner;

public class Attackready {

   public static void youAttackready(int youpoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      String name1 = youpoketmon.getpName();
      int hp1 = youpoketmon.getpHP1();
      int hp2 = youpoketmon.getpHP2();
      System.out.println("■■■■■■■■■■■■상대 포켓몬■■■■■■■■■■■");
      System.out.println();
      System.out.println("     ##              #");
      System.out.println("    #  ############## #");
      System.out.println("   # ,,,          ,,   #");
      System.out.println("  # ,   ,        ,   ,  #");
      System.out.println("  # ,,,,,        ,,,,,   #");
      System.out.println("   #                     #");
      System.out.println("    #,,,,,,,,,,,,,,,,,,,#");
      System.out.println("     #,,,,,,,,,,,,,,,,#");
      System.out.println();
      System.out.println("┌                    ┐");
      System.out.println("   "+name1 + " HP: " + hp1 + "/" + hp2);
      System.out.println("└                    ┘");
      System.out.println("------------------------------------------------");
      System.out.println();
      System.out.println();
   }

   public static void myAttackready(int mypoketmonnumber) {
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      String name2 = mypoketmon.getpName();
      int hp3 = mypoketmon.getpHP1();
      int hp4 = mypoketmon.getpHP2();
      int mp1 = mypoketmon.getpMP1();
      int mp2 = mypoketmon.getpMP2();
      System.out.println("■■■■■■■■■■■■내 포켓몬■■■■■■■■■■■■");
      System.out.println();
      System.out.println("     ##              #");
      System.out.println("    #  ############## #");
      System.out.println("   # ,,,          ,,   #");
      System.out.println("  # ,   ,        ,   ,  #");
      System.out.println("  # ,,,,,        ,,,,,   #");
      System.out.println("   #                     #");
      System.out.println("    #,,,,,,,,,,,,,,,,,,,#");
      System.out.println("     #,,,,,,,,,,,,,,,,#");
      System.out.println();
      System.out.println("┌                                  ┐");
      System.out.println("  "+name2 + " HP: " + hp3 + "/" + hp4 + "," + " MP: " + mp1 + "/" + mp2);
      System.out.println("└                                  ┘");
      System.out.println("------------------------------------------------");
      System.out.println();
      System.out.println();
   }

   public static void myskillAttack1(int youpoketmonnumber, int mypoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      int mp2 = mypoketmon.getpMP2();
      int hp2 = youpoketmon.getpHP2();
      hp2 = hp2 - mypoketmon.getSkillPower1();
      mp2 = mp2 - mypoketmon.getSkillMp1();
      youpoketmon.setpHP2(hp2);
      mypoketmon.setpMP2(mp2);
   }

   public static void myskillAttack2(int youpoketmonnumber, int mypoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      int mp2 = mypoketmon.getpMP2();
      int hp2 = youpoketmon.getpHP2();
      hp2 = hp2 - mypoketmon.getSkillPower2();
      mp2 = mp2 - mypoketmon.getSkillMp2();
      youpoketmon.setpHP2(hp2);
      mypoketmon.setpMP2(mp2);
   }

   public static void myskillAttack3(int youpoketmonnumber, int mypoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      int mp2 = mypoketmon.getpMP2();
      int hp2 = youpoketmon.getpHP2();
      hp2 = hp2 - mypoketmon.getSkillPower3();
      mp2 = mp2 - mypoketmon.getSkillMp3();
      youpoketmon.setpHP2(hp2);
      mypoketmon.setpMP2(mp2);
   }

   public static void youskillAttack1(int youpoketmonnumber, int mypoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      int hp4 = mypoketmon.getpHP2();
      hp4 = hp4 - youpoketmon.getSkillPower1();
      mypoketmon.setpHP2(hp4);

   }

   public static void youskillAttack2(int youpoketmonnumber, int mypoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      int hp4 = mypoketmon.getpHP2();
      hp4 = hp4 - youpoketmon.getSkillPower2();
      mypoketmon.setpHP2(hp4);

   }

   public static void youskillAttack3(int youpoketmonnumber, int mypoketmonnumber) {
      Poketmon youpoketmon = PoketmonList.getPoketmon(youpoketmonnumber);
      Poketmon mypoketmon = MyPoketmon.getMyPoketmon(mypoketmonnumber);
      int hp4 = mypoketmon.getpHP2();
      hp4 = hp4 - youpoketmon.getSkillPower3();
      mypoketmon.setpHP2(hp4);

   }

}