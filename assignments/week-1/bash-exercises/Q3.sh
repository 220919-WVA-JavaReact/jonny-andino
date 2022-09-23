#!/bin/bash

fact(){
    if (( $1 <= 1 ))
    then
        echo 1
    else
        prev=$(fact $(( $1 - 1 )))
        echo $(( $1 * prev ))
    fi
}
result=$(fact $1)
echo "The factorial of ${1} is: $result"