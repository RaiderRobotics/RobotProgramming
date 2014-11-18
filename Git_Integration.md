This is an attempt to explain how to get Git to work with Netbeans

1. Create the repository that everyone will use on GitHub (I'm calling it Robot2014), and using the path /src/org/raiderrobotics
2. Fix the .gitignore by adding nbproject/private/  and build/
3. On laptop, install GitExtensions
4. Put in your name and email or things will screw up. Use the same one that you're using on GitHub
5. Clone the repository into myDocuments/NetbeansProjects/Robot2014
6. In Netbeans, create a new FRC Iterative Robot project called Robot2014, but make the project location something elsewhere
  Make the class name zzz.java 
  Delete this class as soon as the project has been made.
7. Copy all of the files EXCEPT /src from the location of this project to the Robot2014 folder that Git is using.
8. In Netbeans click "Open Project" and go to this project.
