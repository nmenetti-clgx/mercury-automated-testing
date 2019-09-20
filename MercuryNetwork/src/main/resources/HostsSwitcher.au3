$filePath = $CmdLine[1]&"\hostFiles\"
$env = $CmdLine[2]

if $env = "Dev" then
	Run($filePath&"DevHostSwitcher.bat - Shortcut.lnk")
endif

if $env = "QA" then
	Run($filePath&"NormHostSwitcher.bat - Shortcut.lnk")
endif

if $env = "QA2" then
	Run($filePath&"QA2HostSwitcher.bat - Shortcut.lnk")
endif

if $env = "QA3" then
	Run($filePath&"QA3HostSwitcher.bat - Shortcut.lnk")
endif

if $env = "Beta" then
	Run($filePath&"NormHostSwitcher.bat - Shortcut.lnk")
endif

if $env = "BetaOffline" then
	Run($filePath&"BetaOfflineHostSwitcher.bat - Shortcut.lnk")
endif

if $env = "LiveOffline" then
	Run($filePath&"LiveOfflineHostSwitcher.bat - Shortcut.lnk")
endif

if $env = "Live" then
	Run($filePath&"NormHostSwitcher.bat - Shortcut.lnk")
endif