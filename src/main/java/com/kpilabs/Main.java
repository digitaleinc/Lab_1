package com.kpilabs;

// variant 25
// C5 = 0 ; C7 = 4 ; C11 = 3

// 1. Дія з матрицею(ями)
// C = a*B ,
// a — const
// 2. Тип елементів матриці - long
// 3. Дія з матрицею С : Обчислити суму найбільших елементів кожного рядка матриці

// 4. Створити клас, який складається з виконавчого методу, що
// виконує дію з матрицею(ями) (п.2) із зазначеним типом елементів
// (п.3) та дію із результуючою матрицею С (п.4). Вивести на екран
// результати першої та другої дій. Необхідно обробити всі виключні
// ситуації, що можуть виникнути під час виконання програмного коду.
// Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
// Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
// та бути завантаженим на GitHub.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введіть кількість рядків матриці B: ");
            int rows = scanner.nextInt();
            System.out.print("Введіть кількість стовпців матриці B: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Кількість рядків та стовпців повинна бути додатною.");
            }

            long[][] B = new long[rows][cols];
            System.out.println("Введіть елементи матриці B:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.printf("B[%d][%d]: ", i, j);
                    B[i][j] = scanner.nextLong();
                }
            }

            System.out.print("Введіть константу a: ");
            long a = scanner.nextLong();

            long[][] C = multiplyMatrixByScalar(B, a);
            System.out.println("Матриця C = a * B:");
            printMatrix(C);
            long sumOfMaxElements = sumOfRowMaxElements(C);
            System.out.println("Сума найбільших елементів кожного рядка матриці C: " + sumOfMaxElements);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка введення: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Арифметична помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    private static long[][] multiplyMatrixByScalar(long[][] matrix, long scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        long[][] result = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (matrix[i].length != cols) {
                throw new IllegalArgumentException("Усі рядки матриці повинні мати однакову кількість стовпців.");
            }
            for (int j = 0; j < cols; j++) {
                result[i][j] = scalar * matrix[i][j];
            }
        }
        return result;
    }

    private static long sumOfRowMaxElements(long[][] matrix) {
        long sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                throw new IllegalArgumentException("Рядок " + i + " матриці порожній.");
            }
            long max = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            sum += max;
        }
        return sum;
    }

    private static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
