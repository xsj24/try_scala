package com.github.xsj.scala.clazz

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

import scala.annotation.meta.{beanGetter, beanSetter}
import scala.beans.BeanProperty

class ClassOfTest {

  import ClassOfTest._


  @Test
  def testIntro(): Unit = {
    assertThat(classOf[Int] == Integer.TYPE, is(true))
    val user = new User()
    user.setName("xsj")
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


  }
}