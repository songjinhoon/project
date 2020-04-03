package Project01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PoketmonList  {
	private static List<Poketmon> poketmon = new ArrayList<>();
	
	public static void setPoketmonList(){
		poketmon.add(new Poketmon(1, "파이리", 4000, 4000,2000,2000, new PoketmonSkill("할퀴기", 400,100), new PoketmonSkill("불꽃세례", 800,400), new PoketmonSkill("베어가르기", 400,100), "F"));
	    poketmon.add(new Poketmon(2, "꼬북이", 4000, 4000,2000,2000, new PoketmonSkill("몸통박치기", 400,100), new PoketmonSkill("물대포", 400,100), new PoketmonSkill("하디드로펌프", 800,400), "K"));
	    poketmon.add(new Poketmon(3, "이상해씨", 4000, 4000,2000,2000, new PoketmonSkill("덩굴채찍", 800,400), new PoketmonSkill("잎날가르기", 400,100), new PoketmonSkill("몸통박치기", 400,100), "I"));
	    poketmon.add(new Poketmon(4, "피카츄", 6000,6000,3000,3000, new PoketmonSkill("전기쇼크", 800,400), new PoketmonSkill("전광석화", 400,100), new PoketmonSkill("아이언테일", 400,100), "P"));
	    poketmon.add(new Poketmon(5, "뮤", 10000,10000,8000,8000, new PoketmonSkill("드래곤크루", 1000,700), new PoketmonSkill("얼음숨결", 500,100), new PoketmonSkill("파괴광선", 800,300), "M"));
	    poketmon.add(new Poketmon(6, "망나뇽", 8000,8000,5000,5000, new PoketmonSkill("용의파동", 800,500), new PoketmonSkill("날개치기", 300,100), new PoketmonSkill("폭풍", 500,300), "D"));
	    poketmon.add(new Poketmon(7, "샤미드", 7000,7000,4000,4000, new PoketmonSkill("물의파동", 700,400), new PoketmonSkill("하이드로펌프", 500,300), new PoketmonSkill("아쿠아테일", 300,100), "S"));
	    poketmon.add(new Poketmon(8, "쥬피선더", 7000,7000,4000,4000, new PoketmonSkill("방전", 700,400), new PoketmonSkill("10만볼트", 500,300), new PoketmonSkill("번개", 300,100), "J"));
	    poketmon.add(new Poketmon(9, "에브이", 7000,7000,4000,4000, new PoketmonSkill("환상빔", 700,400), new PoketmonSkill("사이코키네시스", 500,300), new PoketmonSkill("미래예지", 300,100), "E"));
	    poketmon.add(new Poketmon(10, "부스터", 7000,7000,4000,4000, new PoketmonSkill("화염방사", 700,400), new PoketmonSkill("오버히트", 500,300), new PoketmonSkill("열풍", 300,100), "B"));  
	    poketmon.add(new Poketmon(11, "나옹", 3000,3000,1000,1000, new PoketmonSkill("마구할퀴기", 300,100), new PoketmonSkill("울음소리", 200,100), new PoketmonSkill("도발", 100,50), "N"));
	    poketmon.add(new Poketmon(12, "별가사리", 3000,3000,1000,1000, new PoketmonSkill("몸통박치기", 300,100), new PoketmonSkill("물대포", 200,100), new PoketmonSkill("스피드스타", 100,50), "G"));
	    poketmon.add(new Poketmon(13, "꼬렛", 2000,2000,1000,1000, new PoketmonSkill("꼬리흔들기", 300,100), new PoketmonSkill("필살앞니", 200,100), new PoketmonSkill("몸통박치기", 100,50), "H"));
	    poketmon.add(new Poketmon(14, "푸린", 4000,4000,3000,3000, new PoketmonSkill("노래하기", 300,200), new PoketmonSkill("연속뺨치기", 500,300), new PoketmonSkill("이판사판태클", 300,100), "L"));
	    poketmon.add(new Poketmon(15, "메타몽", 3000,3000,1000,1000, new PoketmonSkill("변신", 100,100), new PoketmonSkill("변신", 100,100), new PoketmonSkill("변신", 100,100), "A"));
	    poketmon.add(new Poketmon(16, "야도란", 5000,5000,3000,3000, new PoketmonSkill("물대포", 300,200), new PoketmonSkill("몸통박치기", 200,100), new PoketmonSkill("염동력", 500,400), "Y"));
	    poketmon.add(new Poketmon(17, "치코리타", 10000,10000,3000,3000, new PoketmonSkill("잎날가르기", 700,500), new PoketmonSkill("메지컬리프", 500,400), new PoketmonSkill("솔라빔", 300,100), "C"));
	    poketmon.add(new Poketmon(18, "잠만보", 15000,15000,3000,3000, new PoketmonSkill("몸통박치기", 200,400), new PoketmonSkill("하품", 200,400), new PoketmonSkill("잠자기", 100,500), "N"));
        poketmon.add(new Poketmon(19, "홍수몬", 3000,3000,1000,1000, new PoketmonSkill("연속펀치", 300,100), new PoketmonSkill("고속이동", 300,100), new PoketmonSkill("메가톤펀치", 500,500), "O"));
	    poketmon.add(new Poketmon(20, "고라파덕", 20000,20000,10000,10000, new PoketmonSkill("염동력", 1000,500), new PoketmonSkill("하이드로펌프", 1000,500), new PoketmonSkill("마구할퀴기", 1000,500), "Z"));
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
