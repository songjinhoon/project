package Project01;

import java.util.Scanner;

public class Main {
	static String user_id = "나야나";

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 30; i++) {
				System.out.println();
			}
			GameReady.gameLogo();
			Thread.sleep(3000);

			System.out.println("포켓몬 세계에 오신걸 환영합니다.");
			Thread.sleep(2000);
			GameReady.setStartCharacter();
			Thread.sleep(2000);
			GameReady.setStartPoketmon();
			Thread.sleep(2000);
			GameReady.gameReadyFinish();
			Thread.sleep(2000);

			GameReady.gameLoading();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		초기화작업 start
		PocketmonMusic pm = new PocketmonMusic();
		PocketmonAttackMusic pam = new PocketmonAttackMusic();
		Client client = new Client();
		int count = 0;
		Map map = new Map();
		map.defaultMap();
		boolean check = true;
		int cnt = 0;
		PoketmonList.setPoketmonList();
		MyPoketmon myPoketmon = new MyPoketmon(GameReady.getStartPoketmon());
		Myif myif = new Myif(GameReady.getStartCharacter());
		Hospital hospital = new Hospital(myPoketmon, myif);
		client.startClient(user_id);	
		pm.run();
		
		while (true) {
			client.send(MyPoketmon.tostring());
			blank();
			count = gmaeStartLogo(count);
			if (check) {
				map.setPokemon();
			}
			map.newMapPrint();
			char retrunSelectAction = Action.mainAction();
			if (retrunSelectAction == 'w' || retrunSelectAction == 'a' || retrunSelectAction == 's' || retrunSelectAction == 'd') {
				blank();
				map.changePosition(retrunSelectAction);
				int returnReturnPokemonNum = map.returnPokemonNum();
				if (returnReturnPokemonNum != 50) {
					pm.stopSound();
					pam.run();
					Attack.attack(returnReturnPokemonNum, myif);
					pam.stopSound();
					pm.run();
					client.send(MyPoketmon.tostring());
					map.fullSet();
					map.defaultMap();
					map.setPokemon();
				}
				map.randomSwitchP();
				boolean charWallCrash = map.wallCrash();
				if (charWallCrash) {
					map.fullSet();
					map.defaultMap();
					map.setPokemon();
				}
			}
			if (retrunSelectAction == 'q' ) {
				break;
			}
			if (retrunSelectAction == '0') {
				while (true) {
					blank();
					int retrunSelectSubAction = Action.subAction();
					if (retrunSelectSubAction == 1) {
						blank();
		                int returnPrint = hospital.print();
		                if(returnPrint == 1){ hospital.method(); }
		                else{ System.out.println("check: " + returnPrint); }
					} else if (retrunSelectSubAction == 2) {
						blank();
						myPoketmon.myPoketmonPrint();
					} else if (retrunSelectSubAction == 3) {
						blank();
						myif.MyifMethod(myPoketmon.getMyPoketmonCount());
					} else if (retrunSelectSubAction == 4) {
						while (true) {
							blank();
							int returnPoketmonListMainAction = Action.poketmonListMainAction();
							if (returnPoketmonListMainAction == 2) {
								break;
							} else {
								Action.poketmonListSubAction();
							}
						}
					} else if (retrunSelectSubAction == 5) {
						System.out.println(client.msg);
						Scanner s = new Scanner(System.in);
						System.out.print("\n\n1. 돌아가기: ");
						int input = s.nextInt();
						break;
					} else {
						break;
						
					}
				} 
			}
			if (map.getCnt() == 4) { check = false; }
			if (myPoketmon.getMyPoketmonCount() == 10){ break; }
		}
		gmaeEndLogo();
	}

	private static void gmaeEndLogo() {
		System.out.println("--------------Game End--------------");
	}

	private static int gmaeStartLogo(int count) {
		if (count == 0) {
			System.out.println("--------------Game Start--------------");
			count++;
			return count;
		} else {
			return count;
		}
	}

	public static void blank() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
}
