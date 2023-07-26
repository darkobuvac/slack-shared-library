package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText
import org.components.BuildInfo

/**
 * Message sent when Jenkin pipelien was triggered
 */
@CompileDynamic
class StartBuildMessageWithoutCommits {

  Map buildData = [:]

  Header header
  SectionText infoMsg
  Divider divider

  BuildInfo buildInfo

  StartBuildMessageWithoutCommits(Map buildData) {
    this.buildData = buildData
  }

  List<Map> toSlackBlock() {
    this.buildSlackElements()

    List<Map> result = [
     this.header.toSlackElement(),
     this.infoMsg.toSlackElement(),
     this.divider.toSlackElement(),
     *this.buildInfo.toSlackElement(),
     this.divider.toSlackElement(),
    ]

    return result
  }

  /* groovylint-disable-next-line BuilderMethodWithSideEffects, FactoryMethodName */
  private void buildSlackElements() {
    this.header = new Header("Build #${buildData.pipelineId} started", 'construction')
    String message = "${buildData.projectName} build & deploy pipeline has been launched"
    this.infoMsg = new SectionText(
      message,
      '',
      Types.PLAIN_TEXT)

    this.divider = new Divider()

    this.buildInfo = new BuildInfo(
      [
        projectName: buildData.projectName,
        startedAt: buildData.startedAt,
        gitBranch: buildData.gitBranch,
        dockerImage: buildData.dockerImage,
        pipelineId: buildData.pipelineId,
        pipelineUrl: buildData.pipelineUrl,
        triggeredBy: buildData.triggeredBy
      ]
    )
  }

}
