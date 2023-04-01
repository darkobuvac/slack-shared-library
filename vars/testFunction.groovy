
import org.messages.StartBuildMessage

Map call() {
  StartBuildMessage startMessage = new StartBuildMessage(projct: 'CxO Customer Management')

  echo "${startMessage.toSlackBlock()}"

  return slackBlock
}
