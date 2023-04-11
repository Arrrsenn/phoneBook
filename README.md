# phoneBook
This code is a console application for working with the contact book (Phone Book).

The user can choose one of several commands:

0 - Exit;
1 - Add a contact;
2 - Pin output;
3 - Search;
4 - Yes;
5 - No.

When selecting the "Add Contact" command, the user must enter the name and phone number of the contact, which are checked using a regular expression. If the data is entered correctly, a new contact object is created and stored in the PhoneBook class object.

When you select the "Output Contacts" command, all contacts saved in the PhoneBook object are displayed.

When selecting the "Search" command, the user must enter the name or phone number of the contact to be found. After that, a search is performed using a regular expression, and if a contact is found, information about it is displayed. If the contact is not found, the corresponding message is displayed.

The implementation involves using PhoneBook, Pattern, and Matcher classes to store contacts and work with regular expressions.
