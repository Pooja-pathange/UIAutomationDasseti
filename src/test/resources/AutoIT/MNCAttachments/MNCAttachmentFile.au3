$g_szVersion = "questionnaireMNC"
If WinExists($g_szVersion) Then Exit
WinWait("Open")
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1", @scriptdir & "\Attachment1.xlsx")
ControlClick("Open","","Button1")