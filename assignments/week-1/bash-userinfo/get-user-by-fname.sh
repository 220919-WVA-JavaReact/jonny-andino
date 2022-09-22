#!/bin/bash

fname=${2}

sh parser.sh ${1} | grep "First Name: ${fname}";