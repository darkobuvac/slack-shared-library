#!/usr/bin/env groovy
import org.utils.*

def call(Map data = [:]) {

  def utils = new Utils()
  
  def header = utils.buildHeader(data.message)

  def divider = utils.buildDivider()

  def project = utils.buildSection("Project", data.name, "rocket")
  def gitBranch = utils.buildSection("Git Branch", data.branch, "git")

  def msg = [header,divider,project, gitBranch]

  echo "${msg}"
  
  return msg
}

