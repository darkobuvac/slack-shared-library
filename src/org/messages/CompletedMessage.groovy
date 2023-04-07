package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText

/**
 * Message sent when Jenkin pipeline completes
 */
@CompileDynamic
class CompletedMessage {

  String projectName
  String gitBranch
  String dockerImage
  String pipelineId
  String pipelineUrl
  String triggeredBy

  private List<Map> slackElements = []

  CompletedMessage(Map data = [:]) {
    this.projectName = data.projectName
    this.gitBranch = data.gitBranch
    this.dockerImage = data.dockerImage
    this.pipelineId = data.pipelineId
    this.pipelineUrl = data.pipelineUrl
    this.triggeredBy = data.triggeredBy
  }

  List<Map> toSlackElement() {
    populateSlackElements()

    return this.slackElements
  }

  private void populateSlackElements() {
    String timestamp = new Date().format('YYYY-MM-dd HH:mm:ss', TimeZone.getTimeZone('CET'))

    Divider divider = new Divider()

    Header header = new Header("Build #${this.pipelineId} completed", 'white_check_mark')
    SectionText subtitle = new SectionText(
      "${this.projectName} build & deploy pipeline has been completed",
      '',
      Types.PLAIN_TEXT
    )
    SectionText project = new SectionText("*Project*: ${this.projectName}", 'rocket', Types.MARK_DOWN)
    SectionText dateTime = new SectionText("*End at*: ${timestamp}", 'date', Types.MARK_DOWN)
    SectionText git = new SectionText("*Git branch*: ${this.gitBranch}", 'git', Types.MARK_DOWN)
    SectionText docker = new SectionText("*Docker image*: ${this.dockerImage}", 'docker', Types.MARK_DOWN)
    SectionText pipelineId = new SectionText("*Pipeline Id*: ${this.pipelineId}", 'id', Types.MARK_DOWN)
    SectionText pipelineUrl = new SectionText(
      "*Pipeline*: <${this.pipelineUrl}|View pipeline on Jenkins>",
      'link',
      Types.MARK_DOWN)
    SectionText triggeredBy = new SectionText(
      "*Triggered By*: ${this.triggeredBy}",
      'bust_in_silhouette',
      Types.MARK_DOWN
    )

    SectionText congratulation = new SectionText('*Great job team!*', 'tada', Types.MARK_DOWN)

    List<Map> result = [
      header.toSlackElement(),
      subtitle.toSlackElement(),
      divider.toSlackElement(),
      project.toSlackElement(),
      dateTime.toSlackElement(),
      git.toSlackElement(),
      docker.toSlackElement(),
      pipelineId.toSlackElement(),
      pipelineUrl.toSlackElement(),
      triggeredBy.toSlackElement(),
      divider.toSlackElement(),
      congratulation.toSlackElement(),
    ]

    this.slackElements = result
  }

}
