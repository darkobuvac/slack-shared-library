
import org.messages.StartBuildMessage

Map call() {
  def timestamp = new Date().format('YYYY-MM-dd HH:mm:ss', TimeZone.getTimeZone('CET'))

  StartBuildMessage startMessage = new StartBuildMessage(
    [
      [
        commitId: '633b208ab9dd9d56bd7efa143cd7721d89081640',
        commitUrl: 'https://github.com/codaxy/cxo-customer-management/commit/633b208ab9dd9d56bd7efa143cd7721d89081640',
        message: 'cascade on delete',
        authorName: 'Ognjen Katić',
        authorUsername: 'ognjenkatic',
        time: '2023-03-30T11:44:55+02:00'
      ],
      [
        commitId: '633b208ab9dd9d56bd7efa143cd7721d89081640',
        commitUrl: 'https://github.com/codaxy/cxo-customer-management/commit/633b208ab9dd9d56bd7efa143cd7721d89081640',
        message: 'cascade on delete',
        authorName: 'Ognjen Katić',
        authorUsername: 'ognjenkatic',
        time: '2023-03-30T11:44:55+02:00'
      ]
    ],
    [
      projectName: 'CxO Customer Management',
      startedAt: timestamp,
      gitBranch: 'main',
      dockerImage: 'ghcr.io/codaxy/cxo-customer-management:latest',
      pipelineId: '55',
      pipelineUrl: 'http://jenkins.codaxy.com:50888/job/CxO - CustomerManagement/65/',
      triggeredBy: 'Darko Buvac'
    ]
  )

  echo "${startMessage.toSlackBlock()}"

  return startMessage
}
