package org.utils

class Utils implements Serializable {

  Utils() {}

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
}