$g_szVersion = "ResponseImport"
If WinExists($g_szVersion) Then Exit
WinWait("Open")
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1", @scriptdir & "\Document.xlsx")
ControlClick("Open","","Button1")