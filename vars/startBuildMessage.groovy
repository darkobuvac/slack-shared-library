#!/usr/bin/env groovy

def call(Map data = [:]) {
  
  def timestamp = new Date().format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC"))
  
  def slackMessage = [
    type: "section",
    text: [
      type: "mrkdwn",
      text: "*${data.pipelineName}* pipeline build *#${buildNumber}* has started at ${timestamp}"
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
      text: "*Build Number:*\n${data.buildNumber}"
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
  
  def fieldsSection = [
    type: "section",
    fields: fields
  ]
  
  def slackBlocks = [slackMessage, divider,  fieldsSection, divider]
  
  return slackBlocks
}