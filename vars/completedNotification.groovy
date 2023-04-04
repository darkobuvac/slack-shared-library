import org.messages.CompletedMessage

Map call(Map pipelineData = [:]) {
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
