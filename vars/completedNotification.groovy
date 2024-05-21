import org.messages.CompletedMessage

Map call(Map pipelineData = [:]) {

  pipelineData.triggeredBy = pipelineData.triggeredBy ?: "SCM Change"

  CompletedMessage message = new CompletedMessage(
    [
      projectName: pipelineData.projectName,
      gitBranch: pipelineData.gitBranch,
      dockerImage: pipelineData.dockerImage,
      pipelineId: pipelineData.pipelineId,
      pipelineUrl: pipelineData.pipelineUrl,
      triggeredBy: pipelineData.triggeredBy,
    ]
  )

  return message.toSlackElement()
}
