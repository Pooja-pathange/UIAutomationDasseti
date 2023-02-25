
$g_szVersion = "File Upload"
If WinExists($g_szVersion) Then Exit

WinWait("Open")

ControlFocus("Open","","Edit1")

ControlSetText("Open","","Edit1",@WorkingDir,& '\Document.xlsx')

ControlClick("Open","","Button1")
