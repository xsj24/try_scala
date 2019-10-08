package com.github.xsj.scala.collection


import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

import scala.collection.mutable.ListBuffer

class ListTest {

  @Test
  def testConstruct(): Unit = {
    val l1 = List(1, 2)
    val l2 = 3 :: l1
    // 通过 head 和 tail，prepend 新值
    assertThat(l2.tail, is(l1))

    val l3 = l2 :+ 8
    println(l3.head)
  }

  @Test
  def testNil(): Unit = {
    val list = "This" :: "is" :: "immutable" :: Nil
    assertThat(list.size, is(3))
  }

  @Test
  def testFilter(): Unit = {
    val l = List(1, 2, 3, 4)
    val filtered = l.filterNot(_ == 4)
    assertThat(filtered, is(List(1, 2, 3)))
    assertThat(l.filter(_ != 1), is(List(2, 3, 4)))
  }


  @Test
  def testCommonFor(): Unit = {
    val l = List(1, 2, 3, 4)
    val builder = new StringBuilder(16)

    // <- 这货是函数....
    for (elem <- l) {
      builder.append(elem)
        .append(',')
    }
    assertThat(builder.toString(), is("1,2,3,4,"))
  }


  @Test
  def testMkString(): Unit = {
    val list = List(1, 2, 3, 4)
    assertThat(list.mkString("[", ",", "]"), is("[1,2,3,4]"))
  }

  @Test
  def testRange(): Unit = {
    assertThat((1 to 10).size, is(10))
    assertThat((1 until 10).size, is(9))
  }



  @Test
  def testListBuffer(): Unit = {
    val buffer = ListBuffer.empty[Int]
    buffer += 1
    assertThat(buffer.size, is(1))
  }

}
