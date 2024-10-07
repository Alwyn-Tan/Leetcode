package TestProject.src;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
TestProject.src.Solution solution = new TestProject.src.Solution();
    int [] arr = {11,13,17,23,29,31,7,5,2,3};
    int k = 3;
    int threshold = 5;
    solution.numOfSubarrays(arr, k, threshold);
    }
}