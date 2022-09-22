#!/bin/bash

#extract logic into functions for readability and reuseability
get_names() {
    echo 'Please enter your First and Last Name, separated by a space:'
    read firstname lastname
}

get_email() {
    echo 'Please register an email:'
    read email
    # validate that email does not exist in database
    # validate that email is formatted correctly
}

get_username() {
    echo 'Enter a new Username:'
    read username
    # validate that usernames do not already exist in database
}

get_password () {    
    echo 'Enter a new Password: (input will be invisible)'
    read -s password
    echo 'Please re-enter password.'
    read -s password2

    if [ $password == $password2 ] 
    then
        echo 'sucessfully saved password'
    else
        echo 'Error: Passwords do not match. Please try again'
        get_password
    fi

    # bonus: validate passwords to have a certain level of complexity eg: "one character and one number and one symbol... ect"
    # bonus: encrypt passwords
}

# take in a firstname, lastname, username, password and email
get_names
get_username
get_email
get_password

#validate that the info is correct
echo "--------------------------------"
echo "Name: ${firstname} ${lastname}"
echo "Username: ${username}"
echo "Password: *****"
echo "email: ${email}"


#save this information to a csv file