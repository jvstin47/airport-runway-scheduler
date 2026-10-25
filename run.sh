#!/bin/bash
# Convenient runner script for Airport Runway Scheduling System

JAVA_BIN="/opt/homebrew/opt/openjdk@21/bin"
if [ -f "$JAVA_BIN/java" ]; then
    JAVA_CMD="$JAVA_BIN/java"
    JAVAC_CMD="$JAVA_BIN/javac"
else
    JAVA_CMD="java"
    JAVAC_CMD="javac"
fi

cd "$(dirname "$0")"
"$JAVAC_CMD" *.java
if [ $? -eq 0 ]; then
    "$JAVA_CMD" RunwayUI
fi
