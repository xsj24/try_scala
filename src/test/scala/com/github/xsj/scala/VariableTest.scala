package com.github.xsj.scala

import java.util.concurrent.TimeUnit

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.{Ignore, Test}

class VariableTest {

  @Test
  @Ignore
  def testLazy(): Unit = {
    // 懒加载，The lazy keyword is allowed only with val
    lazy val forLater = {
      TimeUnit.SECONDS.sleep(1)
      "Highway to hell"
    }
    assertThat(classOf[String].isInstance(forLater), is(true))
  }

}
