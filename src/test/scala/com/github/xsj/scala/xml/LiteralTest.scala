package com.github.xsj.scala.xml

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.Test

class LiteralTest {

  @Test
  def testIntro(): Unit = {
    val code = "0001"
    val message = "I didn't know xml could be so much fun"
    val alert = <alert>
        <message priority={code}>{message}</message>
        <date>{new java.util.Date()}</date>
    </alert>
    assertThat(alert.getClass == classOf[scala.xml.Elem], is(true))
  }

}
