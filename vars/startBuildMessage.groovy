#!/usr/bin/env groovy
import org.utils.*

def call(Map data = [:]) {

  def timestamp = new Date().format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC"))

  def utils = new Utils()
  
  def header = utils.buildHeader(data.message)

  def divider = utils.buildDivider()

  def project = utils.buildSection("Project", data.name, "rocket")
  def gitBranch = utils.buildSection("Git Branch", data.branch, "git")
  def time = utils.buildSection("Started at", timestamp, "calendar")
  def pipelineId = utils.buildSection("PipelinaId", data.pipelineId, "id")
  def triggeredBy = utils.buildSection("Triggered By", data.jenkinsUser, "bust_in_silhouette")
  def pipelineUrl = utils.buildSection("Pipeline URL", "<${data.pipelineUrl}|View pipeline on Jenkins>", "link")

  def commitsTitle = utils.buildSectionTitle("Commits")

  def commits = utils.buildCommits()

  def msg = [
    header,
    divider,
    project, 
    gitBranch,
    time,
    pipelineId,
    triggeredBy,
    pipelineUrl,
    divider,
    commitsTitle,
    commits
  ]

  echo "${msg}"
  
  return msg
}

