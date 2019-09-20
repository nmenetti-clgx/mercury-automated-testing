/c echo @FILE
forfiles -p "C:\Code\VMP\automatedtesting\SeleniumTestResults" -s -m *.* /D -28 /C "cmd /c del @path"