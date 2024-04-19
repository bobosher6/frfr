@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\springframework\boot\spring-boot-starter\3.2.4\spring-boot-starter-3.2.4.jar;"%REPO%"\org\springframework\boot\spring-boot\3.2.4\spring-boot-3.2.4.jar;"%REPO%"\org\springframework\spring-context\6.1.5\spring-context-6.1.5.jar;"%REPO%"\org\springframework\spring-aop\6.1.5\spring-aop-6.1.5.jar;"%REPO%"\org\springframework\spring-beans\6.1.5\spring-beans-6.1.5.jar;"%REPO%"\org\springframework\spring-expression\6.1.5\spring-expression-6.1.5.jar;"%REPO%"\io\micrometer\micrometer-observation\1.12.4\micrometer-observation-1.12.4.jar;"%REPO%"\io\micrometer\micrometer-commons\1.12.4\micrometer-commons-1.12.4.jar;"%REPO%"\org\springframework\boot\spring-boot-autoconfigure\3.2.4\spring-boot-autoconfigure-3.2.4.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-logging\3.2.4\spring-boot-starter-logging-3.2.4.jar;"%REPO%"\ch\qos\logback\logback-classic\1.4.14\logback-classic-1.4.14.jar;"%REPO%"\ch\qos\logback\logback-core\1.4.14\logback-core-1.4.14.jar;"%REPO%"\org\apache\logging\log4j\log4j-to-slf4j\2.21.1\log4j-to-slf4j-2.21.1.jar;"%REPO%"\org\apache\logging\log4j\log4j-api\2.21.1\log4j-api-2.21.1.jar;"%REPO%"\org\slf4j\jul-to-slf4j\2.0.12\jul-to-slf4j-2.0.12.jar;"%REPO%"\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;"%REPO%"\org\springframework\spring-core\6.1.5\spring-core-6.1.5.jar;"%REPO%"\org\springframework\spring-jcl\6.1.5\spring-jcl-6.1.5.jar;"%REPO%"\org\yaml\snakeyaml\2.2\snakeyaml-2.2.jar;"%REPO%"\jakarta\xml\bind\jakarta.xml.bind-api\4.0.2\jakarta.xml.bind-api-4.0.2.jar;"%REPO%"\jakarta\activation\jakarta.activation-api\2.1.3\jakarta.activation-api-2.1.3.jar;"%REPO%"\org\junit\jupiter\junit-jupiter-api\5.10.2\junit-jupiter-api-5.10.2.jar;"%REPO%"\org\opentest4j\opentest4j\1.3.0\opentest4j-1.3.0.jar;"%REPO%"\org\junit\platform\junit-platform-commons\1.10.2\junit-platform-commons-1.10.2.jar;"%REPO%"\org\telegram\telegrambots\6.9.7.1\telegrambots-6.9.7.1.jar;"%REPO%"\org\telegram\telegrambots-meta\6.9.7.1\telegrambots-meta-6.9.7.1.jar;"%REPO%"\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.15.4\jackson-datatype-jsr310-2.15.4.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.15.4\jackson-annotations-2.15.4.jar;"%REPO%"\com\fasterxml\jackson\jaxrs\jackson-jaxrs-json-provider\2.15.4\jackson-jaxrs-json-provider-2.15.4.jar;"%REPO%"\com\fasterxml\jackson\jaxrs\jackson-jaxrs-base\2.15.4\jackson-jaxrs-base-2.15.4.jar;"%REPO%"\com\fasterxml\jackson\module\jackson-module-jaxb-annotations\2.15.4\jackson-module-jaxb-annotations-2.15.4.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.15.4\jackson-core-2.15.4.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.15.4\jackson-databind-2.15.4.jar;"%REPO%"\org\glassfish\jersey\inject\jersey-hk2\3.1.5\jersey-hk2-3.1.5.jar;"%REPO%"\org\glassfish\jersey\core\jersey-common\3.1.5\jersey-common-3.1.5.jar;"%REPO%"\org\glassfish\hk2\osgi-resource-locator\1.0.3\osgi-resource-locator-1.0.3.jar;"%REPO%"\org\glassfish\hk2\hk2-locator\3.0.5\hk2-locator-3.0.5.jar;"%REPO%"\org\glassfish\hk2\external\aopalliance-repackaged\3.0.5\aopalliance-repackaged-3.0.5.jar;"%REPO%"\org\glassfish\hk2\hk2-api\3.0.5\hk2-api-3.0.5.jar;"%REPO%"\org\glassfish\hk2\hk2-utils\3.0.5\hk2-utils-3.0.5.jar;"%REPO%"\org\javassist\javassist\3.29.2-GA\javassist-3.29.2-GA.jar;"%REPO%"\org\glassfish\jersey\media\jersey-media-json-jackson\3.1.5\jersey-media-json-jackson-3.1.5.jar;"%REPO%"\org\glassfish\jersey\ext\jersey-entity-filtering\3.1.5\jersey-entity-filtering-3.1.5.jar;"%REPO%"\com\fasterxml\jackson\module\jackson-module-jakarta-xmlbind-annotations\2.15.4\jackson-module-jakarta-xmlbind-annotations-2.15.4.jar;"%REPO%"\org\glassfish\jersey\containers\jersey-container-grizzly2-http\3.1.5\jersey-container-grizzly2-http-3.1.5.jar;"%REPO%"\jakarta\inject\jakarta.inject-api\2.0.1\jakarta.inject-api-2.0.1.jar;"%REPO%"\org\glassfish\grizzly\grizzly-http-server\4.0.1\grizzly-http-server-4.0.1.jar;"%REPO%"\org\glassfish\grizzly\grizzly-http\4.0.1\grizzly-http-4.0.1.jar;"%REPO%"\org\glassfish\grizzly\grizzly-framework\4.0.1\grizzly-framework-4.0.1.jar;"%REPO%"\jakarta\ws\rs\jakarta.ws.rs-api\3.1.0\jakarta.ws.rs-api-3.1.0.jar;"%REPO%"\org\glassfish\jersey\core\jersey-server\3.1.5\jersey-server-3.1.5.jar;"%REPO%"\org\glassfish\jersey\core\jersey-client\3.1.5\jersey-client-3.1.5.jar;"%REPO%"\jakarta\validation\jakarta.validation-api\3.0.2\jakarta.validation-api-3.0.2.jar;"%REPO%"\org\apache\httpcomponents\httpclient\4.5.14\httpclient-4.5.14.jar;"%REPO%"\org\apache\httpcomponents\httpcore\4.4.16\httpcore-4.4.16.jar;"%REPO%"\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;"%REPO%"\commons-codec\commons-codec\1.16.1\commons-codec-1.16.1.jar;"%REPO%"\org\apache\httpcomponents\httpmime\4.5.14\httpmime-4.5.14.jar;"%REPO%"\commons-io\commons-io\2.15.1\commons-io-2.15.1.jar;"%REPO%"\org\slf4j\slf4j-api\2.0.12\slf4j-api-2.0.12.jar;"%REPO%"\org\projectlombok\lombok\1.18.30\lombok-1.18.30.jar;"%REPO%"\org\telegram\telegrambots-spring-boot-starter\6.7.0\telegrambots-spring-boot-starter-6.7.0.jar;"%REPO%"\org\junit\jupiter\junit-jupiter-engine\5.10.2\junit-jupiter-engine-5.10.2.jar;"%REPO%"\org\junit\platform\junit-platform-engine\1.10.2\junit-platform-engine-1.10.2.jar;"%REPO%"\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;"%REPO%"\org\telegram\telegrambots-abilities\6.7.0\telegrambots-abilities-6.7.0.jar;"%REPO%"\org\apache\commons\commons-lang3\3.13.0\commons-lang3-3.13.0.jar;"%REPO%"\com\google\guava\guava\31.1-jre\guava-31.1-jre.jar;"%REPO%"\com\google\guava\failureaccess\1.0.1\failureaccess-1.0.1.jar;"%REPO%"\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;"%REPO%"\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;"%REPO%"\org\checkerframework\checker-qual\3.12.0\checker-qual-3.12.0.jar;"%REPO%"\com\google\errorprone\error_prone_annotations\2.11.0\error_prone_annotations-2.11.0.jar;"%REPO%"\com\google\j2objc\j2objc-annotations\1.3\j2objc-annotations-1.3.jar;"%REPO%"\org\mapdb\mapdb\3.0.8\mapdb-3.0.8.jar;"%REPO%"\org\jetbrains\kotlin\kotlin-stdlib\1.9.23\kotlin-stdlib-1.9.23.jar;"%REPO%"\org\jetbrains\annotations\13.0\annotations-13.0.jar;"%REPO%"\org\eclipse\collections\eclipse-collections-api\12.0.0.M3\eclipse-collections-api-12.0.0.M3.jar;"%REPO%"\org\eclipse\collections\eclipse-collections\12.0.0.M3\eclipse-collections-12.0.0.M3.jar;"%REPO%"\org\eclipse\collections\eclipse-collections-forkjoin\12.0.0.M3\eclipse-collections-forkjoin-12.0.0.M3.jar;"%REPO%"\net\jpountz\lz4\lz4\1.3.0\lz4-1.3.0.jar;"%REPO%"\org\mapdb\elsa\3.0.0-M5\elsa-3.0.0-M5.jar;"%REPO%"\io\project\SpringDemoBoot\0.0.1-SNAPSHOT\SpringDemoBoot-0.0.1-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="SpringDemoBoot" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" com.home.server.SpringDemoBoot %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
