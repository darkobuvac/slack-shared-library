import org.components.SectionText
import org.commons.Types

def call(List<Map> blocks = [], int status = 1) {

  SectionText completedMessage = new SectionText(
      '*The build and deploy pipeline has successfully completed!*',
      'white_check_mark',
      Types.MARK_DOWN)

  SectionText failedMessage = new SectionText(
      '*The build and deploy pipeline has encountered an error and failed!*',
      'alert',
      Types.MARK_DOWN)

  blocks.remove(blocks.size() - 1)

  if(status == 1){
    blocks.add(completedMessage.toSlackElement())
  }else{
    blocks.add(failedMessage.toSlackElement())
  }


  return blocks
}
