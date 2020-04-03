package Project01;

import java.util.Scanner;

public class Hospital {
    int Money ;
       int m1 = 100, m2 = 75, m3 = 50, m4 = 25; // HP구매가격 임의설정
       int mp1 = 100, mp2 = 75, mp3 = 50, mp4 = 25; // MP구매가격 임의설정
       int ppoketmon;
       Scanner ss = new Scanner(System.in);
       MyPoketmon myPoketmon;
       Myif myif;
     
     Hospital(MyPoketmon myPoketmon, Myif myif) {
        this.myPoketmon = myPoketmon;
        this.myif = myif;
     }
     
     public int print(){
        System.out.println("▶▶Hospital\n");
        System.out.println("＞＞보유하고 있는 돈: "+ myif.getMoney());
        System.out.println("＞＞ 보유하고 있는 포켓몬");
        for(int i=0; i<MyPoketmon.getMyPoketmonCount(); i++){
            System.out.printf("[%d] %5s\tHP:%d/%d\tMP:%d/%d\n",i+1,MyPoketmon.getMyPoketmon(i).getpName(),MyPoketmon.getMyPoketmon(i).getpHP1(),MyPoketmon.getMyPoketmon(i).getpHP2(),MyPoketmon.getMyPoketmon(i).getpMP1(),MyPoketmon.getMyPoketmon(i).getpMP2());
         }
        System.out.print("\n\n1. 포켓몬 회복\t2. 돌아가기: ");
        int input = ss.nextInt();
        return input;
      
        
     }
     
     public void method(){
       System.out.print("\n\n＞＞ 회복할 포켓몬을 선택해주세요: ");
       int ppoketmon = ss.nextInt()-1;
       int HP1= MyPoketmon.getMyPoketmon(ppoketmon).getpHP1();//고정
        int HP2= MyPoketmon.getMyPoketmon(ppoketmon).getpHP2();//변동
        int MP1 = MyPoketmon.getMyPoketmon(ppoketmon).getpMP1();//고정
        int MP2 = MyPoketmon.getMyPoketmon(ppoketmon).getpMP2();//변동
        System.out.print("1. HP회복 \t 2. MP회복: ");
        int hpmpoutput = ss.nextInt();
        int MyMoney = myif.getMoney(); 
        int hphp1 = (int)(HP1*1);
        int hphp2 = (int)(HP1*0.75);
        int hphp3 = (int)(HP1*0.5);
        int hphp4 = (int)(HP1*0.25);
        int mpmp1 = (int)(MP1*1);
        int mpmp2 = (int)(MP1*0.75);
        int mpmp3 = (int)(MP1*0.5);
        int mpmp4 = (int)(MP1*0.25);
        while(true){
           if(hpmpoutput==1) {
              System.out.println("\n\n＞＞ 회복할 HP를 선택하세요.");
               System.out.println("1:" + m1 + "원(" + hphp1 + "HP회복) \n2:" + m2 + "원(" + hphp2 + "HP회복) \n3:" + m3 + "원(" + hphp3  + "HP회복) \n4:" + m4  + "원(" + hphp4 +"HP회복 )");
                int hpoutput = ss.nextInt();  
                if((hpoutput==1 && (HP1==HP2))|| (hpoutput==2 && (HP1==HP2))|| (hpoutput==3 && (HP1==HP2))|| (hpoutput==4 && (HP1==HP2))){
                         { System.out.println("더이상 회복할 HP가 없습니다.");}
                         System.out.print("\n1. 돌아가기: ");
                           int input = ss.nextInt();
                           break;
                }
                if((hpoutput==1 && MyMoney<m1) || (hpoutput==2 && MyMoney<m2) || (hpoutput==3 &&  MyMoney<m3) || (hpoutput==4 && MyMoney<m4 )){
                   System.out.println("돈이 부족합니다.");
                   System.out.print("\n1. 돌아가기: ");
                   int input = ss.nextInt();
                   break;
                }else if(hpoutput==1){
                   System.out.println("HP: 완전(" + HP1 +")회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                   myif.setMoney(MyMoney - m1);
                   System.out.print("\n1. 돌아가기: ");
                   int input = ss.nextInt();
                   break; 
                }else if(hpoutput==2){
                  if(HP2+hphp2>=HP1){
                   System.out.println("HP: 완전(" + HP1 +")회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                  myif.setMoney(MyMoney - m2);
                  }else{
                  int hptotal = HP2 + hphp2;
                   System.out.println("HP: " + hptotal +"회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP2+hphp2);}
                  myif.setMoney(MyMoney - m2);
                   System.out.print("\n1. 돌아가기: ");
                   int input = ss.nextInt();
                   break;
                }else if(hpoutput==3){
                  if(HP2+hphp3>=HP1){
                   System.out.println("HP: 완전(" + HP1 +")회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                   myif.setMoney(MyMoney - m3);
                   }else{
                   int hptotal = HP2 + hphp3;
                   System.out.println("HP: " + hptotal +"회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP2+hphp3);}
                  myif.setMoney(MyMoney - m3);
                   System.out.print("\n1. 돌아가기: ");
                   int input = ss.nextInt();
                   break;
                }else if(hpoutput==4){
                     if(HP2+hphp4>=HP1){
                   System.out.println("HP: 완전(" + HP1 +")회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                   myif.setMoney(MyMoney - m4);
                   }else{
                   int hptotal = HP2 + hphp4;
                   System.out.println("HP: " + hptotal +"회복 되었습니다.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP2+hphp4);}
                  myif.setMoney(MyMoney - m4);
                   System.out.print("\n1. 돌아가기: ");
                   int input = ss.nextInt();
                   break;
               }
         
          }
           if(hpmpoutput==2){
              System.out.println("\n\n＞＞회복할 MP를 선택하세요.");
               System.out.println("1:" + m1 + "원(" + mpmp1 + "MP회복) \n2:" + m2 + "원(" + mpmp2 + "MP회복) \n3:" + m3 + "원(" + mpmp3  + "MP회복) \n4:" + m4  + "원(" + mpmp4 +"MP회복 )");
                int mpoutput = ss.nextInt();  
                if((mpoutput==1 && (MP1==MP2))|| (mpoutput==2 && (MP1==MP2))|| (mpoutput==3 && (MP1==MP2))|| (mpoutput==4 && (MP1==MP2))){
                         { System.out.println("더이상 회복할 MP가 없습니다.");}
                         System.out.print("\n1. 돌아가기: ");
                           int input = ss.nextInt();
                           break;
                }
                if((mpoutput==1 && MyMoney<mp1) || (mpoutput==2 && MyMoney<mp2) || (mpoutput==3 &&  MyMoney<mp3) || (mpoutput==4 && MyMoney<mp4 )){
                    System.out.println("돈이 부족합니다.");
                    System.out.print("\n1. 돌아가기: ");
                    int input = ss.nextInt();
                    break;
                 }else if(mpoutput==1){
                    System.out.println("MP: 완전("+ MP1 +")회복 되었습니다.");
                    MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                    myif.setMoney(MyMoney - mp1);
                    System.out.print("\n1. 돌아가기: ");
                    int input = ss.nextInt();
                    break; 
                 }else if(mpoutput==2){
                     if(MP2+mpmp2>=MP1){
                      System.out.println("MP: 완전(" + MP1 +")회복 되었습니다.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                     myif.setMoney(MyMoney - mp2);
                     }else{
                     int hptotal = MP2 + mpmp2;
                      System.out.println("MP: " + hptotal +"회복 되었습니다.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP2+mpmp2);}
                     myif.setMoney(MyMoney - mp2);
                      System.out.print("\n1. 돌아가기: ");
                      int input = ss.nextInt();
                      break;
                   }else if(mpoutput==3){
                     if(MP2+mpmp3>=MP1){
                      System.out.println("MP: 완전(" + MP1 +")회복 되었습니다.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                      myif.setMoney(MyMoney - mp3);
                      }else{
                      int hptotal = MP2 + mpmp3;
                      System.out.println("MP: " + hptotal +"회복 되었습니다.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP2+mpmp3);}
                      myif.setMoney(MyMoney - mp3);
                      System.out.print("\n1. 돌아가기: ");
                      int input = ss.nextInt();
                      break;
                   }else if(mpoutput==4){
                      if(MP2+mpmp4>=MP1){
                      System.out.println("MP: 완전(" + MP1 +")회복 되었습니다.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                      myif.setMoney(MyMoney - mp4);
                      }else{
                      int hptotal = MP2 + mpmp4;
                      System.out.println("MP: " + hptotal +"회복 되었습니다.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP2+mpmp4);}
                     myif.setMoney(MyMoney - mp4);
                      System.out.print("\n1. 돌아가기: ");
                      int input = ss.nextInt();
                      break;
              }
        
         }
              
           }
     }}
