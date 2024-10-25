package stjean;



public class OperationMathematique {

    public boolean  estPositif(int number) {
        if(number >= 0){
            return true;
        }
        else{
            return false;
        }

    }
    public int factorial  (int number) throws IllegalParamISIException{
        if (number < 0) {
            throw new IllegalParamISIException("The factorial of a negative number does not exit");
        }
        if (number ==  0|| number ==  1){
            return 1;
        }
        else {
            return number * (factorial(number-1));
        }
    }

    public static int[] sort(int[] list) {
        // Implementing bubble sort in descending order
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] < list[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }
}
