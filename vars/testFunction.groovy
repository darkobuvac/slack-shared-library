
import org.messages.StartBuildMessage

Map call() {
  StartBuildMessage startMessage = new StartBuildMessage(projct: 'CxO Customer Management', message: 'Pipeline started')

  echo "${startMessage.toSlackBlock()}"

  return startMessage
}
