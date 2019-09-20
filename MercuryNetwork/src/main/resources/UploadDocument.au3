$filePath = $CmdLine[1]&"testDocuments\"
$fileName = $CmdLine[2]

$Firefox = "File Upload"
$IE = "Choose File to Upload"
$Chrome = "Open"

if WinExists($Firefox) then
  $UploadWindow = $Firefox
elseif WinExists($IE) then
	$UploadWindow = $IE
elseif WinExists($Chrome) then
  $UploadWindow = $Chrome
else
  $UploadWindow = ""
endif

if $UploadWindow <> "" then
	ControlFocus($UploadWindow,"","Edit1")
	ControlClick($UploadWindow,"","Edit1")
	ControlSetText($UploadWindow,"","Edit1",$filePath&$fileName)
	ControlClick($UploadWindow,"","Button1")
endif