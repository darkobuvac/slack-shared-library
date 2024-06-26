import org.components.SectionText
import org.commons.Types
import org.components.Header

def call(List<Map> blocks = [], Map data = [:]) {

  SectionText completedMessage = new SectionText(
      '*The build and deploy pipeline has successfully completed!*',
      'success',
      Types.MARK_DOWN)

  SectionText failedMessage = new SectionText(
      '*The build and deploy pipeline has encountered an error and failed!*',
      'red-x-mark',
      Types.MARK_DOWN)

  Header successHeader = new Header(
    "${data.projectName}: Build #${data.pipelineId} completed", 
    'white_check_mark', 'white_check_mark'
    )
  Header failedHeader = new Header("${data.projectName}: Build #${data.pipelineId} failed", 'alert', 'alert')

  blocks.remove(0)
  blocks.remove(blocks.size() - 1)

  if(data.status == 1){
    blocks.add(0, successHeader.toSlackElement())
    blocks.add(completedMessage.toSlackElement())
  }else{
    blocks.add(0, failedHeader.toSlackElement())
    blocks.add(failedMessage.toSlackElement())
  }


  return blocks
}
