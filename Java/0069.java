/*Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. */
class Solution {

  public int mySqrt(int x) {
    int left = 0;
    int right = x;
    int middle = 0;
    if (x == 1 || x == 0) return x;
    while (left < right) {
      middle = (left + right) / 2;
      if (middle > x / middle) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }
    return right - 1;
  }
}
