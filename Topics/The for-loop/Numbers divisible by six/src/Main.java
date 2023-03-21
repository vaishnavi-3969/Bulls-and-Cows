import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int sum = 0;
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i = 0; i<length; i++){
            arr[i] = scanner.nextInt();
            if(arr[i]%6==0){
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }
}