import org.components.SectionText

Map call() {
  SectionText section = new SectionText(text: 'Test', icon: 'rocket', textElementType: 'plain_text', isBold: true)

  Map slackBlock = section.toSlackElement()

  echo "${slackBlock}"

  return slackBlock
}
