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
}
