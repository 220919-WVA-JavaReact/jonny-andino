#!/bin/bash
operand=$2

case $operand in 
    +)
        let result=$1+$3
        ;;
    -)
        let result=$1-$3
        ;;
    "x")
        let result="${1}*${3}"
        ;;
    "/")
        let result="${1}/${3}"
        ;;
    *)
        result="invalid input"
        ;;
esac

echo $result
