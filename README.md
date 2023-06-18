

# Throwable Utility

![Visit Count](https://profile-counter.glitch.me/TurquoiseSpace_throwable-utility/count.svg)


Java's Throwable JSON Transformer Module

[![Maven Central](https://img.shields.io/maven-central/v/com.github.TurquoiseSpace/throwable-utility.svg?label=Maven%20Central)](https://repo1.maven.org/maven2/com/github/TurquoiseSpace/throwable-utility/)

[![Java Doc](https://javadoc.io/badge2/com.github.TurquoiseSpace/throwable-utility/javadoc.svg)](https://javadoc.io/doc/com.github.TurquoiseSpace/throwable-utility)

[![GitHub (All Releases)](https://img.shields.io/github/downloads/TurquoiseSpace/throwable-utility/total?color=blue)](https://repo1.maven.org/maven2/com/github/TurquoiseSpace/throwable-utility/)

[![GitHub (Latest Release)](https://img.shields.io/github/downloads/TurquoiseSpace/throwable-utility/throwable-utility-0.0.8/total)](https://repo1.maven.org/maven2/com/github/TurquoiseSpace/throwable-utility/0.0.8/)


[Maven Central Sonatype Search](https://central.sonatype.com/artifact/com.github.TurquoiseSpace/throwable-utility)

[MVN Repository](https://mvnrepository.com/artifact/com.github.TurquoiseSpace/throwable-utility)

[Nexus Repository Manager](https://oss.sonatype.org/#nexus-search;quick~throwable-utility)



## Include as Dependency


- Maven

```
<dependency>
    <groupId>com.github.TurquoiseSpace</groupId>
    <artifactId>throwable-utility</artifactId>
    <version>0.0.8</version>
</dependency>
```

- Gradle

```
implementation group: 'com.github.TurquoiseSpace', name: 'throwable-utility', version: '0.0.8'
```

- Gradle (Short)

```
implementation 'com.github.TurquoiseSpace:throwable-utility:0.0.8'
```

- Gradle (Kotlin)

```
implementation("com.github.TurquoiseSpace:throwable-utility:0.0.8")
```



## Code Usage


- Import the class

```
import com.TurquoiseSpace.utility.ExceptionLogUtil;
```

- Call one of the static methods

```
ExceptionLogUtil.logException(exception);
```

```
String exceptionJson = ExceptionLogUtil.getExceptionJson(exception);
```



## Description


The main Utility class `ExceptionLogUtil.java` actually logs the Exception in JSON format, for better readibilty, or gives the Throwable JSON.

The other Utility class `JsonUtil.java` is meant for mapping any Object to JSON, or vice versa.

Can be easily viewed in AWS Cloud Watch or DataDog or Splunk.

Easy to search, by providing whole paragraph of Exception log in one single line.



## KeyWords for searching in Application Logs


```
Encountered Throwable
```

```
Parsed Throwable
```

```
exceptionTraceHeirarchy
```

```
exceptionMeta
```



## Structure of the Repository


The actual code is located inside

	./src/main/java/

with the base package as

	com.TurquoiseSpace

and child packages (shows the call heirarchy from top to bottom)
and in java files

	utility
		ExceptionLogUtil.java
		ThrowableLogUtil.java
		JsonUtil.java
	constant
		ExceptionConstants.java
		ErrorConstants.java
		ThrowableConstants.java
	model
		GenericException.java
		ExceptionMeta.java
		ExceptionPoint.java



## GPG Keys


- Check existing GPG Keys

```
gpg --list-secret-keys --keyid-format LONG
```

- Generate GPG Key

```
gpg --gen-key
```

- Receive GPG Key from Servers

```
gpg --keyserver hkp://keyserver.ubuntu.com --recv-keys 876A6DD3FB3573F1
gpg --keyserver hkp://keys.openpgp.org --recv-keys 876A6DD3FB3573F1
gpg --keyserver hkp://pgp.mit.edu --recv-keys 876A6DD3FB3573F1
```

- Send GPG Key to Servers

```
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys 876A6DD3FB3573F1
gpg --keyserver hkp://keys.openpgp.org --send-keys 876A6DD3FB3573F1
gpg --keyserver hkp://pgp.mit.edu --send-keys 876A6DD3FB3573F1
```



## Build


- Normal Sanity

```
mvn -Dmaven.artifact.threads=25 clean eclipse:eclipse -DdownloadSources=true dependency:go-offline dependency:resolve-plugins install -e
```

- With OSSRH Sonatype

```
mvn -Dmaven.artifact.threads=25 clean eclipse:eclipse -DdownloadSources=true dependency:go-offline install --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml
```



## Publish Artifact

```
mvn deploy --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml
```


