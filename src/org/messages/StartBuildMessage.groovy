package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText
import org.components.SectionField
import org.components.BaseElement

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class StartBuildMessage {

  List<Map> buildData = []
  List<Map> commitsData = []

  Header header
  SectionText infoMsg
  Divider divider

  List<BaseElement> buildElemenets

  Header commitsHeader
  List<Commit> commits = []

  StartBuildMessage(List<Map> commitsData, List<Map> buildData) {
    this.buildData = buildData
    this.commitsData = commitsData
  }

  List<Object> toSlackBlock() {
    List<Object> result = [
     this.header.toSlackElement(),
     this.infoMsg.toSlackElement(),
     this.divider.toSlackElement(),
     this.firstSection.toSlackElement()
    ]

    return result
  }

}
