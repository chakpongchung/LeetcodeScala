package leetcode.primary.array

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
  *
  * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
  * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
  * 你可以假设除了整数 0 之外，这个整数不会以零开头。
  */
object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    /**
      * 当前位相加,如果超过10,找下一位加一,如果超过10且最高位,拼接数组多加一个1
      * @param digits 数字
      * @param delta 变化值
      * @param i 游标
      * @return
      */
    def plus(digits: Array[Int], delta: Int, i: Int): Array[Int] = {
      val res = digits(i) + delta
      digits(i) = res % 10
      if (res < 10) digits else if (i == 0) (1 :: digits.toList).toArray else plus(digits, 1, i - 1)
    }

    plus(digits, 1, digits.length - 1)
  }
}
