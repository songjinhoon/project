package Project01;

import java.util.Scanner;

public class Hospital {
    int Money ;
       int m1 = 100, m2 = 75, m3 = 50, m4 = 25; // HP���Ű��� ���Ǽ���
       int mp1 = 100, mp2 = 75, mp3 = 50, mp4 = 25; // MP���Ű��� ���Ǽ���
       int ppoketmon;
       Scanner ss = new Scanner(System.in);
       MyPoketmon myPoketmon;
       Myif myif;
     
     Hospital(MyPoketmon myPoketmon, Myif myif) {
        this.myPoketmon = myPoketmon;
        this.myif = myif;
     }
     
     public int print(){
        System.out.println("����Hospital\n");
        System.out.println("���������ϰ� �ִ� ��: "+ myif.getMoney());
        System.out.println("���� �����ϰ� �ִ� ���ϸ�");
        for(int i=0; i<MyPoketmon.getMyPoketmonCount(); i++){
            System.out.printf("[%d] %5s\tHP:%d/%d\tMP:%d/%d\n",i+1,MyPoketmon.getMyPoketmon(i).getpName(),MyPoketmon.getMyPoketmon(i).getpHP1(),MyPoketmon.getMyPoketmon(i).getpHP2(),MyPoketmon.getMyPoketmon(i).getpMP1(),MyPoketmon.getMyPoketmon(i).getpMP2());
         }
        System.out.print("\n\n1. ���ϸ� ȸ��\t2. ���ư���: ");
        int input = ss.nextInt();
        return input;
      
        
     }
     
     public void method(){
       System.out.print("\n\n���� ȸ���� ���ϸ��� �������ּ���: ");
       int ppoketmon = ss.nextInt()-1;
       int HP1= MyPoketmon.getMyPoketmon(ppoketmon).getpHP1();//����
        int HP2= MyPoketmon.getMyPoketmon(ppoketmon).getpHP2();//����
        int MP1 = MyPoketmon.getMyPoketmon(ppoketmon).getpMP1();//����
        int MP2 = MyPoketmon.getMyPoketmon(ppoketmon).getpMP2();//����
        System.out.print("1. HPȸ�� \t 2. MPȸ��: ");
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
              System.out.println("\n\n���� ȸ���� HP�� �����ϼ���.");
               System.out.println("1:" + m1 + "��(" + hphp1 + "HPȸ��) \n2:" + m2 + "��(" + hphp2 + "HPȸ��) \n3:" + m3 + "��(" + hphp3  + "HPȸ��) \n4:" + m4  + "��(" + hphp4 +"HPȸ�� )");
                int hpoutput = ss.nextInt();  
                if((hpoutput==1 && (HP1==HP2))|| (hpoutput==2 && (HP1==HP2))|| (hpoutput==3 && (HP1==HP2))|| (hpoutput==4 && (HP1==HP2))){
                         { System.out.println("���̻� ȸ���� HP�� �����ϴ�.");}
                         System.out.print("\n1. ���ư���: ");
                           int input = ss.nextInt();
                           break;
                }
                if((hpoutput==1 && MyMoney<m1) || (hpoutput==2 && MyMoney<m2) || (hpoutput==3 &&  MyMoney<m3) || (hpoutput==4 && MyMoney<m4 )){
                   System.out.println("���� �����մϴ�.");
                   System.out.print("\n1. ���ư���: ");
                   int input = ss.nextInt();
                   break;
                }else if(hpoutput==1){
                   System.out.println("HP: ����(" + HP1 +")ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                   myif.setMoney(MyMoney - m1);
                   System.out.print("\n1. ���ư���: ");
                   int input = ss.nextInt();
                   break; 
                }else if(hpoutput==2){
                  if(HP2+hphp2>=HP1){
                   System.out.println("HP: ����(" + HP1 +")ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                  myif.setMoney(MyMoney - m2);
                  }else{
                  int hptotal = HP2 + hphp2;
                   System.out.println("HP: " + hptotal +"ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP2+hphp2);}
                  myif.setMoney(MyMoney - m2);
                   System.out.print("\n1. ���ư���: ");
                   int input = ss.nextInt();
                   break;
                }else if(hpoutput==3){
                  if(HP2+hphp3>=HP1){
                   System.out.println("HP: ����(" + HP1 +")ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                   myif.setMoney(MyMoney - m3);
                   }else{
                   int hptotal = HP2 + hphp3;
                   System.out.println("HP: " + hptotal +"ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP2+hphp3);}
                  myif.setMoney(MyMoney - m3);
                   System.out.print("\n1. ���ư���: ");
                   int input = ss.nextInt();
                   break;
                }else if(hpoutput==4){
                     if(HP2+hphp4>=HP1){
                   System.out.println("HP: ����(" + HP1 +")ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP1);
                   myif.setMoney(MyMoney - m4);
                   }else{
                   int hptotal = HP2 + hphp4;
                   System.out.println("HP: " + hptotal +"ȸ�� �Ǿ����ϴ�.");
                   MyPoketmon.getMyPoketmon(ppoketmon).setpHP2(HP2+hphp4);}
                  myif.setMoney(MyMoney - m4);
                   System.out.print("\n1. ���ư���: ");
                   int input = ss.nextInt();
                   break;
               }
         
          }
           if(hpmpoutput==2){
              System.out.println("\n\n����ȸ���� MP�� �����ϼ���.");
               System.out.println("1:" + m1 + "��(" + mpmp1 + "MPȸ��) \n2:" + m2 + "��(" + mpmp2 + "MPȸ��) \n3:" + m3 + "��(" + mpmp3  + "MPȸ��) \n4:" + m4  + "��(" + mpmp4 +"MPȸ�� )");
                int mpoutput = ss.nextInt();  
                if((mpoutput==1 && (MP1==MP2))|| (mpoutput==2 && (MP1==MP2))|| (mpoutput==3 && (MP1==MP2))|| (mpoutput==4 && (MP1==MP2))){
                         { System.out.println("���̻� ȸ���� MP�� �����ϴ�.");}
                         System.out.print("\n1. ���ư���: ");
                           int input = ss.nextInt();
                           break;
                }
                if((mpoutput==1 && MyMoney<mp1) || (mpoutput==2 && MyMoney<mp2) || (mpoutput==3 &&  MyMoney<mp3) || (mpoutput==4 && MyMoney<mp4 )){
                    System.out.println("���� �����մϴ�.");
                    System.out.print("\n1. ���ư���: ");
                    int input = ss.nextInt();
                    break;
                 }else if(mpoutput==1){
                    System.out.println("MP: ����("+ MP1 +")ȸ�� �Ǿ����ϴ�.");
                    MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                    myif.setMoney(MyMoney - mp1);
                    System.out.print("\n1. ���ư���: ");
                    int input = ss.nextInt();
                    break; 
                 }else if(mpoutput==2){
                     if(MP2+mpmp2>=MP1){
                      System.out.println("MP: ����(" + MP1 +")ȸ�� �Ǿ����ϴ�.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                     myif.setMoney(MyMoney - mp2);
                     }else{
                     int hptotal = MP2 + mpmp2;
                      System.out.println("MP: " + hptotal +"ȸ�� �Ǿ����ϴ�.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP2+mpmp2);}
                     myif.setMoney(MyMoney - mp2);
                      System.out.print("\n1. ���ư���: ");
                      int input = ss.nextInt();
                      break;
                   }else if(mpoutput==3){
                     if(MP2+mpmp3>=MP1){
                      System.out.println("MP: ����(" + MP1 +")ȸ�� �Ǿ����ϴ�.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                      myif.setMoney(MyMoney - mp3);
                      }else{
                      int hptotal = MP2 + mpmp3;
                      System.out.println("MP: " + hptotal +"ȸ�� �Ǿ����ϴ�.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP2+mpmp3);}
                      myif.setMoney(MyMoney - mp3);
                      System.out.print("\n1. ���ư���: ");
                      int input = ss.nextInt();
                      break;
                   }else if(mpoutput==4){
                      if(MP2+mpmp4>=MP1){
                      System.out.println("MP: ����(" + MP1 +")ȸ�� �Ǿ����ϴ�.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP1);
                      myif.setMoney(MyMoney - mp4);
                      }else{
                      int hptotal = MP2 + mpmp4;
                      System.out.println("MP: " + hptotal +"ȸ�� �Ǿ����ϴ�.");
                      MyPoketmon.getMyPoketmon(ppoketmon).setpMP2(MP2+mpmp4);}
                     myif.setMoney(MyMoney - mp4);
                      System.out.print("\n1. ���ư���: ");
                      int input = ss.nextInt();
                      break;
              }
        
         }
              
           }
     }}
