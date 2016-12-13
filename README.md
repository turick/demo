<p>This simple web app demonstrates a couple of things:<p>

<ol>
<li>A simple user-defined property in a spring profile is not available to the environment when no active profiles are specified and the profile is activated by default.</li>
<li>Assuming the entire profile is unavailable, I wanted to demonstrate that using "short" command line properties that are defined in the profile also fails.  This caused quite some confusion when the properties came from module autoconfiguration (ie, server.port), so I included an example of this as well.</li>
</ol>

<p>For this project, the application.yml has 2 noteworthy properties in a test profile:  "my.very.long.property" and "server.port".  The following is observed when running the project from the command line:</p>

<ol>
<li>java -jar demo-0.0.1-SNAPSHOT.jar - my.very.long.property is null and server port is 8080</li>
<li>java -Dport=8082 -Dprop=bar -jar demo-0.0.1-SNAPSHOT.jar - property is null and server port is 8080</li>
<li>java -Dserver.port=8082 -Dmy.very.long.property=bar -jar demo-0.0.1-SNAPSHOT.jar - property is bar and server port is 8082</li>
<li>java -Dport=8082 -Dprop=bar -Dspring.profiles.active=test-profile -jar demo-0.0.1-SNAPSHOT.jar - property is bar and server port is 8082</li>
