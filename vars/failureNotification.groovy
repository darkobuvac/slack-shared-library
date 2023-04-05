import org.messages.FailureMessage

Map call(Map pipelineData = [:]) {
  FailureMessage message = new FailureMessage(
    [
      projectName: pipelineData.projectName,
      gitBranch: pipelineData.gitBranch,
      pipelineId: pipelineData.pipelineId,
      pipelineUrl: pipelineData.pipelineUrl,
      triggeredBy: pipelineData.triggeredBy,
    ]
  )

  return message.toSlackElement()
}
