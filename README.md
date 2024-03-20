# file-counter README

## Overview
`file-counter` is a Java application designed for counting files and pages within a specified directory. It utilizes a RESTful API to facilitate counting operations. By sending a GET request to `http://localhost:8080/countDocuments?directoryPath=YOUR_PATH`, where `YOUR_PATH` represents the target directory, the application returns the count of files and pages in the supported formats.

## Features
- Count files and pages in specified directory
- Support for `.pdf` and `.docx` file formats
- Utilizes a factory method for extensibility

## Technologies Used
- Java 17
- Spring Boot
- Intellij Idea
- JUnit
- Maven

## Usage
1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Build and run the application.
4. Send a GET request to `http://localhost:8080/countDocuments?directoryPath=YOUR_PATH`, replacing `YOUR_PATH` with the desired directory path.
5. Receive a response containing the count of files and pages in the specified directory.
