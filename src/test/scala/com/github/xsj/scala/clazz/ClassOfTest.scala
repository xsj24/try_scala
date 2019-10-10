package com.github.xsj.scala.clazz

import com.google.common.base.Preconditions
import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

import scala.beans.BeanProperty

class ClassOfTest {

  import ClassOfTest._


  @Test
  def testIntro(): Unit = {
    assertThat(classOf[Int] == Integer.TYPE, is(true))
    val user = new User("xsj", 12)
    println(user)
  }

  @Test
  def testInstanceOf(): Unit = {
    assertThat(12L.isInstanceOf[Long], is(true))
  }


}

object ClassOfTest {

  class User {

    @BeanProperty
    var name: String = _

    @BeanProperty
    var age: Int = _

    def this(name: String, age: Int) = {
      this()
      Preconditions.checkArgument(name != null && !name.isEmpty, "name required", null)
      setAge(age)
      setName(name)
    }

  }
}