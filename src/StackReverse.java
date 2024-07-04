import java.util.Stack;

class StackReverse {
    
    public static void main(String[] args){

        reverse("Hallo");

    }

    public static Stack reverse(String word){

        int laenge = word.length();
        
        Stack<E> stack = new Stack<>();

        for (int i = 0; i < laenge; i++){

            char stackSave = word.StringValueOf(i+1);
            stack.push(stackSave);

        }

        System.out.println(stack);

    }
}
