package com.github.xsj.scala.clazz

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.Test

class SingletonTest {

  class Simple private {
    def info(msg: Any): String = {
      s"info: $msg"
    }
  }

  object Simple {
    private val _singleton = new Simple()

    def instance(): Simple = {
      _singleton
    }
  }

  @Test
  def testSimpleSingleton(): Unit = {
    assertThat(Simple.instance().info("hello"), is("info: hello"))
    assertThat(Simple.instance().info(233), is("info: 233"))

    assertThat(classOf[Simple] == Simple.getClass, is(false))
  }




}