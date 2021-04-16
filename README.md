Assignment: To replace the string from text file.
TABLE OF CONTENTS:
	1.TITLE
	2.LIBRARIES
	3.METHOD
	4.RESULT
`	5.PLATFORM
	

1.TITLE: A java program to replace words from text file.

2.LIBRARIES:
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

3.METHOD:

static long replaceWords(String filePath, String wordsToReplace[], String wordsToReplaceWith[]) {}

Method will take following parameters:
1.filePath : a file path that needs to be manipulated!
2.wordsToReplace: Array of a string containing words that need to be replaced.
3.wordsToReplaceWith: Array of a string containing consecutive words that need to placed for wordsToReplace.

Return Value: Number of words replaced in file!

4.Result: Will replace multiple words with given words then count them and return the value.

5.PLATFORM: JCreator
