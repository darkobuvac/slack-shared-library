package org.utils

import groovy.json.JsonSlurper

class Utils implements Serializable {

  def jsonSlurper

  Utils() {
    this.jsonSlurper = new JsonSlurper()
  }

  List<Map> mapCommits(String commitData) {
    def commits = jsonSlurper.parseText(commitData)

    List<Map> result = []

    for (commit in commits) {
      Map data = [
        commitId: commit.id,
        commitUrl: commit.url,
        message: commit.message,
        authorName: commit.author.name,
        authorUsername: commit.author.username,
        time: commit.timestamp
      ]

      result.add(data)
    }

    return result
  }

  def showCommit() {
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

  def buildSection(String name, String value, String icon = '') {
    return [
      type: 'section',
      text:
      [
        type: 'mrkdwn',
        text: ":${icon}: *${name}:* ${value}"
      ]
    ]
  }

  def buildSectionTitle(String name) {
    return [type: 'section', text: [type: 'mrkdwn', text: "*${name}:*"]]
  }

  def buildDivider() {
    return [type: 'divider']
  }

  def buildHeader(String msg, String icon) {
    return [
      type: 'header',
      text: [
        type: 'plain_text',
        text: ":${icon}: ${msg}",
        emoji: true
      ]
    ]
  }

  def buildCommitSection(String name, String username, String commitId, String commitUrl, String commitMessage, String commitTime) {
    return [
      [
        type: 'section',
        text:
        [
          type: 'mrkdwn',
          text: ":hash: *Commit ID:* <${commitUrl}|${commitId}>"
        ]
      ],
      [
        type: 'section',
        text:
        [
          type: 'mrkdwn',
          text: ":pencil: *Message:* ${commitMessage}"
        ]
      ],
      [
        type: 'section',
        fields: [
            [
                type: 'mrkdwn',
                text: ":bust_in_silhouette: *Author:* ${name} (${username})"
            ],
            [
                type: 'mrkdwn',
                text: ":calendar: *Time:* ${commitTime}"
            ]
        ]
      ]
    ]
  }

  def buildCommits() {
    def commits = showCommit()

    def divider = buildDivider()

    def result = []

    for (commit in commits) {
      def commitSection = buildCommitSection(commit.author.name, commit.author.username, commit.id, commit.url, commit.message, commit.timestamp)

      result = [
        *result,
        *commitSection
      ]
      result << divider
    }

    return result
  }

}
