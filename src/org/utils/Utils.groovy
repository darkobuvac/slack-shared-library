package org.utils

import groovy.json.*

class Utils implements Serializable {

  def jsonSlurper

  Utils() {
    this.jsonSlurper = new JsonSlurper()
  }

  def showCommit(){
    def object = jsonSlurper.ParseText('{"id": "633b208ab9dd9d56bd7efa143cd7721d89081640"}')

    echo "${object}"
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
}