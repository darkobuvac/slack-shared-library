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

  echo "${msg}"
  
  return msg
}