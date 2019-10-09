package com.github.xsj.scala.collection

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.Matchers._

import scala.collection.mutable.ArrayBuffer

class ArrayTest {

  @Test
  def testConstruct(): Unit = {
    val array = new Array[String](3)
    array(0) = "Just"
    array(1) = "a"
    array(2) = "test"
    assertThat(array.length, is(3))
  }

  @Test
  def testParseArray(): Unit = {

    def parseArgs(args: Array[String]) : Map[String, List[String]] = {

      def nameValuePair(paramName: String) = {
        def values(commaSeparatedValues: String) = {
          commaSeparatedValues.split(",").toList
        }

        val index = args.indexOf(paramName)
        (paramName, if (index == -1) Nil else values(args(index + 1)))
      }

      Map(nameValuePair("-d"), nameValuePair("-h"))
    }


    assertThat(parseArgs("-d 12 -h xsj,sdf".split("\\s")),
      is(Map("-d" -> List("12"), "-h" -> List("xsj", "sdf"))))

  }


  @Test
  def testArrayBuffer(): Unit = {
    // 不定长 array
    val buffer = new ArrayBuffer[Int]()
    buffer += 1
    buffer.append(2, 3, 4)
    buffer ++= Array(5, 6)
    assertThat(buffer.size, is(6))

    assertThat(buffer.toArray, is(Array(1, 2, 3, 4, 5, 6)))
  }

}
