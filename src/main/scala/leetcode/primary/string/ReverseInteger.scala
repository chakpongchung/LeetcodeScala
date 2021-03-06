package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
  *
  * 给定一个 32 位有符号整数，将整数中的数字进行反转。
  * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
  */
object ReverseInteger {
  def reverse(x: Int): Int = {
    if (x == 0) {
      0
    } else {
      val neg = x < 0
      var abs = if (neg) -x else x
      val len = Math.floor(Math.log10(abs) + 1).intValue
      val nums = new Array[Int](len)
//      println(neg, abs, len)
      for (i <- 0 until len) {
        nums(i) = abs % 10
        abs /= 10
      }
//      println(nums.toList)
      abs = 0
      for (i <- 0 until len)
        abs = if(abs > Integer.MAX_VALUE / 10 || (abs == Integer.MAX_VALUE / 10 && nums(i) > Integer.MAX_VALUE % 10)) 0 else abs * 10 + nums(i)

      if (neg) -abs.intValue else abs.intValue
    }
  }
}
