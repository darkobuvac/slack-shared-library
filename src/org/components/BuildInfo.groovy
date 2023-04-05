package org.components

import groovy.transform.CompileDynamic

import org.commons.Types

/**
 * Represents section in slack massages that displays started pipelin info
 */
@CompileDynamic
class BuildInfo {

  String project
  String startedAt
  String gitBranch
  String dockerImage
  String pipelineId
  String pipelineUrl
  String triggeredBy

  private List<Map> slackElement = []

  BuildInfo(Map data = [:]) {
    this.project = data.projectName
    this.startedAt = data.startedAt
    this.gitBranch = data.gitBranch
    this.dockerImage = data.dockerImage
    this.pipelineId = data.pipelineId
    this.pipelineUrl = data.pipelineUrl
    this.triggeredBy = data.triggeredBy
  }

  List<Map> toSlackElement() {
    populateSlackElement()

    return this.slackElement
  }

  private void populateSlackElement() {
    SectionField projectData = new SectionField([
      [
        value: "*Project*: ${this.project}",
        icon: 'rocket'
      ],
      [
        value: "*Started at*: ${this.startedAt}",
        icon: 'date'
      ]
    ])

    SectionField gitAndDocker = new SectionField([
      [
        value: "*Git branch*: ${this.gitBranch}",
        icon: 'git'
      ],
      [
        value: "*Docker image*: ${this.dockerImage}",
        icon: 'docker'
      ]
    ])

    SectionField pipelineData = new SectionField([
      [
        value: "*Build ID*: ${this.pipelineId}",
        icon: 'id'
      ],
      [
        value: "*Pipeline*: <${this.pipelineUrl}|View pipeline on Jenkins>",
        icon: 'link'
      ]
    ])

    SectionText triggeredBy = new SectionText(
      "*Triggered by*: ${this.triggeredBy}",
      'bust_in_silhouette',
      Types.MARK_DOWN
    )

    List<Map> result = [
      projectData.toSlackElement(),
      gitAndDocker.toSlackElement(),
      pipelineData.toSlackElement(),
      triggeredBy.toSlackElement()
    ]

    this.slackElement = result
  }

}
