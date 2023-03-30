#!/usr/bin/env groovy

def call(Map data = [:]) {
  
  def header = buildHeader(data.message)

  def msg = [header]

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