package org.components

import groovy.transform.CompileDynamic

import org.commons.Types

/**
 * Representd singel commit displayed in slack message
 */
@CompileDynamic
class Commit {

  String commitId
  String commitUrl
  String message
  String authorName
  String authorUsername
  String time

  private List<Map> slackElement = []

  Commit(Map data = [:]) {
    this.commitId = data.commitId
    this.commitUrl = data.commitUrl
    this.message = data.message
    this.authorName = data.authorName
    this.authorUsername = data.authorUsername
    this.time = data.time
  }

  void populateSlackElement() {
    SectionText commit = new SectionText("*Commit Id*: <${this.commitUrl}|${this.commitId}>", '', Types.MARK_DOWN)
    SectionText message = new SectionText("*Message*: ${this.message}", '', Types.MARK_DOWN)
    SectionField section = new SectionField([
      [
        value: "*Author*: ${this.authorName} (${this.authorUsername})",
        icon: ''
      ],
      [
        value: "*Time*: ${this.time}",
        icon: ''
      ]
    ])

    List<Map> result = [
      commit.toSlackElement(),
      message.toSlackElement(),
      section.toSlackElement()
    ]

    this.slackElement = result
  }

  List<Map> toSlackElement() {
    populateSlackElement()

    return this.slackElement
  }

}
