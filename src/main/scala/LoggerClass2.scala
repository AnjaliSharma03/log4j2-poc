
import org.apache.logging.log4j.scala.Logging

class LoggerClass2 extends Logging {
  def doStuff(): Unit = {
    logger.info("Doing something")
  }
  def doStuffWithUser(user: String): Unit = {
    logger.info(s"Doing something with $user")
  }
}
object LoggerClass2 extends App with Logging{
  logger.info("Hi im using log4j2 library")
  val loggerObject = new LoggerClass2
  loggerObject.doStuff()
  loggerObject.doStuffWithUser("Knoldus")
}
