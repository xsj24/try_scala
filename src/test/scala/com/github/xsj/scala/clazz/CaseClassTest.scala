package com.github.xsj.scala.clazz

import com.github.xsj.scala.clazz.CaseClassTest.{Car, Person}
import com.github.xsj.scala.clazz.Gender.Gender
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

@RunWith(classOf[JUnit4])
class CaseClassTest {

  @Test
  def testConstruct(): Unit = {
    val p = CaseClassTest.Person("xsj", 12, deleted = true, Gender.MALE)
    assertThat(p.deleted, is(true))
    assertThat(p.name, is("xsj"))
    assertThat(p.gender, is(Gender.MALE))
  }

  @Test
  def testMatch(): Unit = {
    val o: Object = CaseClassTest.Car("A", 12L)
    val res: String = o match {
      case Person(name, _, _, _) => name
      case Car(name, _) => name
      case _ => "unknown"
    }
    assertThat(res, is("A"))
  }

}

object CaseClassTest {

  // 静态内部类
  case class Person(name: String, age: Int, deleted: Boolean, gender: Gender)

  case class Car(name: String, weight: Long)

}


