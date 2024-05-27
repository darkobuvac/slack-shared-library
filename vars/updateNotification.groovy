import org.components.SectionText
import org.commons.Types
import org.components.Header

def call(List<Map> blocks = [], Map data = [:]) {

  SectionText completedMessage = new SectionText(
      '*The build and deploy pipeline has successfully completed!*',
      'white_check_mark',
      Types.MARK_DOWN)

  SectionText failedMessage = new SectionText(
      '*The build and deploy pipeline has encountered an error and failed!*',
      'alert',
      Types.MARK_DOWN)

  Header successHeader = new Header("${data.projectName}: Build #${buildData.pipelineId} completed", 'white_check_mark')
  Header failedHeader = new Header("${data.projectName}: Build #${buildData.pipelineId} failed", 'alert')

  blocks.remove(0)
  blocks.remove(blocks.size() - 1)

  if(data.status == 1){
    blocks.add(0, successHeader)
    blocks.add(completedMessage.toSlackElement())
  }else{
    blocks.add(0, failedHeader)
    blocks.add(failedMessage.toSlackElement())
  }


  return blocks
}
