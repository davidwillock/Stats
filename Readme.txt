







mvn package -- compile test and deploy with maven


git init


git add .


git config --global user.email "david.willock@hotmail.com"

git commit  -m  "first commit"




//D:\tmp\dev\prj\Jfunds>git remote add origin https://github.com/charlieanthonywillock/Data.git


if error origin already exists

git remote rm origin

Again "origin" is the name of the remote repository if you want to remove the "upstream" remote:

git remote rm upstream



https://github.com/davidwillock/Stats.git
git remote add origin https://github.com/davidwillock/Stats.git
git push -u origin master










WEB APP RUNNER

/*****************************************************************************************************************************************************/

<plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>2.3</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals><goal>copy</goal></goals>
                    <configuration>
                        <artifactItems>
                            <artifactItem>
                                <groupId>com.github.jsimone</groupId>
                                <artifactId>webapp-runner</artifactId>
                                <version>8.5.11.3</version>
                                <destFileName>webapp-runner.jar</destFileName>
                            </artifactItem>
                        </artifactItems>
                    </configuration>
                </execution>
            </executions>
        </plugin>



/**********************************************************************************************************************************************************



echo web: java $JAVA_OPTS -jar target/dependency/webapp-ru
nner.jar /target/MutualFundsWebApp.war > Procfile



Deploy to Heroku

Commit your changes to Git:

git init

git add .

git commit -m "Ready to deploy"


**************** heroku login !!!!

heroku login

Create the app:



D:\tmp\dev\prj\Jfunds>p https://github.com/charlieanthonywillock/MFund.git






heroku create








Creating high-lightning-129... done, stack is cedar-14
http://high-lightning-129.herokuapp.com/ | git@heroku.com:high-lightning-129.git
Git remote heroku added

Deploy your code:

git push heroku master




Counting objects: 227, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (117/117), done.
Writing objects: 100% (227/227), 101.06 KiB, done.
Total 227 (delta 99), reused 220 (delta 98)

-----> Heroku receiving push
-----> Java app detected
-----> Installing Maven 3.0.3..... done
-----> executing .maven/bin/mvn -B -Duser.home=/tmp/build_1jems2so86ck4 -DskipTests=true clean install
       [INFO] Scanning for projects...
       [INFO]
       [INFO] ------------------------------------------------------------------------
       [INFO] Building webappRunnerSample Maven Webapp 1.0-SNAPSHOT
       [INFO] ------------------------------------------------------------------------
       ...
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD SUCCESS
       [INFO] ------------------------------------------------------------------------
       [INFO] Total time: 36.612s
       [INFO] Finished at: Tue Aug 30 04:03:02 UTC 2011
       [INFO] Final Memory: 19M/287M
       [INFO] ------------------------------------------------------------------------
-----> Discovering process types
       Procfile declares types -> web
-----> Compiled slug size is 4.5MB
-----> Launching... done, v5
       http://pure-window-800.herokuapp.com deployed to Heroku

Congratulations! Your web app should now be up and running on Heroku. Open it in your browser with:

heroku open

Deploying with the Heroku Maven Plugin

In lieu of Git deployment, you may use the Heroku Maven Plugin to deploy applications with webapp-runner. The setup for the Maven plugin is similar to what is described in this article, but there are a few key differences. In your pom.xml you will need to replace the maven-dependency-plugin with the heroku-maven-plugin and provide the proper configuration. Then, instead of deploying with a git push you will deploy with a mvn heroku:deploy-war command.
Use distributed HTTP sessions with Memcache

Explicitly storing session state in a database or other backend data store is a more scalable alternative to using distributed HTTP sessions. To find out if distributed HTTP sessions are the best design choice for your application see the article on distributed HTTP sessions.

Webapp runner supports the memcached-session-manager for Tomcat. In order to enable memcache backed sessions you need to make the configuration for your memcache instance available through environment variables and then enable the sesssion manager.
Make memcache configuration information available

The Heroku Memcachier Add On will set the required environment variables for you. Once you have an existing app get the add on by running:

heroku addons:create memcachier:dev

Note: you may have to verify your account before you can add this add on.

When running locally you can either set up a local install of memcache or connect to the remote memcache service provisioned for you by the Heroku add on.

When used with webapp runner the memcache backed session manager looks for 3 environment variables: MEMCACHIER_SERVERS, MEMCACHIER_USERNAME, MEMCACHIER_PASSWORD. You can set these to point to a local memcache install or connect to the remote memcache service provisioned for you by the Heroku add on by running heroku config and copying the values into local environment variables.
Enable memcached-session-manager

To enable memcache backed sessions with webapp runner you include the following flag: --session-store memcache

So if launching locally your command would now look like:

java -jar target/dependency/webapp-runner.jar --session-store memcache target/*.war

Or your Procfile would look like: create file called Procfile and insert the below into file and save

web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT --session-store memcache target/*.war

Clone the source

If you want to skip the creation steps you can clone the finished sample (without memcache backed session):




git clone git@github.com:heroku/devcenter-webapp-runner.git



heroku open



D:\tmp\dev\prj\Jfunds>java -jar target/dependency/webapp-runner.jar /target/MutualFundsWebApp.war


















Keep reading


***************************************************************************************************************************************************
etlApp


C:\home\charlie\Develop\Java\oxygen_workspace\etlApp>git init
Reinitialized existing Git repository in C:/home/charlie/Develop/Java/oxygen_workspace/etlApp/.git/

C:\home\charlie\Develop\Java\oxygen_workspace\etlApp>git add .

C:\home\charlie\Develop\Java\oxygen_workspace\etlApp>git commit -m "appended parse via validation only and write to csv"
[master 039b8ac] appended parse via validation only and write to csv
 28 files changed, 666 insertions(+), 24 deletions(-)
 create mode 100644 src/main/java/com/charlie1/etl/model/journalData.java
 create mode 100644 src/main/java/com/charlie1/etl/model/selectJournal.java
 create mode 100644 src/main/java/com/charlie1/etldos/bulkInsert.java
 create mode 100644 src/main/java/com/charlie1/etlvalidatejournal/validateJournal.java
 create mode 100644 src/main/java/com/charlie1/etlwriteto/writetoDisk.java
 create mode 100644 target/classes/com/charlie1/etl/dao/impl/JdbcFundsDAO$9.class
 create mode 100644 target/classes/com/charlie1/etl/model/journalData.class
 create mode 100644 target/classes/com/charlie1/etl/model/selectJournal.class
 rewrite target/classes/com/charlie1/etlparsefolders/parseFolders.class (95%)
 create mode 100644 target/classes/com/charlie1/etlvalidatejournal/validateJournal.class
 create mode 100644 target/classes/com/charlie1/etlwriteto/writetoDisk.class

C:\home\charlie\Develop\Java\oxygen_workspace\etlApp>git push -u origin master
Counting objects: 60, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (45/45), done.
Writing objects: 100% (60/60), 17.00 KiB | 1.13 MiB/s, done.
Total 60 (delta 20), reused 0 (delta 0)
remote: Resolving deltas: 100% (20/20), completed with 20 local objects.
To https://github.com/davidwillock/etlapp.git
   fabf2b4..039b8ac  master -> master
Branch master set up to track remote branch master from origin.

C:\home\charlie\Develop\Java\oxygen_workspace\etlApp>git push -u origin master



To deploy locally or on Heroku!!!


So if launching locally your command would now look like:

java -jar target/dependency/webapp-runner.jar --session-store memcache target/*.war

Or your Procfile would look like:...... create file called Procfile and insert the below into file and save

web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT --session-store memcache target/*.war
















