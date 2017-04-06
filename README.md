# Dependency-Download-in-Maven
Wired up an example to demonstrate maven for managing dependency download through wagon-maven plugin and profile management based on the Operating System type. 

## Usage
1. Download or clone this repository.
2. Navigate to the repo directory through terminal.
3. Do ```mvn compile``` and ensure successful compilation.
4. Do ```mvn package``` for a succesful build and packaging.
5. Provide the following command 
   ```
    mvn clean install
    ```
   This will download all the required dependencies as given in pom.xml. 
   <br/> To customise the URL and download directory.Modify the plugin as provided in the comment.<br/>
6. Edit the BASE URL, PATH and DOWNLOAD DIRECTORY in the plugin in pom.xml.
7. Profile managment based on Operating System and all required profiles are issued in pom.xml. 
 
```
<plugin>
   <groupId>org.codehaus.mojo</groupId>
   <artifactId>wagon-maven-plugin</artifactId>
   <version>1.0</version>
   <executions>
      <execution>
         <id>download-glassfish</id>
         <phase>pre-integration-test</phase>
         <goals>
            <goal>download-single</goal>
         </goals>
         <configuration>
            <url>http://download.java.net</url>
            //Edit the BASE URL of your hosted download file
            <fromFile>glassfish/3.1/release/glassfish-3.1.zip</fromFile>
            //Edit the path of your download file content
            <toDir>${project.build.directory}/glassfish</toDir>
            //Provide a directory to save the downloaded file
         </configuration>
      </execution>
   </executions>
</plugin>
```
  ## TODO 
1.  Approaches to create isolated dev and production environment profiles using mvn commandline argument is in progress.
2.  ```mvn deploy``` distribution management argument to be added in pom.xml
