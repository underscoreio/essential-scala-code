# Essential Scala Code

This repository contains exercises and solutions for
[Underscore's Essential Scala][course] training course.

If you want to discuss the content or exercises with the authors,
join us in our chat room on [Gitter][gitter].

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)][gitter]

## Using the Source Code

This repository contains two branches: one for `exercises` and one for `solutions`.
The directory structure is the same in each branch.

You will need to have Git and Java and an internet connection to run the exercises.
All other dependendencies are either included with the repo
or downloaded on demand during compilation.

### Notes on Editors and IDEs

If you don't have a particular preference for a Scala editor or IDE,
we strongly recommend you do the exercises for this couse using
the [Atom][atom] editor and a Linux or OS X terminal.
See the instructions below to get started.

If you want to use [Scala IDE][scala-ide] for Eclipse,
we recommend using [sbteclipse][sbteclipse].
Follow the instructions on the `sbteclipse` web page to install it as a global SBT plugin.

If you want to use IntelliJ IDEA,
follow the instructions for [Importing an SBT Project][intellij-setup]
in the IntelliJ online documentation.

### Getting Started on Linux or OS X

To get started:

1. Clone this repository to a directory on your hard drive,
   e.g. `~/essential-scala-code`:

   ~~~
   bash$ git clone https://github.com/underscoreio/essential-scala-code.git
   ~~~

2. Change to the root directory in the repository:

   ~~~
   bash$ cd essential-scala-code
   ~~~

3. Run the `sbt.sh` script.
   You may have to wait while SBT downloads various dependencies:

   ~~~
   bash$ ./sbt.sh
   # Lots of output here...
   # The first run will take a while...

   >
   ~~~

4. Type `runMain intro.HelloWorld` at the SBT prompt.
   You may have to wait while SBT downloads various dependencies.

5. If you see the message `"Hello world!"`, you're ready to go!

*If you have any problems getting started, get in touch on [Gitter][gitter].*

### Getting Started on Windows

You will need to have installed Git and Java (we recommend Oracle's Java 7 SDK).
Complete the following steps outlined in Chapter 1 in the section entitled
"Setting up SBT for This Book":

1. Clone this repository to a directory on your hard drive,
   e.g. `C:\essential-scala-code`:

   ~~~
   C:\> git clone https://github.com/underscoreio/essential-scala-code.git ↩
                    C:\essential-scala-code
   ~~~

2. Change to the root directory in the repository:

   ~~~
   C:\> cd\essential-scala-code
   ~~~

3. Run the `sbt.bat` script.
   You may have to wait while SBT downloads various dependencies:

   ~~~
   C:\essential-scala-code> sbt
   # Lots of output here...
   # The first run will take a while...

   >
   ~~~

4. Type `runMain intro.HelloWorld` at the SBT prompt.
   You may have to wait while SBT downloads various dependencies.

5. If you see the message `"Hello world!"`, you're ready to go!

*If you have any problems getting started, get in touch on [Gitter][gitter].*


[course]: http://underscore.io/training/courses/essential-scala
[atom]: https://atom.io
[scala-ide]: http://scala-ide.org
[sbteclipse]: https://github.com/typesafehub/sbteclipse
[intellij-idea]: https://www.jetbrains.com/idea
[intellij-setup]: https://www.jetbrains.com/help/idea/2016.1/getting-started-with-sbt.html#import_project
[gitter]: https://gitter.im/underscoreio/scala?utm_source=essential-scala-readme&utm_medium=badge&utm_campaign=essential-scala
