import java.util.ArrayList;
import java.util.Scanner;

class Stack {
    private ArrayList<String> stack = new ArrayList<>();

    public void push(String item) {
        stack.add(item);
    }

    public String pop() {
        if (isEmpty()) {
            return null; 
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    public String peek() {
        if (isEmpty()) {
            return null; 
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    public ArrayList<String> display() {
        return stack;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class Stack_Implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0; // Input validation for 'n'
        while (n <= 0) {
            try {
                System.out.print("Enter the maximum number of inputs (positive integer): ");
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        Stack stack = new Stack();

        while (true) {
            System.out.println("Stack Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                if (stack.display().size() < n) {
                    System.out.print("Enter item to push: ");
                    String item = sc.nextLine();
                    stack.push(item);
                    System.out.println(item + " pushed onto the stack.");
                } else {
                    System.out.println("Cannot push item. Stack is full.");
                }

            } else if (choice.equals("2")) {
                String poppedItem = stack.pop();
                if (poppedItem != null) {
                    System.out.println("Popped item: " + poppedItem);
                } else {
                    System.out.println("Stack is empty.");
                }

            } else if (choice.equals("3")) {
                String topItem = stack.peek();
                if (topItem != null) {
                    System.out.println("Top item: " + topItem);
                } else {
                    System.out.println("Stack is empty.");
                }

            } else if (choice.equals("4")) {
                if (!stack.isEmpty()) {
                    System.out.println("Stack: " + stack.display());
                } else {
                    System.out.println("Stack is empty.");
                }

            } else if (choice.equals("0")) {
                System.out.println("Exiting...");
                break;
                
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
