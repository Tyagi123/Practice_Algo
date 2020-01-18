import java.util.Stack;

public class MinElementFromStack {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.getMinValue();
        s.push(18);
        s.push(19);
        s.getMinValue();
        s.push(29);
        s.push(15);
        s.push(16);
        s.push(26);

        s.getMinValue();
        s.pop();
        s.getMinValue();
        s.pop();
        s.getMinValue();
        s.pop();
        s.getMinValue();
        s.pop();
        s.getMinValue();
        s.pop();
        s.getMinValue();
    }
}

class MyStack {
    Stack<Integer> myStack = null;
    Integer minValue = null;

    public Integer getMinValue() {
        System.out.println(minValue);
        return minValue;
    }

    public void push(Integer newVal) {
        if (myStack == null || myStack.isEmpty()) {
            myStack = new Stack<>();
            minValue = newVal;
            myStack.push(newVal);
            // System.out.println("Number Inserted: " + newVal);
            return;
        }

        if (newVal < minValue) {
            myStack.push(2 * minValue - newVal);
            newVal = minValue;
        } else
            myStack.push(newVal);

        // System.out.println("Number Inserted: " + newVal);
    }


    public void pop() {
        if (myStack == null || myStack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Integer topElement = myStack.pop();

        if (topElement < minValue) {
            System.out.println(topElement);
            minValue = 2 * minValue - topElement;
        } else
            System.out.println(topElement);
    }

    public void peek() {
        if (myStack.isEmpty()) {
            System.out.println("Stack is empty ");
            return;
        }

        Integer topValue = myStack.peek();
        System.out.print("Top Most Element is: ");


        if (topValue < minValue)
            System.out.println(minValue);
        else
            System.out.println(topValue);
    }
}