package ru.gb.jcore.task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2) Написать метод «Шифр Цезаря»,
 * с булевым параметром зашифровывания и расшифровывания
 * и числовым ключом
 */
public class Two {

	public static void two() {
		System.out.println("\"Шифр Цезаря\"");
		Scanner scn = new Scanner(System.in);
		boolean encode = true;

		System.out.print("\nВведите смещение (от 1 до 15)");
		int shift = scn.nextInt();
		if (shift > 15 || shift < 1) {
			errorInputUser();
			two();
		}

		System.out.print("\nВы хотите закодировать(1) или раскодировать(2) текст? : ");
		int encDec = scn.nextInt();
		if (encDec == 2 || encDec == 1) {
			encode = encDec == 1;
		} else {
			errorInputUser();
			two();
		}
		System.out.println("\nВведите строку на русском языке:");
		String str = new Scanner(System.in).nextLine();

		String resultString;
		if (encode) {
			resultString = caesarCipher(str, shift, 'А', 'Я');
		} else {
			resultString = caesarCipher(str, -shift, 'А', 'Я');
		}
		System.out.println(resultString);

	}

	public static void errorInputUser() {
		System.out.println("Вы ошиблись при вводе!");
	}

	public static String caesarCipher(String str, int shift, char firstCharacter, char lastCharacter) {
		StringBuilder strBox = new StringBuilder(str.length());
		char tmp;
		int countCharsAlfabet = (lastCharacter - firstCharacter) + 1;
		for (int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i);
			if (Character.isLetter(str.charAt(i))) {
				tmp += shift % countCharsAlfabet;
				if (tmp > lastCharacter)
					tmp = (char) (tmp % lastCharacter + firstCharacter - 1);
				else if (tmp < firstCharacter)
					tmp = (char) (tmp + countCharsAlfabet);
			}
			strBox.append(tmp);
		}
		return strBox.toString();
	}
}
