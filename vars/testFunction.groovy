import org.components.SectionText
import org.components.Header
import org.commons.Types

Map call() {
  SectionText section = new SectionText('*Project*: CxO Customer Management', 'rocket', Types.MARK_DOWN)
  Header header = new Header('Commits', 'hash')

  Map slackBlock = section.toSlackElement()

  echo "${slackBlock}"
  echo "${header}"

  return slackBlock
}
