#!/usr/bin/env groovy

def call(Map data = [:]) {
  
  def header = [
    "type": "header",
    "text": [
      "type": "plain_text",
      "text": ":construction: ${data.message}",
      "emoji": true
    ]
  ]

  def msg = [header]
  
  sh "echo ${msg}"

  return msg
}