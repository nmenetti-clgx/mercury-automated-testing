@ECHO OFF

DEL %WINDIR%\SYSTEM32\DRIVERS\ETC\HOSTS

COPY %~dp0BetaPush1Hosts.txt %WINDIR%\SYSTEM32\DRIVERS\ETC\hosts

IPCONFIG /FLUSHDNS

exit