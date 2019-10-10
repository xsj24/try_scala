package com.github.xsj.scala

import java.time.LocalDate

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

class ImportTest {

  @Test
  def testSqlDate(): Unit = {
    import java.sql.{Date => SqlDate}
    val date = SqlDate.valueOf("2016-09-12")
    assertThat(date.toLocalDate, is(LocalDate.of(2016, 9, 12)))
  }

}
