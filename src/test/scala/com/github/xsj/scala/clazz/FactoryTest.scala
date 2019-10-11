package com.github.xsj.scala.clazz


import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

package factory_test {

  abstract class Role {
    def canAccess(page: String): Boolean
  }

  class Root extends Role {
    override def canAccess(page:String): Boolean = true
  }

  class SuperAnalyst extends Role {
    override def canAccess(page:String): Boolean = !"Admin".equals(page)
  }

  object Role {
    def apply(roleName:String): Role = roleName match {
      case "root" => new Root
      case "superAnalyst" => new SuperAnalyst
      case _ => throw new IllegalArgumentException("illegal roleName: " + roleName)
    }
  }

}

class FactoryTest {

  @Test
  def testApply(): Unit = {
    import com.github.xsj.scala.clazz.factory_test.Role
    val role = Role("root")
    assertThat(role.canAccess("manage"), is(true))
  }

}
