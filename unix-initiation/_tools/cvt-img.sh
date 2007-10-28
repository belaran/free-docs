#!/bin/sh
for file in $*
do
	fileType=`basename $file | awk --field-separator=. '{print $NF}' | tr '[A-Z]' '[a-z]'`
	case $fileType in
		eps)
			pdf="`echo $file | sed -e 's/\.eps$/\.pdf/'`"
			if [ "$file" -nt "$pdf" ]; then
				echo "`basename $0`: processing epstopdf $file -> $pdf"
				epstopdf $file
			fi
			;;
		pdf)
			eps="`echo $file | sed -e 's/\.pdf$/\.eps/'`"
			if [ -f "$eps" ]; then
				if [ "$file" -ot "$eps" ]; then
					echo "`basename $0`: processing epstopdf $eps -> $file"
					epstopdf $eps
				fi
			else
				echo "`basename $0`: cannot find $eps"
			fi
			;;
	esac
done
