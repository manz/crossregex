
crossregex
==========

Solves the ippon's problem

Build
=====

```
$ mvn clean compile assembly:single
```

should build a fully functional jar named CrossRegex.jar in target directory.

```
$ mvn -q exec:java -Dexec.mainClass="main.Main" -Dexec.classpathScope=runtime
```

should launch the solver from the command line
