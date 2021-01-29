

## Setting up Maven
The easiest way to compile, test, and run the code in `src/` is to use Maven. Before using it, it must be set up once per computer.
1. Install Maven locally as described by [the official documentation](https://maven.apache.org/install.html).
2. Make sure to add the `bin` directory of Maven to your `PATH` environment variable (as described in the guide).
3. Check the environment variable value of `JAVA_HOME` and set it if necessary. 
4. At the root of the repository, open a command line prompt/terminal and run `mvn install`. This will download the necessary files to run unit tests etc.

## Compiling, Testing, and Running
Maven works with something called "lifecycle phases", which practically just works as commands that can be run in sequence. To run these commands, open a command line prompt/terminal at the root of the repository and run `mvn <lifecycle phase>`. The phases that are useful for this code is `clean`, `compile`, and `test`. `clean` will delete previously compiled and cached files. `compile` will compile the code located in `src/`. `test` will run the JUnit tests located in `src/test/`. These can be run in sequence, which is what [Travis CI](https://docs.travis-ci.com/) will run whenever a new commit is pushed to the GitHub repository, as shown below.

`mvn clean compile test`