# CS-3330

JavaType is a capable typing test featuring several test modes and statistic collection that was built during my second semester sophomore year during CS 3330, an object oriented class taught in Java.

It is a quick build loosely based off of monkeytype, an online typing website that does many of the same things but with richer features and a more robust user experience. https://monkeytype.com/

The goal of this design was to implement a variety of principles of object oriented programming, including things like abstraction, encapsulation, inheritance, and polymorphism, while learning some fundamental practices in the Java programming language. Given the scope of the project, I hoped to provide a functional typing test with a little bit of personality and a seamless user experience without too much worry for extraneous details.

The standard typing test uses the 200 most common english words, but tests are limitless as they can be configured using crazy words, stories, and even any custom set of test words you would like to create.

After taking a typing test, the program displays your test statistics:
<pre>
Time : elapsed time spent typing in seconds
Accuracy: percentage of correctly pressed keys
Raw(wpm): total amount of correct characters divided by 5, normalized to 60 seconds
WPM : raw value multiplied by accuracy value
</pre>
