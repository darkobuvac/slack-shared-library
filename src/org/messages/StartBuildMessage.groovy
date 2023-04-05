package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText
import org.components.BuildInfo
import org.components.Commit

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

  BuildInfo buildInfo

  Header commitsHeader
  List<Map> commits = []

  StartBuildMessage(List<Map> commitsData = [], Map buildData) {
    this.buildData = buildData
    this.commitsData = commitsData
  }

  List<Map> toSlackBlock() {
    this.buildSlackElements()
    this.buildCommitsElement()

    List<Map> result = [
     this.header.toSlackElement(),
     this.infoMsg.toSlackElement(),
     this.divider.toSlackElement(),
     *this.buildInfo.toSlackElement(),
     this.divider.toSlackElement(),
     this.commitsHeader.toSlackElement(),
     *this.commits
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

    this.commitsHeader = new Header('Commits', 'hash')
  }

  /* groovylint-disable-next-line BuilderMethodWithSideEffects, FactoryMethodName */
  private void buildCommitsElement() {
    for (item in this.commitsData) {
      List<Map> commit = new Commit(item).toSlackElement()

      this.commits = [
        *this.commits,
        *commit
      ]
      this.commits.add(this.divider.toSlackElement())
    }
  }

}
