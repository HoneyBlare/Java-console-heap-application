import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapPriorityQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // for user input
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(); //  store tasks; uses a min-heap by default

        int choice;
        do {
            // Display menu options to the user
            System.out.println("\nHeap-Based Priority Queue Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Highest Priority Task");
            System.out.println("3. Remove Highest Priority Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Add a new task to the priority queue
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (lower is higher): ");
                    int priority = scanner.nextInt();
                    if(priority < 0){
                        System.out.println("Priority must be a non-negative integer.");
                        break;
                    }
                    priorityQueue.offer(new Task(description, priority)); // Uses offer() to add to queue
                    System.out.println("Task added.");
                    break;
                case 2:
                    // View the highest priority task without removing it
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Priority queue is empty.");
                    } else {
                        System.out.println("Highest priority task: " + priorityQueue.peek()); // peek() returns highest priority element without removing
                    }
                    break;
                case 3:
                    // Remove and display the highest priority task
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Priority queue is empty.");
                    } else {
                        System.out.println("Removed task: " + priorityQueue.poll()); // poll() removes and returns highest priority element
                    }
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4); // Continue until the user chooses to exit

        scanner.close(); // Close the scanner to release resources
    }

    // Inner class to represent a task with a description and priority
    static class Task implements Comparable<Task> {
        String description;
        int priority;

        Task(String description, int priority) {
            this.description = description;
            this.priority = priority;
        }
        public int compareTo(Task other) {
            // Compares tasks based on their priority
            return Integer.compare(this.priority, other.priority);
        }
        public String toString() {
            return "Task{" +   "description='" + description + '\'' +    ", priority=" + priority +    '}';
        }
    }
}