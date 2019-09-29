package com.github.xsj.scala.function

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.Test

class IntroTest {

  @Test
  def testParameterized(): Unit = {
    def toList[A](value: A) = List(value)

    val li = toList(12)
    assertThat(li.size, is(1))

    val ls = toList("hell")
    assertThat(ls.head, is("hell"))
    assertThat(ls.tail.isEmpty, is(true))
  }

  @Test
  def testFunctionLiteral(): Unit = {
    val li = List(2, 4, 6, 8, 10)
    assertThat(li.sum, is(30))
    assertThat(li(2), is(6))
  }

}
