@ECHO OFF
:loop
  cls
  %*
  timeout /T 0.1 > NUL
goto loop
