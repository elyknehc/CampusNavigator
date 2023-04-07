# Western GIS - Description

Western GIS is an application used to those who attend Western University to better navigate around campus buildings. They will be able to identify the washrooms, labs, classrooms, etc - called Point of Interests. Users will be able to favorite their own points of interest, favorite them and modify them. Administrators are able to edit the built-in points of interest and change its metadata.

# Libraries and Software

Java Libraries: (Java 18)

Java.x.swing - Library used for GUI

Java.awt - Java abstract window toolkit, used for event listeners

Maven 3.9.1 - Build automation used for java projects

Org.json Version: 2023 02/27 - Used to parse JSON files for the project

JUnit 5.9.2 - Used for requirements testing of the files

# Compiling Software and Installation

Users will need to have Java 19 installed and clone the application locally. Maven (version specified above) should be installed which will be used to execute the application. Libraries are included in the java files and do not require installation.

Use the Maven Local repository to run your Java SE Maven application.

To compile a maven project: you shoud be in the "demo" directory of the maven project in a terminal, which contains the pom.xml file, and execute:
mvn compile

# Running the Application

To clean a maven package:
mvn clean package

To execute the jar file:
java -jar target/demo-1.0-SNAPSHOT.jar

Alternatively, you can add extensions on your code editor to run the application. For example: Code Runner and Java project manager allow Java code to be run in VSCode.

# User Guide

When logging in, the user is able to select which building they would like to view on the map selection screen. After doing that, they can look at the map explore page and view points of interest that are on the map.

**Points of Interest:** The user can make a new point of interest by clicking on the map. It will prompt them to enter new information regarding the point of information and then will be saved. They can also create the point of information as a favorite point of information. The user can edit or delete the point of information later if desired. User created point of information is persistent data, meaning that it will be saved even when the application is closed - allowing the user to access their created POIs when the application is reopened.

**Clicking on POIs** Click on the POIs that have been created to edit them, display information or delete them.

**Built-in-POIs:** There will be built in point of informations that have been loaded in with a JSON file.

**Navigation:** The user is able to view all different floors of the building by selecting the floor they would like to browse. The POIs will dynamically render and change depend on what floor and building that they are on.

**Filtering:** The user can filter which category of point of information they would like to see from the map explore page panel. They can select or deselect the category and the associated types of point of information will appear on the map.

**Admin Edit:** An admin can login with the password and be able to edit the built-in point of informations, being able to edit or create new ones - which will be parsed to the JSON file.

# Password

Password for admin edit mode: adminPassword

# Editor Mode

Users are able to edit their own POIs by clicking on their POIs and change it accordingly.

For admins: Editor mode can be accessed with the Admin Login panel. It allows the user to edit and change metadata of built in POIs, which will be parsed into a JSON so that it is saved even when the application is closed.
