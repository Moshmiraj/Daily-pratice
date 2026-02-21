
    import java.util.*;

public class DuplicateCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter how many numbers you want to input: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Display the array
        System.out.print("The content of the array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Count frequency using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Count total duplicate elements and find most repeated
        int duplicateCount = 0;
        int mostRepeating = -1, maxFreq = 0;
            
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateCount++;
            }
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostRepeating = entry.getKey();
            }
        }

        System.out.println("Total number of duplicate values = " + duplicateCount);
        System.out.println("The most repeating element in the array = " + mostRepeating);
    }
}

    
