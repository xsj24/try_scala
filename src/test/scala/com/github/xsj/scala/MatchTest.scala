package com.github.xsj.scala

import org.junit.Assert.assertThat
import org.hamcrest.Matchers._
import org.junit.{Rule, Test}
import org.junit.rules.ExpectedException

import scala.annotation.meta.getter

class MatchTest {

  @(Rule @getter)
  var expectedException: ExpectedException = ExpectedException.none()

  @Test
  def testMatchError(): Unit = {
    expectedException.expect(classOf[MatchError])
    2 match { case 1 => println("hello")}
  }

  @Test
  def testTypeMatch(): Unit = {

    def _match(obj: AnyRef) = obj match {
      case ls : List[_] => "str"
      case _ => "other"
    }
    assertThat(_match(List(1, 2, 3)), is("str"))
  }

  @Test
  def testInfix(): Unit = {
    val result = List(1, 2, 3, 4) match {
      case f :: s :: rest => List(f, s)
      case _ => Nil
    }
    assertThat(result, is(List(1, 2)))
  }


  @Test
  def testGuardClause(): Unit = {
    def _rangeMatcher(num:Int) = num match {
      case within10 if within10 <= 10 => "10"
      case within100 if within100 <= 100 => "100"
      case within1000 if within1000 <= 1000 => "1000"
      case _ => throw new IllegalArgumentException()
    }

    assertThat(_rangeMatcher(100), is("100"))
  }

}
