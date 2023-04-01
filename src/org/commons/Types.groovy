package org.commons

import groovy.transform.CompileStatic

/**
 * This class is intended for storing static values related to Slack block types.
 */
@CompileStatic
class Types {

    static final String HEADER = 'header'
    static final String PLAIN_TEXT = 'plain_text'
    static final String SECTION = 'section'
    static final String DIVIDER = 'divider'
    static final String MARK_DOWN = 'mrkdwn'

}
