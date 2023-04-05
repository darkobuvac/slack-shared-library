package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText

/**
 * Message sent on failure
 */
@CompileDynamic
class FailureMessage {

  String projectName
  String gitBranch
  String pipelineId
  String pipelineUrl
  String triggeredBy

  private List<Map> slackElements = []

  FailureMessage(Map data = [:]) {
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

    Header header = new Header("Build #${this.pipelineId} failed", 'alert')
    SectionText subtitle = new SectionText(
      "${this.projectName} build & deploy pipeline has failed",
      '',
      Types.PLAIN_TEXT
    )
    SectionText project = new SectionText("*Project*: ${this.projectName}", 'rocket', Types.MARK_DOWN)
    SectionText dateTime = new SectionText("*Failed at*: ${timestamp}", 'date', Types.MARK_DOWN)
    SectionText git = new SectionText("*Git branch*: ${this.gitBranch}", 'git', Types.MARK_DOWN)
    SectionText pipelineId = new SectionText("*Build Id*: ${this.pipelineId}", 'id', Types.MARK_DOWN)
    SectionText pipelineUrl = new SectionText(
      "*Pipeline*: <${this.pipelineUrl}|View pipeline on Jenkins>",
      'link',
      Types.MARK_DOWN)
    SectionText triggeredBy = new SectionText(
      "*Triggered By*: ${this.triggeredBy}",
      'bust_in_silhouette',
      Types.MARK_DOWN
    )

    SectionText sadMessage = new SectionText(
      "*Uh, looks like Jenkins pipeline hit a snag and couldn't make it to the finish line*",
      'cry',
      Types.MARK_DOWN
    )

    List<Map> result = [
      header.toSlackElement(),
      subtitle.toSlackElement(),
      divider.toSlackElement(),
      project.toSlackElement(),
      dateTime.toSlackElement(),
      git.toSlackElement(),
      pipelineId.toSlackElement(),
      pipelineUrl.toSlackElement(),
      triggeredBy.toSlackElement(),
      divider.toSlackElement(),
      sadMessage.toSlackElement(),
    ]

    this.slackElements = result
  }

}
