$g_szVersion = "questionnaire"
If WinExists($g_szVersion) Then Exit
WinWait("Open")
ControlFocus("Open"," ","Edit1")
FileExists(@scriptdir & "\QRETemplate.xlsx")
ControlSetText("Open"," ","Edit1", @ScriptDir  & "\QRETemplate.xlsx")
ControlClick("Open"," ","Button1")