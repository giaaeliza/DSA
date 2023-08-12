import java.util.Arrays;
import java.util.Scanner;
public class ArrayCRUD {
private static final int MAX_SIZE = 10;
private static int[] array = new int[MAX_SIZE];
private static int size = 0;
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int choice;
// Get the initial array from the user
System.out.print("Enter the number of elements in the array: ");
size = scanner.nextInt();
if (size > MAX_SIZE) {
System.out.println("Maximum array size exceeded. Taking first " +
MAX_SIZE + " elements only.");
size = MAX_SIZE;
}
System.out.print("Enter the elements of the array: ");
for (int i = 0; i < size; i++) {
array[i] = scanner.nextInt();
}
do {
System.out.println("\nArray CRUD Operations:");
System.out.println("1. Create");
System.out.println("2. Read");
System.out.println("3. Update");
System.out.println("4. Delete");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
choice = scanner.nextInt();
switch (choice) {
case 1:
create();
break;
case 2:
read();
break;
case 3:
update();
break;
case 4:
delete();
break;
case 5:
System.out.println("Exiting...");
break;
default:
System.out.println("Invalid choice! Please try again.");
}
} while (choice != 5);
scanner.close();
}
private static void create() {
if (size == MAX_SIZE) {
System.out.println("Array is full! Cannot add more elements.");
return;
}
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of elements to add: ");
int numElements = scanner.nextInt();
if (size + numElements > MAX_SIZE) {
System.out.println("Cannot add more elements. Maximum array size exceeded.");
return;
}
for (int i = 0; i < numElements; i++) {
System.out.print("Enter element #" + (i + 1) + ": ");
int element = scanner.nextInt();
System.out.print("Enter the index where to insert element #" + (i +
1) + ": ");
int index = scanner.nextInt();
if (index < 0 || index > size) {
System.out.println("Invalid index! Please try again.");
i--;
continue;
}for (int j = size; j > index; j--) {
array[j] = array[j - 1];
}
array[index] = element;
size++;
}
System.out.println("Elements added successfully!\n");
}
private static void read() {
if (size == 0) {
System.out.println("Array is empty! No elements to read.");
return;
}
System.out.println("Array elements: " +
Arrays.toString(Arrays.copyOf(array, size)));
}
private static void update() {
if (size == 0) {
System.out.println("Array is empty! No elements to update.");
return;
}
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the index of the element to update: ");
int index = scanner.nextInt();
if (index < 0 || index >= size) {
System.out.println("Invalid index! Please try again.");
return;
}
System.out.print("Enter the new element value: ");
int newElement = scanner.nextInt();
array[index] = newElement;
System.out.println("Element updated successfully!");
}
private static void delete() {
if (size == 0) {
System.out.println("Array is empty! No elements to delete.");
return;
}
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of elements to delete: ");
int numElements = scanner.nextInt();
if (numElements > size) {
System.out.println("Invalid number of elements! Please try again.");
return;
}
for (int i = 0; i < numElements; i++) {
System.out.print("Enter the index of element #" + (i + 1) + " to delete: ");
int index = scanner.nextInt();
if (index < 0 || index >= size) {
System.out.println("Invalid index! Please try again.");
i--;
continue;
}
for (int j = index; j < size - 1; j++) {
array[j] = array[j + 1];
}
size--;
}
System.out.println("Elements deleted successfully!");
}
}