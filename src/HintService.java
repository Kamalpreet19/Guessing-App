public class HintService {
    public static String generateHint(int target, int hintCount){
        if(hintCount==1){
            return (target % 2 == 0)?"Hint: Number is Even":"Hint: Number is Odd";
        }else if(hintCount==2){
            return (target>50)?"Hint: Number is greater than 50":"Hint: Number is 50 or less";
        }else{
            return "No more hints available";
        }
    }
}
