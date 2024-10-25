package stjean;

import
public class OperationMathematique {

    public boolean  estPositif(int number) {
        if(number >= 0){
            return true;
        }
        else{
            return false;
        }

    }
    public int factorial (int number){

        if (number ==  0|| number ==  1){
            return 1;
        }
        else {
            return number * (factorial(number-1));
        }
    }
}
