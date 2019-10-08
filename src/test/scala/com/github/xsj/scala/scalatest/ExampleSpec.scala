package com.github.xsj.scala.scalatest

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

@RunWith(classOf[JUnitRunner])
class ExampleSpec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new mutable.Stack[Int]
    stack.push(2)
    stack.push(4)

    stack.pop() should be(4)
    stack.pop() should be(2)
  }

}
