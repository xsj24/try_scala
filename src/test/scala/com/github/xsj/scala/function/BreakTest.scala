package com.github.xsj.scala.function

import org.junit.Test

import scala.util.control.Breaks

/**
  * Scala doesn’t have break or continue key word
  */
class BreakTest {

  @Test
  def testMockBreak(): Unit = {
    import BreakTest._

    breakable {
      val env = System.getenv("SCALA_HOME")
      break
      println(s"found scala home[$env] lets do the real work")
    }
  }


  @Test
  def testBreak(): Unit = {
    Breaks.breakable {
      val env = System.getenv("SCALA_HOME")
      Breaks.break
      println(s"found scala home[$env] lets do the real work")
    }

  }

}

object BreakTest {

  private val BREAK_EXCEPTION = new RuntimeException("break exception")

  def break = throw BREAK_EXCEPTION

  // 有 BUG，吞掉了所有的异常
  def breakable(op: => Unit){
    try {
      op
    } catch {
      case _: Exception =>
    }
  }

}