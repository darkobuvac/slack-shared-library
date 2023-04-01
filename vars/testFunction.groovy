import org.components.SectionText
import org.components.Header
import org.commons.Types

import org.messages.StartBuildMessage

Map call() {
  SectionText section = new SectionText('*Project*: CxO Customer Management', 'rocket', Types.MARK_DOWN)
  Header header = new Header('Commits', 'hash')
  StartBuildMessage startMessage = new StartBuildMessage(projct: 'CxO Customer Management')

  Map slackBlock = section.toSlackElement()

  echo "${slackBlock}"
  echo "${header.toSlackElement()}"
  echo "${startMessage.toSlackBlock()}"

  return slackBlock
}
