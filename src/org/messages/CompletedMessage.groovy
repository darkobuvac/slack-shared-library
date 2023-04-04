package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText

/**
 * Message sent when Jenkin pipelien was triggered
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

    Header header = new Header('Pipeline completed', 'white_check_mark')
    SectionText subtitle = new SectionText(
      "${this.projectName} build & deploy pipeline has been completed",
      '',
      Types.PLAIN_TEXT
    )
    SectionText project = new SectionText("*Project*: ${this.projectName}", '', Types.MARK_DOWN)
    SectionText dateTime = new SectionText("*Git branch*: ${timestamp}", '', Types.MARK_DOWN)
    SectionText git = new SectionText("*Git branch*: ${this.gitBranch}", '', Types.MARK_DOWN)
    SectionText docker = new SectionText("*Docker image*: ${this.dockerImage}", '', Types.MARK_DOWN)
    SectionText pipelineId = new SectionText("*Pipeline Id*: ${this.pipelineId}", '', Types.MARK_DOWN)
    SectionText pipelineUrl = new SectionText(
      "*Pipeline*: <${this.pipelineUrl}|View pipeline on Jenkins>",
      '',
      Types.MARK_DOWN)
    SectionText triggeredBy = new SectionText("*Triggered By*: ${this.triggeredBy}", '', Types.MARK_DOWN)

    SectionText congratulation = new SectionText('*Greate job team!*', 'tada', Types.MARK_DOWN)

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
