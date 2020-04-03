package Project01;

public class PoketmonSkill {
	private String skillName;
	private int skillPower;
	private int skillMp;
	
	public PoketmonSkill(String skillName, int skillPower, int skillMp) {
		this.skillName = skillName;
		this.skillPower = skillPower;
		this.skillMp = skillMp;
	}
	public int getSkillPower() {
		return skillPower;
	}
	public int getSkillMp() {
		return skillMp;
	}

	@Override
    public String toString() {
      return skillName + "(" + "공격력:"+skillPower+" 소모마나:"+skillMp+")";
    }
	
}
