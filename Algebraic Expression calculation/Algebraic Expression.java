import java.util.Scanner;
import java.util.Stack;

public class Main{
    static Long t = (long) ((1000 * 1000 * 1000) + 7);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        Stack<Character> operator = new Stack<>();
        Stack<Long> numbers = new Stack<>();



        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

                StringBuilder temp = new StringBuilder();
                temp.append(str.charAt(i));
                i++;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    temp.append(str.charAt(i));
                    i++;
                }
                long l = Long.parseLong(temp.toString());
                numbers.add(l);
                i--;
            } else {
                if (str.charAt(i) == '(') {
                    operator.push(str.charAt(i));
                }
                else if (str.charAt(i) == ')') {
                    while (operator.peek() != '(') {
                        Long b = numbers.pop();
                        Long a = numbers.pop();

                        numbers.push(operation(a, b, operator.pop()));
                    }
                    if(!operator.isEmpty())
                        operator.pop();
                } else {
                    while (!operator.isEmpty() && priority(operator.peek()) >= priority(str.charAt(i))) {
                        Long b = numbers.pop();
                        Long a = numbers.pop();

                        numbers.push(operation(a, b, operator.pop()));
                    }
                    operator.push(str.charAt(i));
                }
            }
        }

        while (!operator.isEmpty()){

            Long b = numbers.pop();
            Long a = numbers.pop();

            numbers.push(operation(a, b, operator.pop()));
        }

        System.out.println(numbers.peek());

    }

    public static long operation(long x, long y, char c){

        if(c == '+'){
            return (x%t + y%t)%t;
        }
        else if(c == '-'){
            return ((x%t - y%t)+t)%t;
        }
        else{
            return (x%t * y%t)%t;
        }
    }

    public static int priority(char c){

        if(c == '+' || c == '-'){
           return 1;
        }
        else if(c == '*'){
            return 2;
        }
        else
            return 0;

    }

}