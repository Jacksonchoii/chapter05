package com.javaex.ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader fr = new FileReader("C:\\javaStudy\\workspace\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		Writer fw = new FileWriter("C:\\javaStudy\\workspace\\PhoneDB(copy).txt");
		BufferedWriter bw = new BufferedWriter(fw);

		ArrayList<Person> data = new ArrayList<Person>();

		while (true) {
			String str = br.readLine();

			if (str == null) {
				break;
			}
			// ","를 기준으로 데이터 입력 data01(name) "," data02(hp) "," data03(company)
			String person[] = str.split(",");
			data.add(new Person(person[0], person[1], person[2]));
		}

		data.add(new Person("조경환", "010-6267-5935", "02-2665-4439"));// ("String name", "String hp", "String company")
		data.add(new Person("홍길동", "010-1234-5678", "02-1234-5678"));// ("String name", "String hp", "String company")

		for (int i = 0; i < data.size(); i++) {
			bw.write(data.get(i).getName() + ", " + data.get(i).getHp() + ", " + data.get(i).getCompany());
			bw.newLine();
		}

		bw.close();
		br.close();
		
	}

}
