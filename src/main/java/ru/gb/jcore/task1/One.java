package ru.gb.jcore.task1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * 1) Доделать сортировку подсчетом с урока (если нет, реализовать)
 * классическим способом через промежуточный массив
 * (см. последние минут 10 семинара)
 */
public class One {
	/**
	 * Если брать массив чисел от -9 до 9,
	 * то размер временного массива будет 19
	 * -
	 * [-9 -8 -7 -6 -5 -4 -3 -2 -1  0  1  2  3  4  5  6  7  8  9 ]
	 * [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
	 */
	public static void one() {
		System.out.println("Будет создан начальный массив и автоматически\n" +
				"будет заполнен числами от -9 до 9\n");
		System.out.printf("%nВведите размер создаваемого массива: ");
		int n = new Scanner(System.in).nextInt();

		int[] arrayInt = new Random().ints(n, -9, 10).toArray();
		System.out.printf("%nОсновной массив до сортировки:%n");
		System.out.println(Arrays.toString(arrayInt));

		int[] tmpArray = sortingByCounting(arrayInt);
		System.out.printf("Основной массив после сортировки:%n");
		System.out.println(Arrays.toString(arrayInt));

		System.out.printf("Временный массив:%n");
		System.out.println(Arrays.toString(tmpArray));
	}

	public static int[] sortingByCounting(int[] input) {
		final int INDEX_0_NUMBER = 9; // индекс числа 0 во временном массиве
		int[] tempArray = new int[19];

		for (int n : input) {
			tempArray[INDEX_0_NUMBER + n]++;
		}

		int idx = 0; // Счетчик текущего индекса в массиве
		int number = -9; // число для заполнения итогового массива,
		// наначинаем c наименьшего возможного числа
		for (int m : tempArray) {
			if (m > 0) { // если счетчик текущего числа больше нуля, начинаем заполнение числом number
				for (int i = 0; i < m; i++) {
					input[idx + i] = number;
				}
				idx = idx + m;
				number++;
			} else { //если счетчик текущего числа равен нулю, то переходим к следующему
				number++;
			}
		}
		return tempArray;
	}
}

