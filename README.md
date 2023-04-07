# Western GIS - Description

Western GIS is an application used to those who attend Western University to better navigate around campus buildings. They will be able to identify the washrooms, labs, classrooms, etc - called Point of Interests. Users will be able to favorite their own points of interest, favorite them and modify them. Administrators are able to edit the built-in points of interest and change its metadata.

# Libraries and Software

Java Libraries: (Java 18)

Java.x.swing - Library used for GUI

Java.awt - Java abstract window toolkit, used for event listeners

Maven 3.9.1 - Build automation used for java projects

Org.json Version: 2023 02/27 - Used to parse JSON files for the project

JUnit 5.9.2 - Used for requirements testing of the files

# Compiling Software and Installation from source code

Users will need to have Java 19 installed and clone the application locally. Maven (version specified above) should be installed which will be used to execute the application. Libraries are included in the java files and do not require installation.

Use the Maven Local repository to run your Java SE Maven application.

To compile a maven project: you shoud be in the "demo" directory of the maven project in a terminal, which contains the pom.xml file, and execute:
mvn compile

To clean a maven package:
mvn clean package

To execute the jar file:
java -jar target/demo-1.0-SNAPSHOT.jar

Alternatively, you can add extensions on your code editor to run the application. For example: Code Runner and Java project manager allow Java code to be run in VSCode.

# Running the Application from already built code

Within the directory containing the jar file, run the following command: java -jar demo-1.0-SNAPSHOT.jar

# User Guide

When logging in, the user is able to select which building they would like to view on the map selection screen. After doing that, they can look at the map explore page and view points of interest that are on the map.

**Opening a map:** To view the floor plans of a building, you will be greeted with a screen to select a building, or you can click on the "Map Select" button. Click on the desired building, then click on the "Map Explore Screen to view the floor plans of the desired building. To change floors, scroll down on the left panel and click on the desired floor. 

**Switching maps** Click on the "Map Select" button to return to the building selection page. From here, you can click on a new building. Then, click on the "Map Explore Screen" button to see your new map selection. 

**Looking for POIs:** Once you have a floor plan open, you can discover POIs in multiple ways. On the left panel, you can scroll through all of the POIs available on the map. By default, you can also see all of the POIs on the map graphically. If you want to filter for a specific category of POI, you can select the desired filters on the left, which will then only show the desired types of POIs on the map. This also represent she different layers of POIs that can be seen. 

**Searching for POIs:** On the Map Explore Screen, there is a search bar where you can search for specific POIs. After typing in the POI you are looking for, click on the enter button to see a list of POIs that match your search request. You can click on these POIs to jump to them and see a description. 

**Favourite POI:** To favourite a POI, click on a POI on the map. On the new window, there will be an option to toggle the POI as a favourite POI. Once you check it off, it will appear in the left panel of the original window. You can click on these POIs from any location and it will bring you back to the correct map. 

**Creating a POI:** To create a POI, scroll down to the bottom of the left panel and click on the "Add POI" button. From here, you can click anywhere on the map to select a location for your new POI. Enter all requested information into the window and click on "Submit". The POI will appear on the screen, as well as show in a special list on the left panel called "User Points of Interest". 

**Editing/Deleting POIs:** On the map explore screen, go to the list of user POIs on the left and click on any user POI. This will bring up a window with the POI information, which will show an additional option of editing/deleting the POI. To move the POI, click on the "Move" button, then click anywhere on the screen to select the new location. To edit the information, click on the "Edit" button and make the necessary changes to the information before clicking on "Save". To delete the POI, click on the "Delete" button. 

**Viewing weather:** The temperature and weather conditions will automatically appear in the top right corner once the application is opened. 

**Admin features:** Admins have the ability to add in, edit, and remove any built-in POIs. To do so, click on the "Admin Login" button at the top, type in the password, and click on "Enter". Then, you can return to any map and create a new POI using the "Creating a POI" instructions, as well as edit/delete POIs using the "Editing/Deleting POIs" instructions. 

# Password

Password for admin edit mode: adminPassword

# Editor Mode

Users are able to edit their own POIs by clicking on their POIs and change it accordingly.

For admins: Editor mode can be accessed with the Admin Login panel. It allows the user to edit and change metadata of built in POIs, which will be parsed into a JSON so that it is saved even when the application is closed.
