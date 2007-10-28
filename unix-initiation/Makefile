#if [ `which uname ` != "" ] ; then
	#
	# Pour *nix
	#
	RM=/bin/rm -rf 
	CP=/bin/cp
	BASEDIR="."
#else
	#
	# Pour Windows
	#
	#RM=/usr/bin/rm
	#CP=/usr/bin/cp
	#BASEDIR="/cygdrive/e/Documents/Esme/PolyGna"
#fi

SRC="00-unix-esme"
TARGETTYPE=pdf
TARGET_DIR=.
PROJECT_NAME=unix-initiation
VERSION=`grep 'newcommand' 00-unix-esme.tex | grep 'docversion'| sed -e 's/\(^.*docversion}{\)\(.*\)\(}.*\$\)/\2/'`
WORK=work
WEBSITE=$(BASEDIR)/website
IMG_DIR=_Images
LATEX=latex
MAKEINDEX=makeindex
DVI2PDF=dvipdfm
EPS2PDF=epstopdf
PDF2LATEX=pdflatex -output-directory=$(WORK) -output-format=pdf -interaction=nonstopmode

IMAGES=	$(IMG_DIR)/ann-edt-vi/delete-cmds.pdf \
	$(IMG_DIR)/ann-edt-vi/insert-cmds.pdf \
	$(IMG_DIR)/ann-edt-vi/move-cmds.pdf \
	$(IMG_DIR)/base-concepts/filters-desc.pdf \
	$(IMG_DIR)/base-concepts/iochans.pdf \
	$(IMG_DIR)/base-concepts/orgdisk.pdf \
	$(IMG_DIR)/basic-notions/exec-cmd.pdf \
	$(IMG_DIR)/basic-notions/out2in.pdf \
	$(IMG_DIR)/basic-notions/stdout-stderr-1.pdf \
	$(IMG_DIR)/basic-notions/stdout-stderr-2.pdf \
	$(IMG_DIR)/basic-notions/stdout-stderr-3.pdf \
	$(IMG_DIR)/cmds-net/exrcp-cl1.pdf \
	$(IMG_DIR)/cmds-net/exrcp-cl2.pdf \
	$(IMG_DIR)/cmds-net/exrcp-cl3.pdf \
	$(IMG_DIR)/cmds-net/exrcp-cl4.pdf \
	$(IMG_DIR)/cmds-net/exrcp.pdf \
	$(IMG_DIR)/cmds-net/ftpconn.pdf \
	$(IMG_DIR)/cmds-net/ftpdesc.pdf \
	$(IMG_DIR)/cmds-net/ftpexch.pdf \
	$(IMG_DIR)/cmds-unix/cat.pdf \
	$(IMG_DIR)/cmds-unix/dotdirs.pdf \
	$(IMG_DIR)/cmds-unix/log-links.pdf \
	$(IMG_DIR)/cmds-unix/rapp-filter.pdf \
	$(IMG_DIR)/cmds-unix/symb-links.pdf

TEXFILES=	00-unix-esme.tex \
		A01-preface.tex \
		A02-conventions.tex \
		B01-int-base-concepts.tex \
		B02-int-cmds-unix.tex \
		B03-int-cmds-network.tex \
		C01-shell-basic-notions.tex \
		C02-shell-multi-task.tex \
		D01-prgm-intro.tex \
		D02-prgm-arguments.tex \
		D03-prgm-variables.tex \
		D04-prgm-adv-cmds.tex \
		D05-prgm-lists-fncts.tex \
		D06-prgm-comments.tex \
		D07-prgm-test-loop.tex \
		D08-prgm-reg-exp.tex \
		D09-prgm-adv-filters.tex \
		D10-prgm-adv-fltrs-sed.tex \
		D11-prgm-adv-fltrs-awk.tex \
		D12-prgm-adv-programming.tex \
		F01-ann-format.tex \
		F02-ann-ex-regexp.tex \
		F03-ann-csh-sh.tex \
		F04-ann-edt-intro.tex \
		F05-ann-edt-vi.tex \
		F06-ann-edt-emacs.tex \
		G01-biblio.tex \
		gpl-2.0.tex

all  :	$(SRC).$(TARGETTYPE)


$(SRC).dvi:	$(IMAGES)	\
		$(TEXFILES)
	$(LATEX)	$(SRC).tex
	$(LATEX)	$(SRC).tex
	$(MAKEINDEX)	$(SRC).idx
	$(LATEX)	$(SRC).tex

$(SRC).pdf:	$(IMAGES)	\
		$(TEXFILES)
	$(LATEX)	$(SRC).tex
	$(LATEX)	$(SRC).tex
	$(MAKEINDEX)	$(SRC).idx
	$(LATEX)	$(SRC).tex

#$(SRC).pdf:	$(SRC).dvi
#	$(DVI2PDF) $<

$(IMAGES) :
	@echo "Building PDF files."
	./_tools/cvt-img.sh $@


site :  	clean
	[ ! -d $(WEBSITE) ] && mkdir $(WEBSITE)
	latex2html -address "<Sylvain Baudry> baudry@esme.fr" -style ./style.css -local_icons -dir ${WEBSITE} $(SRC).tex 
	$(CP) ./_website/*.png ${WEBSITE}
	$(CP) ${WEBSITE}/next.png ${WEBSITE}/next_g.png 
	$(CP) ${WEBSITE}/prev.png ${WEBSITE}/prev_g.png 
	$(CP) ${WEBSITE}/up.png	${WEBSITE}/up_g.png
	$(CP) ./_website/style.css ${WEBSITE}/style.css

pdf :	clean $(IMAGES)
	mkdir $(WORK)
	ln -s $(IMG_DIR) $(WORK)/$(IMG_DIR)
	$(PDF2LATEX) $(SRC).tex
	makeindex $(WORK)/00-unix-esme.idx
	$(PDF2LATEX) $(SRC).tex
	
release:	$(SRC).pdf
	$(CP) 00-unix-esme.pdf $(PROJECT_NAME)-$(VERSION).pdf 

clean :

	if [ "`echo *.aux`" != '*.aux' ]; then $(RM) *.aux; fi
	if [ "`echo *.idx`" != '*.idx' ]; then $(RM) *.idx; fi
	if [ "`echo *.ilg`" != '*.ilg' ]; then $(RM) *.ilg; fi
	if [ "`echo *.ind`" != '*.ind' ]; then $(RM) *.ind; fi
	if [ "`echo *.lof`" != '*.lof' ]; then $(RM) *.lof; fi
	if [ "`echo *.log`" != '*.log' ]; then $(RM) *.log; fi
	if [ "`echo *.lot`" != '*.lot' ]; then $(RM) *.lot; fi
	if [ "`echo *.toc`" != '*.toc' ]; then $(RM) *.toc; fi
	if [ "`echo *.dvi`" != '*.dvi' ]; then $(RM) *.dvi; fi
	if [ "`echo *.out`" != '*.out' ]; then $(RM) *.out; fi
	if [ "`echo *.ps`"  != '*.ps'  ]; then $(RM) *.ps; fi
	if [ "`echo *.pdf`" != '*.pdf' ]; then $(RM) *.pdf; fi
	if [ -d work ]                  ; then $(RM) -rf work; fi
	if [ -d website ]               ; then $(RM) -rf website; fi
