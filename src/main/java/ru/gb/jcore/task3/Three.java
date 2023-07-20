package ru.gb.jcore.task3;

/*
 * 3) Написать метод, принимающий на вход массив чисел
 * и параметр n. Метод должен осуществить циклический
 * (последний элемент при сдвиге становится первым)
 * сдвиг всех элементов массива на n позиций
 */

import ru.gb.jcore.Application;
import ru.gb.jcore.task2.Two;

import java.lang.reflect.Array;
import java.util.*;

public class Three {

	public static void three() {
		System.out.print("\nВведите размер массива от 2 до 100: ");
		int n = new Scanner(System.in).nextInt(); //Размер создаваемого массива
		if (n < 2 || n > 100) {
			Two.errorInputUser();
			three();
		}
		int[] arrayInt = new Random().ints(n, -9, 10).toArray();
		System.out.printf("Введите смещение от 1 до %d: ", n - 1);
		int shift = new Scanner(System.in).nextInt();
		if (shift < 1 || shift > n - 1) {
			Two.errorInputUser();
			three();
		}
		System.out.printf("Cдвиг: %d %n", shift);
		System.out.println("Массив до смещения:");
		System.out.println(Arrays.toString(arrayInt));
		arrayInt = shiftArray(arrayInt, shift);
		System.out.println("Массив после смещения:");
		System.out.println(Arrays.toString(arrayInt));
		Application.run();
	}

	public static int[] shiftArray(int[] arr, int ofset) {
		int[] array1 = Arrays.copyOfRange(arr, ofset, arr.length);
		int[] array2 = Arrays.copyOfRange(arr, 0, ofset);
		int[] resultAray = new int[arr.length];
		for (int i = 0; i < array1.length; ++i) {
			resultAray[i] = array1[i];
		}
		for (int i = 0; i < array2.length; ++i) {
			resultAray[array1.length + i] = array2[i];
		}
		return resultAray;
	}
}

