# Greetings!
This exercise is designed to test your ability to compile Java programs, modifying Java source code
as necessary to make that happen.

Your task is simple: Make the code compile, and make all the unit tests pass. You may not change the
tests that already exist in the files in the "src/test" subdirectories; you will also be asked to add
a few tests, as well.

## To do that...
... you must make the code compile. To do that, we will use a build system that is popular in the Java
world, called "Gradle". It will likely require you to install some stuff on your machine.

### To install Gradle...
... visit [the Gradle website][1]. The Downloads page has some details on how to install on to your
machine of choice.

Note that if you have a Mac, this is much easier; install [Homebrew][2], and once that's done, issue
"brew install gradle" at the command-line. You will need to have Java installed on your Mac already,
which may require a download from Oracle to do so.

The reason we are using Gradle is because this is the build system used internally inside Android Studio
(at least for now). Understanding a little of how it works will be helpful when working with your own
Android projects later.

### To build the code once Gradle is installed...
... you will need to open a Terminal window to the directory in which you cloned this code (if you
haven't already). Then, issue "gradle build" to compile the code, or "gradle test" to build the code
and run the tests.

If you prefer GUIs, run "gradle --gui" and a nice little window will pop up.

### Check the test results
When Gradle is done with the build, if you asked it to run the tests, it will do so and dump the results
in a nicely-formatted HTML file in "build/reports/tests". Open the "index.html" file in that directory
with your browser of choice (or, if you're on a Mac, from the command-line do 
"open build/reports/tests/index.html"; on Windows, "start build/reports/tests/index.html" and either will
open the HTML file in the currently-selected default browser).

It will show you the summary of the test run, with breakdowns either by "Packages" or "Classes".

## Your tasks
In no particular order, you will need to:

* Create "getters" and "setters" on Person

* Ensure that Person.setAge() throws an IllegalArgumentException when passed a value less than zero

* Ensure that Person.setName() throws an IllegalArgumentException when passed a null String

* Write a Person.count() that returns the total number of Person instances created

* Ensure that Person.equals() returns true if two Person instances have the same name and age
  (salary doesn't factor into equality comparison). Make sure no exceptions are thrown from this
  method--anything "weird" should just return false.

* Create an AgeComparator class that compares two Persons and arranges them by age (age 15 is less 
  than age 25). This Comparator MUST BE a nested class inside of Person; Person's fields must
  remain private.

* Make Person be Comparable, such that when I compare two Persons, they arrange themselves by salary
  in reverse order (salary 150000 is less than salary 10000). (Rich people to the front!)

* Create a static method "getNewardFamily" that returns an ArrayList<Person> consisting of four
  Person objects: Ted, age 41, salary 250000; Charlotte, age 43, salary 150000; Michael, age 22,
  salary 10000; and Matthew, age 15, salary 0.

* Lastly, you will need to implement a final test, marked in comments in the TestPerson class, which
  will register a "PropertyChangeListener" instance. This PropertyChangeListener will need to call
  the three "assertEquals" calls (as described in the comments) in order to test that the property
  did change. You shouldn't change anything above or below the comment lines beyond that.

... most of which will/should be obvious from looking at the tests. The test classes are in
src/test/java/com/tedneward/example, and the source files that you will need to modify will
be in src/main/java/com/tedneward/example.

## Note: No Android Studio for this
This isn't just because I want you to get a little command-line exercise in; this is also because the
Android Studio does not support plain ol' command-line Java application development.

If you really can't live without an IDE, JetBrains' IDEA would work, but you really need to be comfortable
with writing code without the bells and whistles of an IDE, because the IDE won't always be there.
(After this one, I promise, we're all IDE, all the way.)

## Grading
This is pretty simple stuff; accordingly, this is kind of a pass/fail scenario. Get the tests to pass,
full marks; don't get all the tests to pass, nada.

## Questions
Fire away, to either me or the TA.


[1]: http://www.gradle.org
[2]: http://brew.sh/
