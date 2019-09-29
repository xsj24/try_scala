package com.github.xsj.scala.collection

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

class ArrayTest {

  @Test
  def testConstruct(): Unit = {
    val array = new Array[String](3)
    array(0) = "Just"
    array(1) = "a"
    array(2) = "test"
    assertThat(array.length, is(3))
  }

}
