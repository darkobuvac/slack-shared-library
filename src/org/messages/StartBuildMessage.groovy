package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText
import org.components.SectionField
import org.components.BaseElement

/**
 * Message sent when Jenkin pipelien was triggered
 */
@CompileDynamic
class StartBuildMessage {

  Map buildData = [:]
  List<Map> commitsData = []

  Header header
  SectionText infoMsg
  Divider divider

  List<Map> buildElemenets

  Header commitsHeader
  List<Map> commits = []

  StartBuildMessage(List<Map> commitsData, Map buildData) {
    this.buildData = buildData
    this.commitsData = commitsData
  }

  /* groovylint-disable-next-line BuilderMethodWithSideEffects, FactoryMethodName */
  void buildSlackElements() {
    this.header = new Header('Pipeline started', 'construction')
    String message = "${buildData.projectName} build & deploy pipeline has been launched"
    this.infoMsg = new SectionText(message, '', Types.PLAIN_TEXT)
    this.divider = new Divider()
  }

  List<Map> toSlackBlock() {
    List<Map> result = [
     this.header.toSlackElement(),
     this.infoMsg.toSlackElement(),
     this.divider.toSlackElement(),
    ]

    return result
  }

}
