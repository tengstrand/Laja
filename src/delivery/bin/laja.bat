@REM ----------------------------------------------------------------------------
@REM Laja Start Up Batch script
@REM
@REM Required ENV vars:
@REM JAVA_HOME - location of a JDK home dir
@REM
@REM Optional ENV vars
@REM LAJA_HOME - location of Laja's installed home dir
@REM LAJA_OPTS - parameters passed to the Java VM when running Laja
@REM     e.g. to debug Laja itself, use
@REM set LAJA_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
@REM ----------------------------------------------------------------------------

@echo off

set ERROR_CODE=0

if not "%JAVA_HOME%" == "" goto OkJHome

echo.
echo ERROR: JAVA_HOME not found in your environment.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation
echo.
goto error

:OkJHome
if exist "%JAVA_HOME%\bin\java.exe" goto chkHome

echo.
echo ERROR: JAVA_HOME is set to an invalid directory.
echo JAVA_HOME = "%JAVA_HOME%"
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation
echo.
goto error

:chkHome
if not "%LAJA_HOME%"=="" goto valHome

if "%OS%"=="Windows_NT" SET "LAJA_HOME=%~dp0.."
if "%OS%"=="WINNT" SET "LAJA_HOME=%~dp0.."
if not "%LAJA_HOME%"=="" goto valHome

echo.
echo ERROR: LAJA_HOME not found in your environment.
echo Please set the LAJA_HOME variable in your environment to match the
echo location of the Laja installation
echo.
goto error

:valHome

:stripHome
if not "_%LAJA_HOME:~-1%"=="_\" goto checkBat
set "LAJA_HOME=%LAJA_HOME:~0,-1%"
goto stripHome

:checkBat
if exist "%LAJA_HOME%\bin\laja.bat" goto init

echo.
echo ERROR: LAJA_HOME is set to an invalid directory.
echo LAJA_HOME = "%LAJA_HOME%"
echo Please set the LAJA_HOME variable in your environment to match the
echo location of the Laja installation
echo.
goto error
@REM ==== END VALIDATION ====

:init
@REM Decide how to startup depending on the version of windows

@REM -- Windows NT with Novell Login
if "%OS%"=="WINNT" goto WinNTNovell

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

:WinNTNovell

@REM -- 4NT shell
if "%@eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set LAJA_CMD_LINE_ARGS=%*
goto endInit

@REM The 4NT Shell from jp software
:4NTArgs
set LAJA_CMD_LINE_ARGS=%$
goto endInit

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of agruments (up to the command line limit, anyway).
set LAJA_CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto endInit
set LAJA_CMD_LINE_ARGS=%LAJA_CMD_LINE_ARGS% %1
shift
goto Win9xApp

@REM Reaching here means variables are defined and arguments have been captured
:endInit
SET LAJA_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
set LAJA_CLASSPATH=

for %%i in (%LAJA_HOME%\lib\*.jar) do call cpappend.bat %%i 
for %%i in (%LAJA_HOME%\system-lib\*.jar) do call cpappend.bat %%i 

@REM Start LAJA
:runlaja
%LAJA_JAVA_EXE% %LAJA_OPTS% -classpath %LAJA_CLASSPATH% "-Dlaja.home=%LAJA_HOME%" net.sf.laja.launch.LajaLauncher %LAJA_CMD_LINE_ARGS%

if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
if "%OS%"=="WINNT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT
if "%OS%"=="WINNT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set LAJA_JAVA_EXE=
set LAJA_CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal & set ERROR_CODE=%ERROR_CODE%

if "%LAJA_TERMINATE_CMD%" == "on" exit %ERROR_CODE%

cmd /C exit /B %ERROR_CODE%
