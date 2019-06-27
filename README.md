# logback-stackoverflow
Reproduce Logback StackOverflow error while logging recursive exceptions

### The Problem

Given a recursive exception, Logback fails throws an StackOverflow exception while attempting to log it.
The Logback ticket for this issue is https://jira.qos.ch/browse/LOGBACK-1027

Problem is, the exception cannot be identified given the logger fails to log it.

#### Workaround attempt 1: Limit Logging Recursion using a Layout Pattern (Doesn't work)

For example `%xThrowable{10}`, to limit the number of log lines to 10.
(including xEx, rEx, xThrowable, ex)

Further info about Logback Layouts is here: https://logback.qos.ch/manual/layouts.html

