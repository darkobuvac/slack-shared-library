import org.components.SectionText
import org.commons.Types

Map call() {
  SectionText section = new SectionText(text: 'Test', icon: 'rocket', textElementType: Types.PLAIN_TEXT, isBold: true)

  Map slackBlock = section.toSlackElement()

  echo "${slackBlock}"

  return slackBlock
}
