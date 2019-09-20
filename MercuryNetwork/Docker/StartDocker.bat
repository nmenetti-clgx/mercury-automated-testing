cd /D "%~dp0"
ECHO "Start Docker"
set COMPOSE_CONVERT_WINDOWS_PATHS=1
docker-compose up -d
exit