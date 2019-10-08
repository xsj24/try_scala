package com.github.xsj.scala.collection

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

class MapTest {

  @Test
  def intro(): Unit = {
    val map = Map("a" -> 2, "b" -> 3)
    assertThat(map.size, is(2))
    assertThat(map.isEmpty, is(false))
    assertThat(map("a"), is(2))

    val newMap = map + ("c" -> 4)
    assertThat(newMap.contains("c"), is(true))


  }

  @Test
  def testTuple(): Unit = {
    val tuple = ("name", "xsj")
    assertThat(tuple._1, is("name"))
    assertThat(tuple._2, is("xsj"))
  }


}
