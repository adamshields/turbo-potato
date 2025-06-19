#!/bin/bash

echo "Installing recommended VS Code extensions for this interview..."

# Java + Spring Boot
code --install-extension vscjava.vscode-java-pack
code --install-extension pivotal.vscode-spring-boot

# Docker (optional)
code --install-extension ms-azuretools.vscode-docker

# Live Share (in case they don’t already have it)
code --install-extension ms-vsliveshare.vsliveshare

echo "Extensions installed. Please reload your VS Code window if prompted."
