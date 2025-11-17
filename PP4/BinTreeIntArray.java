import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {

        // Actualizar
        if (_tree[0] == null){
            _tree[0]= value;
        } else {
            
            int currentIndex = 0;
            while (currentIndex <_tree.length){
                if (value < _tree[currentIndex]){
                    // Para ir a la izquierda
                    int leftIndex = 2 * currentIndex +1;
                    if (leftIndex <_tree.length && _tree[leftIndex] == null){
                        _tree[leftIndex] = value;
                        break;
                    } else if (leftIndex <_tree.length){
                        currentIndex = leftIndex;
                    } else{
                        break;
                    }
                } else {
                    //Para ir a la Derecha
                    int rightIndex = 2 * currentIndex + 2;
                    if (rightIndex < _tree.length && _tree[rightIndex] == null) {
                        _tree[rightIndex] = value;
                        break;
                    } else if (rightIndex < _tree.length){
                        currentIndex = rightIndex;
                    }else {
                        break;
                    }
                }
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        // Actualizar
        if (_tree[0] == null) {
            System.out.println();
            return;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 
        
        while (!stack.isEmpty()){
            int currentIndex = stack.pop();
            System.out.print(_tree[currentIndex] + " ");
            
            int rightIndex = 2 * currentIndex + 2;
            int leftIndex = 2 * currentIndex + 1;
            
            if(rightIndex < _tree.length && _tree[rightIndex] != null){
                stack.push(rightIndex);
            }
            if (leftIndex < _tree.length && _tree[leftIndex] != null){
                stack.push(leftIndex);
            }
        }

        System.out.println();
    }

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        // Actualizar
        if (_tree[0] == null){
            System.out.println();
            return;
        }
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(0);
        
        while (!stack1.isEmpty()){
            int currentIndex = stack1.pop();
            stack2.push(currentIndex);
            
            int leftIndex = 2 * currentIndex + 1;
            int rightIndex = 2 * currentIndex + 2;
            
            if (leftIndex < _tree.length && _tree[leftIndex] !=null){
                stack1.push(leftIndex);
            }
            if (rightIndex < _tree.length &&_tree[rightIndex] !=null) {
                stack1.push(rightIndex);
            }
        }
        
        while (!stack2.isEmpty()) {
            int index = stack2.pop();
            System.out.print(_tree[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
