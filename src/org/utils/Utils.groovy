package org.utils

import groovy.json.*

class Utils implements Serializable {

  def jsonSlurper

  Utils() {
    this.jsonSlurper = new JsonSlurper()
  }

  def showCommit(){
    def object = jsonSlurper.parseText('''[
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
  ]''')

    return object
  }

  def buildSection(String name, String value, String icon = ""){
    return [type: "\"section\"", text: [type: "\"mrkdwn\"", text: "\":${icon}: *${name}:* ${value}\""]]
  }

  def buildSectionTitle(String name){
    return [type: "\"section\"", text: [type: "\"mrkdwn\"", text: "\"*${name}:*\""]]
  }

  def buildDivider(){
    return [type: "\"divider\""]
  }

  def buildHeader(String msg){
    return [
      type: "\"header\"",
      text: [
        type: "\"plain_text\"",
        text: "\":construction: ${msg}\"",
        emoji: true
      ]
    ]
  }

  def buildCommitSection(String name, String username, String commitId, String commitUrl, String commitMessage, String commitTime){
    return [
      type: "\"section\"",
      fields: [
          [
              type: "\"mrkdwn\"",
              text: "*Commit ID:*\n<${commitUrl}|:link: {commitId}>"
          ],
          [
              type: "\"mrkdwn\"",
              text: "\"*Author:*\n:bust_in_silhouette: ${name} (${username})\n\n\""
          ],
          [
              type: "\"mrkdwn\"",
              text: "\"*Message:*\n:pencil: ${commitMessage}\n\n\""
          ],
          [
              type: "\"mrkdwn\"",
              text: "\"*Time:*\n:calendar: ${commitTime}\n\n\""
          ]
      ]
    ]
  }

  def buildCommits(){
    def commits = showCommit()

    def result = []

    for (commit in commits){
      def commitSection = buildCommitSection(commit.author.name, commit.author.username, commit.id, commit.url, commit.message, commit.timestamp)

      result << commitSection
    }
  }
}