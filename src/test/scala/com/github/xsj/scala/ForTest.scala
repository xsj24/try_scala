package com.github.xsj.scala

import java.io.File

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.Test

class ForTest {


  @Test
  def testForStatement(): Unit = {
    for (
      file <- new File(".").listFiles();
      filename = file.getName
      if filename.equals(".git")  // guard clause
    ) {
      assertThat(file.isDirectory, is(true))
    }
  }

  @Test
  def testYield(): Unit = {
    // 等价于 Python [n for n in range(10)]
    val seq: Seq[Int] = for (n <- 1 to 10 ) yield n
    assertThat(seq.size, is(10))
  }

  @Test
  def testYieldBlock(): Unit = {
    val map = Map("-h" -> List("method=get", "type=json"))

    def splitByEqual(nameValue:String) = nameValue.split("=")

    val headers = for (elem <- map("-h")) yield {
      val tokens = splitByEqual(elem)
      (tokens(0), tokens(1))
    }
    assertThat(headers.size, is(2))
    assertThat(headers,
      is(List(("method", "get"), ("type", "json")))
    )

  }


}
