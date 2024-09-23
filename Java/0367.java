/*Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt. */
class Solution {

  public boolean isPerfectSquare(int num) {
    if (num == 0 || num == 1) {
      return true;
    }
    int left = 0;
    int right = num;
    while (left < right) {
      int mid = (left + right) / 2;
      if (mid > num / mid) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return (right - 1) * (right - 1) == num;
  }
}
