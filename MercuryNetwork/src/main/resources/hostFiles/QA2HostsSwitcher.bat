@ECHO OFF

DEL %WINDIR%\SYSTEM32\DRIVERS\ETC\HOSTS

COPY %~dp0QA2Hosts.txt %WINDIR%\SYSTEM32\DRIVERS\ETC\hosts

IPCONFIG /FLUSHDNS

exit