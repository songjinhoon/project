package Project01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PoketmonList  {
	private static List<Poketmon> poketmon = new ArrayList<>();
	
	public static void setPoketmonList(){
		poketmon.add(new Poketmon(1, "���̸�", 4000, 4000,2000,2000, new PoketmonSkill("������", 400,100), new PoketmonSkill("�Ҳɼ���", 800,400), new PoketmonSkill("�������", 400,100), "F"));
	    poketmon.add(new Poketmon(2, "������", 4000, 4000,2000,2000, new PoketmonSkill("�����ġ��", 400,100), new PoketmonSkill("������", 400,100), new PoketmonSkill("�ϵ�������", 800,400), "K"));
	    poketmon.add(new Poketmon(3, "�̻��ؾ�", 4000, 4000,2000,2000, new PoketmonSkill("����ä��", 800,400), new PoketmonSkill("�ٳ�������", 400,100), new PoketmonSkill("�����ġ��", 400,100), "I"));
	    poketmon.add(new Poketmon(4, "��ī��", 6000,6000,3000,3000, new PoketmonSkill("�����ũ", 800,400), new PoketmonSkill("������ȭ", 400,100), new PoketmonSkill("���̾�����", 400,100), "P"));
	    poketmon.add(new Poketmon(5, "��", 10000,10000,8000,8000, new PoketmonSkill("�巡��ũ��", 1000,700), new PoketmonSkill("��������", 500,100), new PoketmonSkill("�ı�����", 800,300), "M"));
	    poketmon.add(new Poketmon(6, "������", 8000,8000,5000,5000, new PoketmonSkill("�����ĵ�", 800,500), new PoketmonSkill("����ġ��", 300,100), new PoketmonSkill("��ǳ", 500,300), "D"));
	    poketmon.add(new Poketmon(7, "���̵�", 7000,7000,4000,4000, new PoketmonSkill("�����ĵ�", 700,400), new PoketmonSkill("���̵������", 500,300), new PoketmonSkill("���������", 300,100), "S"));
	    poketmon.add(new Poketmon(8, "���Ǽ���", 7000,7000,4000,4000, new PoketmonSkill("����", 700,400), new PoketmonSkill("10����Ʈ", 500,300), new PoketmonSkill("����", 300,100), "J"));
	    poketmon.add(new Poketmon(9, "������", 7000,7000,4000,4000, new PoketmonSkill("ȯ���", 700,400), new PoketmonSkill("������Ű�׽ý�", 500,300), new PoketmonSkill("�̷�����", 300,100), "E"));
	    poketmon.add(new Poketmon(10, "�ν���", 7000,7000,4000,4000, new PoketmonSkill("ȭ�����", 700,400), new PoketmonSkill("������Ʈ", 500,300), new PoketmonSkill("��ǳ", 300,100), "B"));  
	    poketmon.add(new Poketmon(11, "����", 3000,3000,1000,1000, new PoketmonSkill("����������", 300,100), new PoketmonSkill("�����Ҹ�", 200,100), new PoketmonSkill("����", 100,50), "N"));
	    poketmon.add(new Poketmon(12, "�����縮", 3000,3000,1000,1000, new PoketmonSkill("�����ġ��", 300,100), new PoketmonSkill("������", 200,100), new PoketmonSkill("���ǵ彺Ÿ", 100,50), "G"));
	    poketmon.add(new Poketmon(13, "����", 2000,2000,1000,1000, new PoketmonSkill("��������", 300,100), new PoketmonSkill("�ʻ�մ�", 200,100), new PoketmonSkill("�����ġ��", 100,50), "H"));
	    poketmon.add(new Poketmon(14, "Ǫ��", 4000,4000,3000,3000, new PoketmonSkill("�뷡�ϱ�", 300,200), new PoketmonSkill("���ӻ�ġ��", 500,300), new PoketmonSkill("���ǻ�����Ŭ", 300,100), "L"));
	    poketmon.add(new Poketmon(15, "��Ÿ��", 3000,3000,1000,1000, new PoketmonSkill("����", 100,100), new PoketmonSkill("����", 100,100), new PoketmonSkill("����", 100,100), "A"));
	    poketmon.add(new Poketmon(16, "�ߵ���", 5000,5000,3000,3000, new PoketmonSkill("������", 300,200), new PoketmonSkill("�����ġ��", 200,100), new PoketmonSkill("������", 500,400), "Y"));
	    poketmon.add(new Poketmon(17, "ġ�ڸ�Ÿ", 10000,10000,3000,3000, new PoketmonSkill("�ٳ�������", 700,500), new PoketmonSkill("�����ø���", 500,400), new PoketmonSkill("�ֶ��", 300,100), "C"));
	    poketmon.add(new Poketmon(18, "�Ḹ��", 15000,15000,3000,3000, new PoketmonSkill("�����ġ��", 200,400), new PoketmonSkill("��ǰ", 200,400), new PoketmonSkill("���ڱ�", 100,500), "N"));
        poketmon.add(new Poketmon(19, "ȫ����", 3000,3000,1000,1000, new PoketmonSkill("������ġ", 300,100), new PoketmonSkill("����̵�", 300,100), new PoketmonSkill("�ް�����ġ", 500,500), "O"));
	    poketmon.add(new Poketmon(20, "����Ĵ�", 20000,20000,10000,10000, new PoketmonSkill("������", 1000,500), new PoketmonSkill("���̵������", 1000,500), new PoketmonSkill("����������", 1000,500), "Z"));
	}
	public static Poketmon getPoketmon(int number){
		Poketmon returnPoketmon = poketmon.get(number);
		return returnPoketmon;
	}
	
	public static int poketmonListCount(){
		int returnCount = poketmon.size();
		return returnCount;
	}
	
	public static void poketmonListPrint(){
		for(int i=0; i<20; i++){
			Poketmon printPoketmon = poketmon.get(i);
			printPoketmon.thinInformation();
		}
	}
	
	public static void poektmonInfoListPrint(Poketmon poketmon){
		Main.blank();
		poketmon.deepInformation();
	}
}
