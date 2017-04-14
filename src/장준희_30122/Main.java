package 장준희_30122;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		start st = new start();
		while (true) {
			st.Menu();
			int a = -1;
			a = scan.nextInt();
			switch (a) {
			case 0:
				System.out.println("종료 합니다.");
				System.exit(0);
				break;
			case 1:
				st.insert();
				break;

			case 2:
				st.delete();
				break;

			case 3:
				st.search();
				break;
			case 4:
				st.search2();
				break;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
		}
	}
}
