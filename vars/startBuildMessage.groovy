#!/usr/bin/env groovy

def call(Map data = [:]) {
  
  def timestamp = new Date().format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC"))
  
  def slackMessage = [
    type: "section",
    text: [
      type: "mrkdwn",
      text: "*${data.pipelineName}* pipeline build *#${data.buildNumber}* has started at ${timestamp}"
    ]
  ]

  def divider = [
    type: "divider"
  ]
  
  def fields = [
    [
      type: "mrkdwn",
      text: "*Build Name:*\n${data.buildName}"
    ],
    [
      type: "mrkdwn",
      text: "*Started By:*\n${data.startedBy}"
    ],
    [
      type: "mrkdwn",
      text: "*Build Status:*\n${data.buildStatus}"
    ]
  ]
  
  def slackBlocks = [slackMessage, divider,  fields, divider]

  sh "echo ${slackBlocks} ${data}" 
  
  return slackBlocks
}