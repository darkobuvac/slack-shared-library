#!/usr/bin/env groovy
import org.utils

def call(Map data = [:]) {

  def utils = new Utils()
  
  def header = buildHeader(data.message)
  def divider = buildDivider()
  def project = utils.buildSection("Project", data.name)

  def msg = [header,divider,project]

  echo "${msg}"
  
  return msg
}

def buildHeader(String msg){
  return [
    "type": "header",
    "text": [
      "type": "plain_text",
      "text": ":construction: ${msg}",
      "emoji": true
    ]
  ]
}

def buildDivider(){
  return [type: "divider"]
}