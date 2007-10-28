@echo off
set LATEX="latex"
set DVIPS="dvips"
set GSWIN="D:\Program Files\gstools\gs5.50\gswin32"
if not exist unix-esme.dvi goto latex
:dvips
if not exist unix-esme.ps dvips unix-esme.dvi
if not exist unix-esme.pdf %GSWIN% -q -dNOPAUSE -dBATCH -sDEVICE#pdfwrite -sOutputFile#unix-esme.pdf unix-esme.ps
goto end

:latex
%LATEX% unix-esme.tex
%LATEX% unix-esme.tex
goto dvips

:end