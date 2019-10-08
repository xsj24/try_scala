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

}
