# Dependency-Download-in-Maven
Wired up an example to demonstrate maven for managing dependency download through wagon-maven plugin and profile management based on the Operating System type. Approaches to create isolated dev and production environment is in progress.

# Usage
1. Download or clone this repository.
2. Navigate to the repo directory through terminal.
3. Do ```mvn compile``` and ensure successful compilation.
4. Do ```mvn package``` for a succesful build and packaging.
5. Provide the following command 
    ```mvn clean install```
 This will download all the required dependencies as given in pom.xml. 
 To customise the URL and download directory.Modify the plugin as provided in the comment.
 
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
									<url>http://download.java.net</url> //Edit the BASE URL of your hosted download file
									<fromFile>glassfish/3.1/release/glassfish-3.1.zip</fromFile> //Edit the path of your download file content
									<toDir>${project.build.directory}/glassfish</toDir> //Provide a directory to save the downloaded file
								</configuration>
							</execution>
						</executions>
					</plugin> 
        ```  
          
 6. Edit the BASE URL, PATH and DOWNLOAD DIRECTORY in the plugin in pom.xml.
 7. Profile managment based on Operating System and all required profiles are issued in pom.xml.

  
  
