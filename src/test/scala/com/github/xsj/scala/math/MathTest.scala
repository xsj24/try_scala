package com.github.xsj.scala.math

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.Test

class MathTest {

  @Test
  def testPi(): Unit = {
    val value = BigDecimal.valueOf(scala.math.Pi).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString()
    assertThat(value, is("3.14"))
  }

}
