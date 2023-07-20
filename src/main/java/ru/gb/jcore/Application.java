package ru.gb.jcore;

import ru.gb.jcore.task1.One;
import ru.gb.jcore.task2.Two;
import ru.gb.jcore.task3.Three;

import java.util.Scanner;

public class Application {
	public static void run() {
		System.out.printf("%n%n%n");
		System.out.println("1) Задание №1");
		System.out.println("2) Задание №2");
		System.out.println("3) Задание №3");
		System.out.println("0) Выход");
		System.out.print("Введите пункт меню: ");
		int m = new Scanner(System.in).nextInt();
		try {

			switch (m) {
				case 1: {
					One.one();
					run();
				}

				case 2: {
					Two.two();
					run();
				}

				case 3: {
					Three.three();
					run();
				}

				case 0: {
					System.exit(0);
				}
				default: {
					System.out.println("Вы ошиблись при вводе!");
					run();
				}
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			run();
		}
	}
}
