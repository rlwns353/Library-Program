package 장준희_30122;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class start {
	Scanner scan = new Scanner(System.in);
	sub su = new sub();
	String path = "C:\\test\\30122_장준희.txt";

	public void Menu() {
		System.out.println("(0)종료");
		System.out.println("(1)도서 추가");
		System.out.println("(2)도서 폐기");
		System.out.println("(3)전체 출력");
		System.out.println("(4)도서 부분 검색");
		System.out.println("입력 : ");
	}

	public void insert() throws IOException {
		sub su = new sub();
		scan.nextLine();
		BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
		System.out.println("제목 :");
		su.setName(scan.nextLine());
		System.out.println("출판사 :");
		su.setCompany(scan.nextLine());
		System.out.println("저자 : ");
		su.setHuman(scan.nextLine());
		System.out.println("가격 : ");
		su.setCost(scan.nextLine());
		System.out.println("제목 : " + su.getName());
		System.out.println("저자 : " + su.getHuman());
		System.out.println("출판사 : " + su.getCompany());
		System.out.println("가격 : " + su.getCost());
		System.out.println("추가 하시겠습니까? \t (1)예  (2)아니오");
		int a = scan.nextInt();
		switch (a) {
		case 1:
			bw.write(su.getName() + "\t" + su.getCompany() + "\t" + su.getHuman() + "\t" + su.getCost());
			bw.newLine();
			System.out.println("추가 되었습니다.");
			break;
		case 2:
			System.out.println("추가 되지 않았습니다.");
			break;
		}

		bw.close();

	}

	public void search() throws FileNotFoundException {
		System.out.println("도서 목록  :");
		int count = 0;
		String str = "";

		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				count++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(count + "권 입니다.");
	}

	public void delete() throws IOException {
		System.out.println("도서 삭제");
		String tmpfilePath = path + ".tmp";
		int count = 1;
		System.out.print("삭제할 책 번호 입력 ");
		int deleteLineNumber = scan.nextInt();
		System.out.println("책 번호 : " + deleteLineNumber);

		BufferedReader br = new BufferedReader(new FileReader(path));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmpfilePath));
		String str = "";
		while ((str = br.readLine()) != null) {
			if (count != deleteLineNumber) {
				bw.write(str);
				bw.write("\r\n");
			}
			count++;
		}
		bw.close();
		bw.close();

		FileInputStream fis = new FileInputStream(tmpfilePath);
		FileOutputStream fos = new FileOutputStream(path);
		int data = 0;
		while ((data = fis.read()) != -1) {
			fos.write(data);
		}
		fis.close();
		fos.close();

		File f = new File(tmpfilePath);
		f.deleteOnExit();
	}

	public void search2() throws IOException {
		System.out.println("검색할 부분");
		System.out.println("(1)제목");
		System.out.println("(2)저자");
		System.out.println("(3)검색어");
		int choice = scan.nextInt();
		scan.nextLine();
		int count = 0;
		String[] a = new String[4];
		String[] b = new String[4];
		String word, str = "";

		BufferedReader br = new BufferedReader(new FileReader(path));

		switch (choice) {
		case 1: {
			System.out.println("제목 입력");
			word = scan.nextLine();
			while ((str = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(str, "\t");
				int i = 0;

				b[i] = token.nextToken();

				if (b[0].contains(word)) {
					System.out.println(str);
					count++;
				}
			}
			System.out.println(count + "권 입니다.");

			break;
		}
		case 2: {
			System.out.println("저자 입력");
			word = scan.nextLine();
			while ((str = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(str, "\t");
				for (int i = 0; i < 4; i++) {
					a[i] = token.nextToken();
				}
				if (a[2].contains(word)) {
					System.out.println(str);
					count++;
				}
			}

			System.out.println(count + "권 입니다.");

			break;
		}
		case 3:
			System.out.println("검색어 입력");
			word = scan.nextLine();
			while ((str = br.readLine()) != null) {
				if (str.contains(word)) {
					System.out.println(str);
					count++;
				}

			}
			System.out.println(count + "권 입니다.");
			break;
		}

	}
}