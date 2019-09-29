package com.github.xsj.scala.collection


import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

class ListTest {

  @Test
  def testConstruct(): Unit = {
    val l1 = List(1, 2)
    val l2 = 3 :: l1
    // 通过 head 和 tail，prepend 新值
    assertThat(l2.tail, is(l1))
  }

}
