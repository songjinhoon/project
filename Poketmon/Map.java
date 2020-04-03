package Project01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map {
	public int size = 15; // 높이 y축 -> 행
	public int wid = size * 2; // 넓이 x축 -> 열
	public int x = 0;
	public int y = 0;
	public String[][] rect = new String[size][wid];
	public String[] me = { "■" };
	List<PoketmonAddress> list = new ArrayList<>();
	public boolean setPck = true;
	public int cnt = 0;
	public int[] now_add = new int[2];
	static int num = 0, num2 = 0;
	static int[][] allP_add = new int[4][2];
	// MyPoketmon mypoketmon;

	public void getMyPoketmon(MyPoketmon mypoketmon) {
		// this.mypoketmon = mypoketmon;
	}

	public void defaultMap() {
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < wid; k++) {
				rect[i][k] = " ";
			}
		}

		for (int i = 0; i < size; i++) {
			for (int k = 0; k < wid; k++) {
				if (i == size / 2 && k == wid / 2) {
					rect[i][k] = me[0];
					now_add[0] = i;
					now_add[1] = k;
					continue;
				}
				if (i == 0) {
					rect[i][k] = "─";
					if (k == 0) {
						rect[i][k] = "┌";
					} else if (k == wid - 1) {
						rect[i][k] = "┐";
					}
				} else if (i == size - 1) {
					rect[i][k] = "─";
					if (k == 0) {
						rect[i][k] = "└";
					} else if (k == wid - 1) {
						rect[i][k] = "┘";
					}
				} else {
					if (i > 0 || i < size - 1) {
						if (k == 0) {
							rect[i][k] = "│";
						} else if (k == wid - 1) {
							rect[i][k] = "│";
						}
					}
				}
			}
		}
	}

	public void newMapPrint() {
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < wid; k++) {
				System.out.print(rect[i][k]);
			}
			System.out.println();
		}
	}

	public void changePosition(char input) {
		// String reply = scan.nextLine(); // 콘솔에 입력받은 값 저장

		// 방향키 조작
		switch (input) {
		case 'a': // 왼쪽
			rect[now_add[0]][now_add[1]] = " ";
			now_add[1] -= 1; // 왼쪽 이동이기 때문에 x값 -1;
			rect[now_add[0]][now_add[1]] = me[0];
			break;

		case 'w': // 위쪽
			rect[now_add[0]][now_add[1]] = " ";
			now_add[0] -= 1; // 위쪽 이동이기 때문에 y값 -1;
			rect[now_add[0]][now_add[1]] = me[0];
			break;

		case 's': // 아래쪽
			rect[now_add[0]][now_add[1]] = " ";

			now_add[0] += 1; // 아래쪽 이동이기 때문에 y값 +1;
			rect[now_add[0]][now_add[1]] = me[0];
			break;

		case 'd': // 오른쪽
			rect[now_add[0]][now_add[1]] = " ";

			now_add[1] += 1; // 오른쪽 이동이기 때문에 x값 +1;
			rect[now_add[0]][now_add[1]] = me[0];
			break;
		}
	}

	public void setPokemon() {
		String check;
		for (int j = 0; j < 4; j++) {
			boolean overlapck = false;
			x = (int) (Math.random() * (wid - 2) + 1);
			y = (int) (Math.random() * (size - 2) + 1);
			if (rect[y][x] != " ") {
				j--;
				continue;
			}
			int poketmonRandomSelect = (int) (Math.random() * 20);
			check = PoketmonList.getPoketmon(poketmonRandomSelect).getPInitial();
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < wid; k++) {
					if (rect[i][k] == check) {
						overlapck = true;
					}
				}
			}
			if (overlapck == true) {
				j--;
				continue;
			}

			boolean overlapck2 = false;

			for (int i = 0; i < MyPoketmon.getMyPoketmonCount(); i++) {
				if (check == MyPoketmon.getMyPoketmon(i).getPInitial()) {
					overlapck2 = true;
				}
			}

			if (overlapck2 == true) {
				j--;
				continue;
			}

			list.add(new PoketmonAddress(x, y, check));
			rect[y][x] = check;
			cnt++;// 뺴지마셈 무조건
		}
	}

	public boolean WallCrashP() {
		boolean wallCrashCheck = false;
		for (int i = 0; i < 4; i++) {
			int px = list.get(i).getX();
			int py = list.get(i).getY();
			if (py == 0 || px == 0 || py == size - 1 || px == wid - 1) {
				wallCrashCheck = true;
				return wallCrashCheck;
			}
		}
		return wallCrashCheck;
	}

	public boolean wallCrash() {
		// 벽을 만나면 다시 가운데로 돌아가도록
		boolean wallCrashCheck = false;
		if (now_add[0] == 0 || now_add[1] == 0 || now_add[0] == size - 1 || now_add[1] == wid - 1) {
			wallCrashCheck = true;
			return wallCrashCheck;
		} else {
			return wallCrashCheck;
		}
	}

	public int getCnt() {
		return cnt;
	}

	public int returnPokemonNum() {
		int number = 0;
		for (int k = 0; k < 4; k++) {
			int px = list.get(k).getX();
			int py = list.get(k).getY();
			if (now_add[0] == py && now_add[1] == px) {
				String poketmonInitial1 = list.get(k).getInitial();
				for (int i = 0; i < 20; i++) {
					String poketmonInitial2 = PoketmonList.getPoketmon(i).getPInitial();
					if (poketmonInitial1 == poketmonInitial2) {
						return i;
					}
				}
			}
		}
		return 50;
	}

	public void fullSet() {
		list.clear();
	}

	public void randomSwitchP() {
		num = (int) (Math.random() * 4);	// 맵에 뿌려진 포켓몬 한마리랜덤으로 가져오기
		num2 = (int) (Math.random() * 4);   // 상하좌우 뽑기

		int px = list.get(num).getX();	// 가져온 포켓몬의 x좌표와 y좌표 얻기 이친구가 이동될거같음
		int py = list.get(num).getY();
		
		switch (num2) {
//		좌
		case 0:
			if(px == 1) break;
			for(int i=0; i<list.size(); i++){
				if(i == num) continue;
				int checkX = list.get(i).getX();
				int checkY = list.get(i).getY();
				if(px-1 == checkX && py == checkY){
					continue;
				}
				
				rect[py][px] = " ";
				px -= 1;
				rect[py][px] = list.get(num).getInitial();
				list.get(num).setX(list.get(num).getX() - 1);
				break;
			}
			break;
//			우
		case 1:
			if(px == 28) break;
			for(int i=0; i<list.size(); i++){
				if(i == num) continue;
				int checkX = list.get(i).getX();
				int checkY = list.get(i).getY();
				if(px-1 == checkX && py == checkY){
					continue;
				}
				rect[py][px] = " ";
				px += 1;
				rect[py][px] = list.get(num).getInitial();
				list.get(num).setX(list.get(num).getX() + 1);
				break;
			}
			break;
//			상
		case 2:
			if(py == 1) break;
			for (int i = 0; i < list.size(); i++) {
				if(i == num) continue;
				int checkX = list.get(i).getX();
				int checkY = list.get(i).getY();
				if (py-1 == checkY && px == checkX){
					continue;
				}
				
				rect[py][px] = " ";
				py -= 1;
				rect[py][px] = list.get(num).getInitial();
				list.get(num).setY(list.get(num).getY() - 1);
				break;
			}
			break;
//			하
		case 3:
			if(py == 13) break;
			for (int i = 0; i < list.size(); i++) {
				if(i == num) continue;
				int checkX = list.get(i).getX();
				int checkY = list.get(i).getY();
				if (py+1 == checkY && px == checkX){
					continue;
				}
				
				rect[py][px] = " ";
				py += 1;
				rect[py][px] = list.get(num).getInitial();
				list.get(num).setY(list.get(num).getY() + 1);
				break;
			}
			break;
		}
	}

}
