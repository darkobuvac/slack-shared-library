import org.components.SectionText
import org.commons.Types

Map call() {
  SectionText section = new SectionText('*Project*: CxO Customer Management', 'rocket', Types.MARK_DOWN)

  Map slackBlock = section.toSlackElement()

  echo "${slackBlock}"

  return slackBlock
}
