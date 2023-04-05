
import org.messages.StartBuildMessage
import org.utils.Utils

Map call(Map pipelineData = [:]) {
  String timestamp = new Date().format('YYYY-MM-dd HH:mm:ss', TimeZone.getTimeZone('CET'))

  Utils utils = new Utils()

  List<Map> commits = utils.mapCommits(data.commits)

  StartBuildMessage startMessage = new StartBuildMessage(
    commits,
    [
      projectName: pipelineData.projectName,
      startedAt: timestamp,
      gitBranch: pipelineData.gitBranch,
      dockerImage: pipelineData.dockerImage,
      pipelineId: pipelineData.pipelineId,
      pipelineUrl: pipelineData.pipelineUrl,
      triggeredBy: pipelineData.triggeredBy
    ]
  )

  return startMessage.toSlackBlock()
}
