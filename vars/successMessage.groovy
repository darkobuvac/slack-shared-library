#!/usr/bin/env groovy
import org.utils.*

def call(Map data = [:]){
  def utils = new Utils()

  def header = utils.buildHeader(data.message, "white_check_mark")

  def divider = utils.buildDivider();

  def project = utils.buildSection("Project", data.name, "rocket")
  def gitBranch = utils.buildSection("Git Branch", data.branch, "git")
  def time = utils.buildSection("End at", timestamp, "calendar")
  def dockerImage = utils.buildSection("Docker image", data.imageName, "docker")
  def pipelineId = utils.buildSection("Pipeline Id", data.pipelineId, "id")
  def triggeredBy = utils.buildSection("Triggered By", data.jenkinsUser, "bust_in_silhouette")
  def pipelineUrl = utils.buildSection("Pipeline URL", "<${data.pipelineUrl}|View pipeline on Jenkins>", "link")

  def successMessage = utils.buildSection("Great job team!", "", "tada")

  def msg = [
    header,
    divider,
    time,
    project, 
    gitBranch,
    dockerImage,
    pipelineId,
    triggeredBy,
    pipelineUrl,
    successMessage,
    divider
  ]

  return msg
}