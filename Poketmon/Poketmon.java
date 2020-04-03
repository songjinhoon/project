package Project01;

import java.util.ArrayList;
import java.util.List;

public class Poketmon  {
	private int pNumber;
	private String pName;
	private int pHP1; // 고정체력(기본값)
	private int pHP2; // 변동체력(현재)
	private int pMP1;
	private int pMP2;
	private PoketmonSkill poketmonSkill1;
	private PoketmonSkill poketmonSkill2;
	private PoketmonSkill poketmonSkill3;
	private String pInitial;

	public Poketmon(int pNumber, String pName, int pHP1, int pHP2, int pMP1, int pMP2, PoketmonSkill poketmonSkill1,
			PoketmonSkill poketmonSkill2, PoketmonSkill poketmonSkill3, String pInitial) {
		this.pNumber = pNumber;
		this.pName = pName;
		this.pHP1 = pHP1; // 고정체력(기본값)
		this.pHP2 = pHP2; // 변동체력(현재)
		this.pMP1 = pMP1;
		this.pMP2 = pMP2;
		this.poketmonSkill1 = poketmonSkill1;
		this.poketmonSkill2 = poketmonSkill2;
		this.poketmonSkill3 = poketmonSkill3;
		this.pInitial = pInitial;
	}

	public void thinInformation() {
		System.out.printf("No.%2d\t%s\n", pNumber, pName);
	}

	/*
	 * public void deepInformation(Poketmon poketmon){
	 * System.out.printf("%s\t%d\t\n", poketmon.pName, poketmon.pHP,
	 * poketmon.poketmonSkill1, poketmon.poketmonSkill2,
	 * poketmon.poketmonSkill3); }
	 */

	public void deepInformation() {
		System.out.println("---------------------상세 정보---------------------");
		System.out.println("[이름]: " + pName + "\t[체력]: " + pHP1 + "\t[마나]: " + pMP1 + "\n스킬1: " + poketmonSkill1 + "     스킬2: "
				+ poketmonSkill2 + "     스킬3:  " + poketmonSkill3);
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpHP1() {
		return pHP1;
	}

	public int getpHP2() {
		return pHP2;
	} // hp2추가

	public void setpHP2(int pHP2) {
		this.pHP2 = pHP2;
	} // hp2추가
	
	public int getpMP1() {
		return pMP1;
	}

	public int getpMP2() {
		return pMP2;
	}

	public void setpMP2(int pMP2) {
		this.pMP2 = pMP2;
	}

	public PoketmonSkill getPoketmonSkill1() {
		return poketmonSkill1;
	}

	public void setPoketmonSkill1(PoketmonSkill poketmonSkill1) {
		this.poketmonSkill1 = poketmonSkill1;
	}

	public PoketmonSkill getPoketmonSkill2() {
		return poketmonSkill2;
	}

	public void setPoketmonSkill2(PoketmonSkill poketmonSkill2) {
		this.poketmonSkill2 = poketmonSkill2;
	}

	public PoketmonSkill getPoketmonSkill3() {
		return poketmonSkill3;
	}

	public void setPoketmonSkill3(PoketmonSkill poketmonSkill3) {
		this.poketmonSkill3 = poketmonSkill3;
	}

	public void skillMenu() {
	    System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
	    System.out.println("    스킬1:"+ poketmonSkill1 +"  스킬2:" + poketmonSkill2 + "  스킬3:"+ poketmonSkill3);
	    System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
   }

	// 스킬메뉴추가
	public int getSkillPower1() {
		return poketmonSkill1.getSkillPower();
	}

	public int getSkillPower2() {
		return poketmonSkill2.getSkillPower();
	}

	public int getSkillPower3() {
		return poketmonSkill3.getSkillPower();
	}
	public int getSkillMp1() {
		return poketmonSkill1.getSkillMp();
	}

	public int getSkillMp2() {
		return poketmonSkill2.getSkillMp();
	}

	public int getSkillMp3() {
		return poketmonSkill3.getSkillMp();
	}
	
	public String getPInitial(){
		return pInitial;
	}
}
