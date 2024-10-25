package stjean;


public class OperationMathematique {

    public static boolean  estPositif(int number) {
        if(number >= 0){
            return true;
        }
        else{
            return false;
        }

    }
    public static int factorial (int number){

        if (number ==  0|| number ==  1){
            return 1;
        }
        else {
            return number * (factorial(number-1));
        }
    }

    public static int[] sort(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] < list[j + 1]) {

                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }
}
