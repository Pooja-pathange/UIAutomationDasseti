$g_szVersion = "ResponseImport"
If WinExists($g_szVersion) Then Exit
WinWait("Open")
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1", @scriptdir & "\ResponseImport_SLGI.xlsx")
ControlClick("Open","","Button1")