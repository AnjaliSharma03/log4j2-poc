import org.apache.logging.log4j.message.MessageFactory2
import org.apache.logging.log4j.Level
import java.util.UUID
import org.apache.logging.log4j.scala.{Logging, LoggingContext}

object MyApp extends App with Logging{
  val s1 = "foo"
  val s2 = "bar"
  val t = new RuntimeException("error")

  logger.info(s"Hello, world: $s1 $s2")

  logger.traceEntry()
  logger.traceEntry(s1, s2)
  val entryMessage = logger.traceEntry(logger.delegate.getMessageFactory.asInstanceOf[MessageFactory2].newMessage("foobar": CharSequence))

  logger.traceExit()
  logger.traceExit(s2)
  logger.traceExit(entryMessage)
  logger.traceExit(entryMessage, s2)
  logger.traceExit(logger.delegate.getMessageFactory.asInstanceOf[MessageFactory2].newMessage("bonsai": CharSequence), s2)

  logger.throwing(t)
  logger.throwing(Level.INFO, t)

  logger.catching(t)
  logger.catching(Level.INFO, t)

  LoggingContext("correlationId") = UUID.randomUUID().toString
  logger.info("Logging with a correlation ID set")
  LoggingContext.clear()
  logger.info("Logging without the correlation ID")
}