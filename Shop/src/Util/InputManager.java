package Util;

import java.util.Scanner;

public class InputManager {
	private static Scanner sc;
	private static InputManager instance = new InputManager();
	
	private InputManager(){
		sc = new Scanner(System.in);
	}
	
	public static int getValue(String msg, int start, int end, int exception) {
		while(true) {
			try {
				System.out.print(msg+"["+start+"~"+end);
				System.out.print(exception!=start ? ", "+exception : "");
				System.out.print("] : ");
				int sel = sc.nextInt();
				if((sel<start || sel>end) && sel!=exception) {
					System.out.println("범위 오류");
					continue;
				}
				return sel;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수로 입력해주세요");
			}
		}
	}
	
	public static String getValue(String msg) {
		System.out.print(msg+" : ");
		String input = sc.next();
		return input;
	}
}
