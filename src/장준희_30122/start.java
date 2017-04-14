package ������_30122;

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
	String path = "C:\\test\\30122_������.txt";

	public void Menu() {
		System.out.println("(0)����");
		System.out.println("(1)���� �߰�");
		System.out.println("(2)���� ���");
		System.out.println("(3)��ü ���");
		System.out.println("(4)���� �κ� �˻�");
		System.out.println("�Է� : ");
	}

	public void insert() throws IOException {
		sub su = new sub();
		scan.nextLine();
		BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
		System.out.println("���� :");
		su.setName(scan.nextLine());
		System.out.println("���ǻ� :");
		su.setCompany(scan.nextLine());
		System.out.println("���� : ");
		su.setHuman(scan.nextLine());
		System.out.println("���� : ");
		su.setCost(scan.nextLine());
		System.out.println("���� : " + su.getName());
		System.out.println("���� : " + su.getHuman());
		System.out.println("���ǻ� : " + su.getCompany());
		System.out.println("���� : " + su.getCost());
		System.out.println("�߰� �Ͻðڽ��ϱ�? \t (1)��  (2)�ƴϿ�");
		int a = scan.nextInt();
		switch (a) {
		case 1:
			bw.write(su.getName() + "\t" + su.getCompany() + "\t" + su.getHuman() + "\t" + su.getCost());
			bw.newLine();
			System.out.println("�߰� �Ǿ����ϴ�.");
			break;
		case 2:
			System.out.println("�߰� ���� �ʾҽ��ϴ�.");
			break;
		}

		bw.close();

	}

	public void search() throws FileNotFoundException {
		System.out.println("���� ���  :");
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
		System.out.println(count + "�� �Դϴ�.");
	}

	public void delete() throws IOException {
		System.out.println("���� ����");
		String tmpfilePath = path + ".tmp";
		int count = 1;
		System.out.print("������ å ��ȣ �Է� ");
		int deleteLineNumber = scan.nextInt();
		System.out.println("å ��ȣ : " + deleteLineNumber);

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
		System.out.println("�˻��� �κ�");
		System.out.println("(1)����");
		System.out.println("(2)����");
		System.out.println("(3)�˻���");
		int choice = scan.nextInt();
		scan.nextLine();
		int count = 0;
		String[] a = new String[4];
		String[] b = new String[4];
		String word, str = "";

		BufferedReader br = new BufferedReader(new FileReader(path));

		switch (choice) {
		case 1: {
			System.out.println("���� �Է�");
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
			System.out.println(count + "�� �Դϴ�.");

			break;
		}
		case 2: {
			System.out.println("���� �Է�");
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

			System.out.println(count + "�� �Դϴ�.");

			break;
		}
		case 3:
			System.out.println("�˻��� �Է�");
			word = scan.nextLine();
			while ((str = br.readLine()) != null) {
				if (str.contains(word)) {
					System.out.println(str);
					count++;
				}

			}
			System.out.println(count + "�� �Դϴ�.");
			break;
		}

	}
}