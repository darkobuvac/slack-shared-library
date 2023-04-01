import org.components.SectionText
import org.commons.Types

Map call() {
  SectionText section = new SectionText('Test', 'rocket', Types.PLAIN_TEXT)

  Map slackBlock = section.toSlackElement()

  echo "${slackBlock}"

  return slackBlock
}
