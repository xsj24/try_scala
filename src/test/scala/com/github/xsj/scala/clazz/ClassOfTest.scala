package com.github.xsj.scala.clazz

import org.junit.Test

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

class ClassOfTest {

  @Test
  def testIntro(): Unit = {
    assertThat(classOf[Int] == Integer.TYPE, is(true))
  }

}
