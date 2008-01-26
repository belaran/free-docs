#!/bin/sh
#
# Script to build the slides-show from tex files
#
SRC=../slides
MAIN=tpbuild-slides
WORK=target
PDFLATEX="pdflatex -output-format=pdf -interaction=nonstopmode"

mkdir -p ${WORK}
cd ${WORK}
${PDFLATEX} ${SRC}/${MAIN}.tex
# run twice to build table of content
${PDFLATEX} ${SRC}/${MAIN}.tex
mv ${MAIN}.pdf ..
cd ..
rm -rf ${WORK}
