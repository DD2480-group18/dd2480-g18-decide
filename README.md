# Launch Interceptor Program 
Following project is a part of a hypothetical anti-ballistic missile system. Given a set of coordinates and parameters we have to decide whether or not to fire off an interceptor. Calculations are built from fifteen conditions and two matrix calculations with two vectors. If the all of the values in the final vector is true we make the decision to fire off an interceptor. 

# Motivation 
This project was created with the purpose of learning how to collaborate effectively when developing software. This includes issue tracking, task management, pull requests, code reviews and version control. 

# Tech Stack 
Main programming language of this project is **Java** and the following technologies are used in this project, 
* Maven 
* JUnit v.5.4 

# Installation
Following section describes how to set up the development environment. 

## Setting up Maven
The easiest way to compile, test, and run the code in `src/` is to use Maven. Before using it, it must be set up once per computer.
1. Install Maven locally as described by [the official documentation](https://maven.apache.org/install.html).
2. Make sure to add the `bin` directory of Maven to your `PATH` environment variable (as described in the guide).
3. Check the environment variable value of `JAVA_HOME` and set it if necessary. 
4. At the root of the repository, open a command line prompt/terminal and run `mvn install`. This will download the necessary files to run unit tests etc.

## Compiling, Testing, and Running
Maven works with something called "lifecycle phases", which practically just works as commands that can be run in sequence. To run these commands, open a command line prompt/terminal at the root of the repository and run `mvn <lifecycle phase>`. The phases that are useful for this code is `clean`, `compile`, and `test`. `clean` will delete previously compiled and cached files. `compile` will compile the code located in `src/`. `test` will run the JUnit tests located in `src/test/`. These can be run in sequence, which is what [Travis CI](https://docs.travis-ci.com/) will run whenever a new commit is pushed to the GitHub repository, as shown below.

`mvn clean compile test`

# Credits 
We would like to thank the teachers and TAs of the course DD2480 - Software Engineering Fundamentals for answering questions and clarifying any ambiguities regarding the assignment. 


# List of Contributions

## David Yu
#### Features
- [x] LIC1
- [x] LIC3
- [x] LIC8
- [x] Wrote tests for each LIC
#### Refactoring
- [x] Extracted code into reusable class.
- [x] Fixed bugs
#### Documentation
- [x] Added additional information to README
#### Reviews
- Peer review on a few PRs

## Kalle Pettersson
#### Features
- [x] FUV 2.3
- [x] LIC2
- [x] LIC5
- [x] LIC7
- [x] LIC9
- [x] LIC11
- [x] LIC14
- [x] .gitignore
#### Refactoring
- [x] main connect everything (done with everyone)
#### Reviews
- Pull Request #57 (with Martin)
- Pull Request #41

## Lukas Gutenberg
#### Features
- [x] Junit setup for the project
- [x] LIC 4
- [x] LIC 10
#### Refactoring
- [x] LIC3
- [x] several test files
#### Reviews
- [x] Most pull requests, ~15.

## Martin Falke
#### Features
- [x] TravisCI and Maven setup for project
- [x] LIC6
#### Refactoring
- [x] LIC4 copy to main structure
- [x] LIC9 copy to main structure, debug prints removed
- [x] FUV copy to main structure, compilation errors fixed
- [x] LIC12 debug prints removed
- [x] ~~LIC3 refactor and copy to main structure~~ *(Duplicate work)*
#### Documentation
- [x] Instructions in README.md on how to use Maven/TravisCI
- [x] TODO checklist as an overview of integration
- [x] Set up basic format for and paste together this list of contributions
#### Reviews
- Pull Request #57 (with Kalle)
- Pull Request #66
#### Group coordinator
- [x] Set up of discord with channels/links/etc.
- [x] Tracking tasks and delegating towards end

## Oscar Lindgren
#### Features
- [x] LIC0
- [x] LIC3
- [x] LIC12
- [x] PUM
#### Refactoring
- [x] LIC1 copy to main structure
- [x] LIC8 copy to main structure, debug prints removed
- [x] LIC7 copy to main structure,
- [x] LIC13 copy to main structure, compilation errors fixed
#### Reviews
- [x] Pull Request #18
- [x] Pull Request #19
- [x] Pull Request #31 (reviewed and did some implementation)
- [x] Pull Request #33
#### Setup
- [x] Set up Zoom-room