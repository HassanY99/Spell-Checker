# Spell-Checker

 ## Description

  This program is written to correct wrong spelled words and provide the correct word from the dictionary. Given an input, the program should check to see if it exists in a dictionary of correctly spelled words.
  
  This Java code checks for spelling mistakes in a word, sentence or in a file and can provide the best possible correct word that user might be trying to write.
  
  As of now, this program uses 4 important algorithms:
  1) charAppendPrepend():
    This algorithm adds a char if user misses a letter either in the front or back of the word.
  2) charMissingInBetween():
    This algorithm adds a char if user misses a letter in between the word excluding the first and last letter of the word.
  3) removesExtraLetter():
    This algorithm removes a char if users accidentally adds an extra letter at the front, end or in between the word.
  4) swapAdjChar():
    This algorithm swaps char if user accidentally swaps letter in the word e.g. haerd -> heard.
  

  ## Table of Contents
  - [User Story](#user-story)
  - [Features](#features)
  - [Installation](#installation)
  - [App Walkthrough](#app-walkthrough)
  - [Contributing](#contributing)
  - [Questions](#questions)

  ## User Story

* As a user, I want to be able to check a single word spellings. I should also be able to check for spellings in a sentence. Furthermore, would also like my spellings to be checked in a file.

## Features

  * Dictionary class in this program is an implementation of separately-chaining hash list.

  * Program uses algorithm that checks spellings in the dictionary for a single word.

  * Program uses algorithm that corrects spellings in a sentence.

  * Program uses algorithm that checks for incorrect words in the file from the dictionary of correctly spelled words.

  ## Installation

  Follow these simple instructions to set up the program in your local.

1. Clone the repository:

  ```bash
  git clone https://github.com/HassanY99/Spell-Checker.git
  Open in your IDE, In my case I use IntelliJ.
  ```

2. Once you have the program open in IntelliJ, you will find three classes.

  ```bash
  1) ChecksWord()
  Where program checks for a string input of a single word.
  2) ChecksSentence()
  Where program checks for a string input of a sentence.
  3) ChecksWordsInFile()
  Where program checks words in a file which is set for now as 'text.txt' but you can use your own text file as well.
  ```

That's it, you are good to go! Now you can successfully run this program! 👾

  
  ## App Walkthrough

  - [Full Video](https://drive.google.com/file/d/1-f5PJy7ANkYomO5w6K9MJtfaSJo9cEzZ/view)
  

  ## Contributing

  Please reach out to me at my email for any question, suggestion or collaboration.

  ## Questions

  You can check me on [HassanY99](https://github.com/HassanY99) and can shoot me an email at hassanyousuf1999@gmail.com.
