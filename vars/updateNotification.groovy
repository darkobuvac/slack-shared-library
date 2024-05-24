import org.components.SectionText
import org.commons.Types

def call(List<Map> blocks = []) {

  SectionText completedMessage = new SectionText(
      '*The build and deploy pipeline has successfully completed*',
      'white_check_mark',
      Types.MARK_DOWN)

  blocks.remove(blocks.size() - 1)

  blocks.add(completedMessage.toSlackElement())

  return blocks
}
