
import org.messages.StartBuildMessage
import org.utils.Utils

Map call(Map buildData = [:]) {
  String timestamp = new Date().format('YYYY-MM-dd HH:mm:ss', TimeZone.getTimeZone('CET'))

  Utils utils = new Utils()

  List<Map> commits = utils.mapCommits(
    '''[
    {
      "id": "633b208ab9dd9d56bd7efa143cd7721d89081640",
      "tree_id": "e8d78513128b1e78feeb5dbc4a525e830a019e50",
      "distinct": true,
      "message": "cascade on delete",
      "timestamp": "2023-03-30T11:44:55+02:00",
      "url": "https://github.com/codaxy/cxo-customer-management/commit/633b208ab9dd9d56bd7efa143cd7721d89081640",
      "author": {
        "name": "Ognjen Katić",
        "email": "44910579+ognjenkatic@users.noreply.github.com",
        "username": "ognjenkatic"
      },
      "committer": {
        "name": "Ognjen Katić",
        "email": "44910579+ognjenkatic@users.noreply.github.com",
        "username": "ognjenkatic"
      },
      "added": [
        "src/CustomerManagement.Infrastructure/Persistence/Migrations/20230330094444_AddCascadeDeleteToRelatedParty.Designer.cs",
        "src/CustomerManagement.Infrastructure/Persistence/Migrations/20230330094444_AddCascadeDeleteToRelatedParty.cs"
      ],
      "removed": [],
      "modified": [
        "src/CustomerManagement.Infrastructure/Persistence/Configurations/RelatedPartyConfiguration.cs",
        "src/CustomerManagement.Infrastructure/Persistence/Migrations/CustomerManagementDbContextModelSnapshot.cs"
      ]
    },
    {
      "id": "633b208ab9dd9d56bd7efa143cd7721d89081640",
      "tree_id": "e8d78513128b1e78feeb5dbc4a525e830a019e50",
      "distinct": true,
      "message": "cascade on delete",
      "timestamp": "2023-03-30T11:44:55+02:00",
      "url": "https://github.com/codaxy/cxo-customer-management/commit/633b208ab9dd9d56bd7efa143cd7721d89081640",
      "author": {
        "name": "Ognjen Katić",
        "email": "44910579+ognjenkatic@users.noreply.github.com",
        "username": "ognjenkatic"
      },
      "committer": {
        "name": "Ognjen Katić",
        "email": "44910579+ognjenkatic@users.noreply.github.com",
        "username": "ognjenkatic"
      },
      "added": [
        "src/CustomerManagement.Infrastructure/Persistence/Migrations/20230330094444_AddCascadeDeleteToRelatedParty.Designer.cs",
        "src/CustomerManagement.Infrastructure/Persistence/Migrations/20230330094444_AddCascadeDeleteToRelatedParty.cs"
      ],
      "removed": [],
      "modified": [
        "src/CustomerManagement.Infrastructure/Persistence/Configurations/RelatedPartyConfiguration.cs",
        "src/CustomerManagement.Infrastructure/Persistence/Migrations/CustomerManagementDbContextModelSnapshot.cs"
      ]
    }
    ]'''
  )

  StartBuildMessage startMessage = new StartBuildMessage(
    commits,
    [
      projectName: buildData.projectName,
      startedAt: timestamp,
      gitBranch: buildData.gitBranch,
      dockerImage: buildData.dockerImage,
      pipelineId: buildData.pipelineId,
      pipelineUrl: buildData.pipelineUrl,
      triggeredBy: buildData.triggeredBy
    ]
  )

  return startMessage
}
