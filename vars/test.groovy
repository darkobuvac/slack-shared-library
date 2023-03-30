def slackBlockMessage = [  "blocks": [    [      "type": "header",      "text": [        "type": "plain_text",        "text": ":construction: Jenkins Pipeline Started",        "emoji": true      ]
    ],
    [      "type": "divider"    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":rocket: *Project:* My Project Name"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":git: *Git Branch:* main"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":calendar: *Started At:* 2023-03-30 12:30 PM"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":id: *Pipeline ID:* #12345"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":bust_in_silhouette: *Triggered By:* John Doe"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":link: *Pipeline URL:* <https://jenkins.example.com/job/my-project-pipeline/|View Pipeline on Jenkins>"      ]
    ],
    [      "type": "divider"    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": "*Commits:*"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":hash: <https://github.com/myusername/my-project/commit/sha256abcdef|sha256abcdef> by John Doe - Fix typo in README.md"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":hash: <https://github.com/myusername/my-project/commit/sha256ghijkl|sha256ghijkl> by Jane Smith - Add new feature to API"      ]
    ],
    [      "type": "divider"    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": "*Pipeline Stages:*"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":arrow_forward: *Build:* In Progress"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":stopwatch: *Test:* Waiting"      ]
    ],
    [      "type": "section",      "text": [        "type": "mrkdwn",        "text": ":white_check_mark: *Deploy:* Complete"      ]
    ]
  ]
]
