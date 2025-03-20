import java.util.*;

class ExpressionTreeEvaluator {  // Renamed from Program
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int evaluateExpression(BinaryTree node) {  // Renamed from evaluateExpressionTree
    if (node.value >= 0) {
      return node.value;  // Return directly if it's a leaf node
    }

    int leftResult = evaluateExpression(node.left);  // Renamed from leftValue
    int rightResult = evaluateExpression(node.right); // Renamed from rightValue

    switch (node.value) {
      case -1: return leftResult + rightResult;
      case -2: return leftResult - rightResult;
      case -3: 
        if (rightResult == 0) {
          throw new ArithmeticException("Division by zero is not allowed.");
        }
        return leftResult / rightResult; // Integer division
      case -4: return leftResult * rightResult;
      default: throw new IllegalArgumentException("Invalid operator value: " + node.value);
    }
  }

  public static void main(String[] args) {
    ExpressionTreeEvaluator evaluator = new ExpressionTreeEvaluator();
    
    // Example: (3 + (10 - 5)) = 8
    BinaryTree root = new BinaryTree(-1); // "+"
    root.left = new BinaryTree(3);
    root.right = new BinaryTree(-2); // "-"
    root.right.left = new BinaryTree(10);
    root.right.right = new BinaryTree(5);

    int result = evaluator.evaluateExpression(root);
    System.out.println("Result: " + result); // Expected output: 8
  }
}
