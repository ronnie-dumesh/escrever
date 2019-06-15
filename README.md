# escrever
Escrever, (Portuguese for "To write"), is a flash card program for language learning resembling Anki.

The purpose of this project is to increase my own comfortability with Java and developing larger programs independently. The inspiration behind this personal endeavor was that Anki, a popular desktop language learning app, was quite user unfriendly and difficult to install and use. Like Anki, this program operates based off the principle of spaced repetition. 

To start, select a file through the “Import CSV” button on the top right when running the program.

Additional optional material, including a jar file and two CSV files have been provided [here](https://drive.google.com/open?id=1jlDCsZzStv6cWJSFRfvu8a2eI28Lm4cv). SampleCSV.csv contains six rows that act as test cases, and 1000words.csv provides a more extensive and practical example. sampleCSVbefore.png illustrates how each of those columns are different test cases.

A file must be formatted with a word in the first column, its accompanying definition in the second column, an (optional) hint in the third column, and an (optional) time for this word to be reviewed (expressed in milliseconds) in the fourth column. In essence, one can make their own CSV for Escrever with only the word and definition in the first two columns. 

Known bugs and limitations:
The first word of every imported CSV file contains three extra characters "ï<<¿" this should not affect the learning experience.
Special characters are not currently supported.
To save a file, a file must not be open anywhere else. 
