package com.github.xsj.scala.collection

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._


class StringTest {

  @Test
  def testMultipleLineString(): Unit = {
    val str =
      """This is a
        |test string""".stripMargin
    assertThat(str, is("This is a\ntest string"))
  }


  @Test
  def testFormattedString(): Unit = {
    val name = "xsj"
    val height = 170.455
    val result = f"$name%s is $height%2.2f meters tall"
    assertThat(result, is("xsj is 170.46 meters tall"))
  }


  @Test
  def testIsUpper(): Unit = {
    val str = "hellO"
    // _.isUpper 等价于 c => c.isUpper
    assertThat(str.exists(_.isUpper), is(true))
  }

}
