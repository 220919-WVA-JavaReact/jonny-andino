#!/bin/bash

if [[ $1 =~ [0-9] ]] && [[ $3 =~ [0-9] ]] # trying to validate numbers
then
    if [ $2 == 'x' ] # handle multiplication because i don't like the user having to use \* in bash
    then
        expr $1 \* $3
    else # a regex to validate operands here would be nice
        expr $1 $2 $3
    fi
else
    echo "invalid input"
fi
